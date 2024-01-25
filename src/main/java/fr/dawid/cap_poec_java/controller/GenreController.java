package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;

    @GetMapping("/genres")
    public ModelAndView view(ModelAndView mav){
        mav.setViewName("genres");
        mav.addObject("genre", genreService.findAll());
        return mav;
    }
}
