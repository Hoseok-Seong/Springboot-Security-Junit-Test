package shop.mtcoding.loginexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.loginexample.model.User;

@Controller
public class MainController {
    @Autowired
    private HttpSession session;

    @GetMapping("/main")
    public String main() {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/loginForm";
        }
        return "main";
    }
}
