package fr.dawid.cap_poec_java.configuration;

import fr.dawid.cap_poec_java.entity.*;
import fr.dawid.cap_poec_java.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class InitDataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;

    private BusinessModelRepository businessModelRepository;

    private PublisherRepository publisherRepository;

    private ClassificationRepository classificationRepository;

    private GenreRepository genreRepository;

    private PlatformRepository platformRepository;

    private GameRepository gameRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        for (int i = 1; i < 3 ; i++) {
            Moderator modo = new Moderator();
            modo.setId((long)i);
            modo.setEmail("toto"+i+"@gmail.com");
            modo.setNickname("Admin"+i);
            modo.setPhoneNumber("0102030405");
//            modo.setPassword("toto"+i);
            modo.setPassword(passwordEncoder.encode("toto"+i));
            userRepository.save(modo);
        }

        for (int i = 3; i < 5; i++) {
            Gamer gamer = new Gamer();
            gamer.setId((long)i);
            gamer.setEmail("toto"+i+"@gmail.com");
            gamer.setNickname("toto"+i);
            gamer.setBirthAt(LocalDate.now());
            gamer.setPassword(passwordEncoder.encode("toto"+i));
            userRepository.save(gamer);
        }

        List<String> businessModels = List.of("Free-to-Play", "Pay-to-Play");
        businessModels.forEach((string) -> {
            BusinessModel businessModel = new BusinessModel();
            businessModel.setId((long) businessModels.indexOf(string) + 1);
            businessModel.setName(string);
            businessModelRepository.save(businessModel);

        });

        List<String> publishers = List.of("TotoGames", "StudioToTo");
        publishers.forEach((string) -> {
            Publisher publisher = new Publisher();
            publisher.setId((long) publishers.indexOf(string) + 1);
            publisher.setName(string);
            publisherRepository.save(publisher);
        });

        List<String> classifications = List.of("PEGI12", "PEGI16");
        classifications.forEach((string) -> {
            Classification classification = new Classification();
            classification.setId((long) classifications.indexOf(string) + 1);
            classification.setName(string);
            classificationRepository.save(classification);
        });

        List<String> genres = List.of("FPS", "Action");
        genres.forEach((string) -> {
            Genre genre = new Genre();
            genre.setId((long) genres.indexOf(string) + 1);
            genre.setName(string);
            genreRepository.save(genre);
        });

        List<String> platforms = List.of("TotoBox", "PlayToto");
        platforms.forEach((string) -> {
            Platform platform = new Platform();
            platform.setId((long) platforms.indexOf(string) + 1);
            platform.setName(string);
            platformRepository.save(platform);
        });

        List<String> games = List.of("TotoBox", "PlayToto");
        games.forEach((string) -> {
            Game game = new Game();
            game.setId((long) games.indexOf(string) + 1);
            game.setName(string);
            game.setDescription("Lorem ipsum dolor sit amet..." );
            game.setPublishedAt(LocalDate.now());
            gameRepository.save(game);
        });
        publisherRepository.flush();

    }
}
