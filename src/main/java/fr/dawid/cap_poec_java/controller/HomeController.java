package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomeController {

    private UserService userService;

    @GetMapping("/")
    public ModelAndView view(ModelAndView mav){
        mav.setViewName("index");
        mav.addObject("user", userService.getObjectById(1L));
        return mav;
    }
}
