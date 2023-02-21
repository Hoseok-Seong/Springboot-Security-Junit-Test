package shop.mtcoding.loginexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.loginexample.dto.UserReqDto.JoinReqDto;
import shop.mtcoding.loginexample.dto.UserReqDto.LoginReqDto;
import shop.mtcoding.loginexample.model.User;
import shop.mtcoding.loginexample.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @GetMapping({ "/joinForm", "/" })
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(JoinReqDto joinReqDto) {
        userService.가입하기(joinReqDto);
        return "redirect:/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(LoginReqDto loginReqDto) {
        User principal = userService.로그인하기(loginReqDto);

        session.setAttribute("principal", principal);

        return "redirect:/main";
    }

}
