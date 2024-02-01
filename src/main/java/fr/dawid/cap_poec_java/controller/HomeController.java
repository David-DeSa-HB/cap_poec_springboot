package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.mapping.UrlRoute;
import fr.dawid.cap_poec_java.service.ReviewService;
import fr.dawid.cap_poec_java.utils.ExcelReviewService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class HomeController {

    private ReviewService reviewService;
    private ExcelReviewService excelService;

    @GetMapping("/")
    public ModelAndView index(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "createdAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        if (principal == null) {
            mav.setViewName("redirect:/s-inscrire");
            return mav;
        }
        mav.addObject("pageReviews", reviewService.getPageReviewByNickname(principal.getName(), pageable));
        mav.setViewName("index");
        return mav;
    }

    @GetMapping(UrlRoute.URL_EXPORT)
    public void downloadExcel(HttpServletResponse response) {
        try {
            File file = excelService.writeExcel();
            ByteArrayInputStream excelToByte = new ByteArrayInputStream(
                    Files.readAllBytes(Paths.get(file.getAbsolutePath()))
            );
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
            IOUtils.copy(excelToByte, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
