package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.DTO.GameDTO;
import fr.dawid.cap_poec_java.entity.Game;
import fr.dawid.cap_poec_java.entity.Moderator;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.GameRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOFindBySlugInterface;
import fr.dawid.cap_poec_java.service.interfaces.DAOFindByIdInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class GameService implements
        DAOFindByIdInterface<Game>,
        DAOFindBySlugInterface<Game> {

    private GameRepository gameRepository;
    private UserService userService;

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }

    @Override
    public Game findBySlug(String slug) {
        return gameRepository.findBySlug(slug)
                .orElseThrow(NotFoundEntityException::new);
    }
    public Game create(GameDTO gameDTO, String nickname) {
        Game game = new Game();
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setPublishedAt(LocalDate.parse(gameDTO.getPublishedAt()));
        game.setGenre(gameDTO.getGenre());
        game.setBusinessModel(gameDTO.getBusinessModel());
        game.setPublisher(gameDTO.getPublisher());
        game.setClassification(gameDTO.getClassification());
        game.setPlatforms(gameDTO.getPlatforms());
        game.setModerator((Moderator) userService.findByNickname(nickname));
        game.setImage("https://static.vecteezy.com/system/resources/previews/005/337/799/original/icon-image-not-found-free-vector.jpg");
        return gameRepository.saveAndFlush(game);
    }

    public void delete(Long id){
        gameRepository.deleteById(id);
    }
}
