package com.ead.authuser.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserView{
        public static interface RegistrationPost{}
        public static interface UserPut{}
        public static interface PasswordPut{}
        public static interface ImagePut{}
    }
//    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private UUID userId;
    @NotBlank(groups = UserView.RegistrationPost.class)
    @Size(min=4, max=50)
    @JsonView(UserView.RegistrationPost.class)
    private String username;
    @NotBlank(groups = UserView.RegistrationPost.class)
    @Size(min=4, max=50)
    @Email
    @JsonView(UserView.RegistrationPost.class)
    private String email;
    @NotBlank(groups = {UserView.RegistrationPost.class,UserView.PasswordPut.class })
    @Size(min=6, max=20)
    @JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class})
    private String password;

    @NotBlank(groups = UserView.PasswordPut.class)
    @Size(min=6, max=20)
    @JsonView(UserView.PasswordPut.class)
    private String oldpassword;
    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String fullName;
    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String phoneNumber;
    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String cpf;
    @NotBlank(groups = UserView.ImagePut.class)
    @JsonView( UserView.ImagePut.class)
    private String imageUrl;

}
