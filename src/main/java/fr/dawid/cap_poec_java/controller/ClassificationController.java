package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.service.ClassificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ClassificationController {

    private ClassificationService classificationService;

    @GetMapping("/classifications")
    public ModelAndView view(ModelAndView mav){
        mav.setViewName("classifications");
        mav.addObject("classification", classificationService.findAll());
        return mav;
    }
}
