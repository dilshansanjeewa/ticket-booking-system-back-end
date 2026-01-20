package icet.edu.service;

import icet.edu.model.dto.UserDTO;
import icet.edu.model.entity.User;

public interface UserService {
    void save(UserDTO user);

    User findById(Long userId);
}
