package icet.edu.controller;

import icet.edu.model.dto.UserDTO;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("user/test")
    public String test(){
        System.out.println("test Success");
        return "user test Success";
    }

    @PostMapping("user/new")
    public void save(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Alice Chen");
        userDTO.setTitle("PLATINUM");
        userDTO.setEmail("alice.chen@example.com");
        userService.save(userDTO);

    }
}
