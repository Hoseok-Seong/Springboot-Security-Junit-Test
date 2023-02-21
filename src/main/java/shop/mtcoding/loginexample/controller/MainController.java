package shop.mtcoding.loginexample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private HttpSession session;

    @GetMapping("/main")
    public String main(Exception e) {
        // User principal = (User) session.getAttribute("principal");
        // if (principal == null) {
        // return "redirect:/loginForm";
        // }
        System.err.println(e.getMessage());
        return "main";
    }
}
