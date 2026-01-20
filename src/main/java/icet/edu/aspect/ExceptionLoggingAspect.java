package icet.edu.aspect;

import icet.edu.model.entity.AuditLogs;
import icet.edu.repository.AuditLogsRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@RequiredArgsConstructor

@Aspect
@Component
public class ExceptionLoggingAspect {

    private final AuditLogsRepository auditLogsRepository;

    @AfterThrowing(pointcut = "@annotation(icet.edu.annotation.AuditFailure)", throwing = "ex")
    public void logAuditLogsToDatabase(JoinPoint joinPoint, Throwable ex){
        String className = joinPoint.getTarget().getClass().getSimpleName();

        Long userId = null;
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Long) {
            // Heuristic: Assume first Long arg is userId (adjust for your app)
            userId = (Long) args[0];
        }

        saveLog(className, userId, ex);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(String className, Long userId, Throwable ex) {
        AuditLogs auditLogs = new AuditLogs();
        auditLogs.setAction(className);
        auditLogs.setUserId(userId);
        auditLogs.setDetails(ex.getMessage());
        auditLogs.setTimestamp(Instant.now());
        System.out.println(auditLogs);
        auditLogsRepository.save(auditLogs);
        System.out.println("Error logged to DB: " + ex.getMessage());
    }
}
