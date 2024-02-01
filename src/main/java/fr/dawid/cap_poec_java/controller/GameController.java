package fr.dawid.cap_poec_java.controller;

import fr.dawid.cap_poec_java.DTO.GameDTO;
import fr.dawid.cap_poec_java.DTO.ReviewDTO;
import fr.dawid.cap_poec_java.entity.Game;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.mapping.UrlRoute;
import fr.dawid.cap_poec_java.repository.GameRepository;
import fr.dawid.cap_poec_java.service.*;
import fr.dawid.cap_poec_java.service.interfaces.DAOFindByIdInterface;
import fr.dawid.cap_poec_java.utils.FlashMessage;
import fr.dawid.cap_poec_java.utils.FlashMessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class GameController implements DAOFindByIdInterface<Game> {

    private GameRepository gameRepository;
    private GameService gameService;
    private ReviewService reviewService;
    private GenreService genreService;
    private ClassificationService classificationService;
    private BusinessModelService businessModelService;
    private PublisherService publisherService;
    private PlatformService platformService;
    private FlashMessageBuilder flashMessageBuilder;
    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }

    @GetMapping(UrlRoute.URL_GAMES)
    public ModelAndView index(
            ModelAndView mav,
            Principal principal,
            @PageableDefault(
                size = 6, // nb Element par page
                sort = { "publishedAt" }, // order by
                direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        if (principal == null) {
            mav.setViewName("redirect:/s-inscrire");
            return mav;
        }
        mav.addObject("pageGames", gameService.findAll(pageable));
        mav.setViewName("game/index");
        return mav;
    }

    @GetMapping(UrlRoute.URL_GAMES_SHOW)
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav,
            Principal principal,
            @ModelAttribute("flashMessage") FlashMessage flashMessage,
            @PageableDefault(
                    size = 6, // nb Element par page
                    sort = { "createdAt" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        mav.setViewName("game/show");
        if (principal != null) {
            mav.addObject("reviewDto", new ReviewDTO());
        }
        Game game = gameService.findBySlug(slug);
        mav.addObject("flashMessage", flashMessage);
        mav.addObject("game", game);
        mav.addObject("pageReviews", reviewService.findAllByGame(game, pageable));
        return mav;
    }
    @PostMapping(UrlRoute.URL_GAMES_SHOW)
    public ModelAndView show(
            @PathVariable String slug,
            ModelAndView mav,
            Principal principal,
            @ModelAttribute("reviewDto") ReviewDTO reviewDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            mav.setViewName("game/show");
            return mav;
        }
        reviewService.create(
                reviewDTO,
                gameService.findBySlug(slug),
                principal.getName()
        );
        redirectAttributes.addFlashAttribute(
                "flashMessage",
                new FlashMessage("success", "Votre commentaire a bien été enregistré, il est actuellement en attente de modération !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAMES + "/" + slug);
        return mav;
    }

    @GetMapping(UrlRoute.URL_GAME_NEW)
    public ModelAndView create(ModelAndView mav) {
        mav.setViewName("game/new");
        mav.addObject("gameDto", new GameDTO());
        mav.addObject("genres", genreService.findAllSorted());
        mav.addObject("classifications", classificationService.findAllSorted());
        mav.addObject("businessModels", businessModelService.findAllSorted());
        mav.addObject("publishers", publisherService.findAllSorted());
        mav.addObject("platforms", platformService.findAllSorted());
        return mav;
    }

    @PostMapping(UrlRoute.URL_GAME_NEW)
    public ModelAndView create(
            ModelAndView mav,
            @ModelAttribute("gameDto") GameDTO gameDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Principal principal
    ) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("game/new");
            return mav;
        }

        redirectAttributes.addFlashAttribute(
                "flashMessage",
                flashMessageBuilder.createSuccessFlashMessage("Jeu créé avec succès !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAMES + "/" + gameService.create(gameDTO, principal.getName()).getSlug());
        return mav;
    }
    @GetMapping(UrlRoute.URL_GAME_DELETE+"/{id}")
    public ModelAndView delete(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes,
            ModelAndView mav
    ){
    gameService.delete(id);
        redirectAttributes.addFlashAttribute(
                "flashMessage",
                flashMessageBuilder.createWarningFlashMessage("Jeu effacé !")
        );
        mav.setViewName("redirect:" + UrlRoute.URL_GAMES);
        return mav;
    }
}

