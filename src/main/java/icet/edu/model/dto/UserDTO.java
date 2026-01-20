package icet.edu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String title;
    private String email;
}
