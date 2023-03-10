package shop.mtcoding.loginexample.dto;

import lombok.Getter;
import lombok.Setter;

public class UserReqDto {

    @Setter
    @Getter
    public static class JoinReqDto {
        private String username;
        private String password;
        private String email;
    }

    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }
}
