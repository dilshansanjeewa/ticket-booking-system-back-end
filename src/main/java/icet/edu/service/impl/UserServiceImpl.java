package icet.edu.service.impl;

import icet.edu.model.dto.UserDTO;
import icet.edu.model.entity.User;
import icet.edu.repository.UserRepository;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public void save(UserDTO user) {
        userRepository.save(mapper.map(user, User.class));
    }

    @Override
    public User findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        return user;
    }
}
