package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.service.BusinessModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BusinessModelController {

    private BusinessModelService businessModelService;

    @GetMapping("/business-models")
    public ModelAndView view(ModelAndView mav){
        mav.setViewName("business_models/business_models");
        mav.addObject("business_model", businessModelService.findAll());
        return mav;
    }
}
