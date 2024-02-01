package fr.dawid.cap_poec_java.repository;

import fr.dawid.cap_poec_java.entity.Game;
import fr.dawid.cap_poec_java.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findTop5ByOrderByCreatedAtDesc();

    Page<Review> findAllByGameAndModeratorIsNotNull(Game game, Pageable pageable);

    Page<Review> findByModeratorIsNotNullOrGamerNickname(String nickname, Pageable pageable);

    Page<Review> findByModeratorIsNotNull(Pageable pageable);

    Page<Review> findByModeratorIsNull(Pageable pageable);
}