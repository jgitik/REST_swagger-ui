package rest.configuration.dto;

import rest.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private String name;
    private String password;
    private String email;
    private Integer age;


    public UserDto(UserEntity userEntity) {
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.age = userEntity.getAge();
    }

    public UserEntity toUserEntity(UserDto userDto) {
        return new UserEntity(this.email, this.name, this.password, this.age);
    }
}

