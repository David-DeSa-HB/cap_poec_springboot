package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.service.PlatformService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class PlatformController {

    private PlatformService platformService;

    @GetMapping("/platforms")
    public ModelAndView view(ModelAndView mav){
        mav.setViewName("platforms");
        mav.addObject("platform", platformService.findAll());
        return mav;
    }
}
