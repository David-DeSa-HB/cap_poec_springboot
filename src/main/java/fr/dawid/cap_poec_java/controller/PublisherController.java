package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class PublisherController {

    private PublisherService publisherService;

    @GetMapping("/publishers")
    public ModelAndView view(ModelAndView mav){
        mav.setViewName("index");
        mav.addObject("publisher", publisherService.findAll());
        return mav;
    }
}
