package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.DTO.ReviewDTO;
import fr.dawid.cap_poec_java.entity.*;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.ReviewRepository;

import fr.dawid.cap_poec_java.service.interfaces.DAOFindByIdInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService implements DAOFindByIdInterface<Review> {

    private ReviewRepository reviewRepository;
    private UserService userService;

    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public Page<Review> findByUserNickname(String nickname, Pageable pageable) {
        return reviewRepository.findByModeratorIsNotNullOrGamerNickname(nickname, pageable);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }


    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }

    public List<Review> findTop5ByOrderByCreatedAtDesc() {
        return reviewRepository.findTop5ByOrderByCreatedAtDesc();
    }

    public Page<Review> findAllByGame(Game game, Pageable pageable) {
        return reviewRepository.findAllByGameAndModeratorIsNotNull(game, pageable);
    }

    public Review create(ReviewDTO reviewDTO, Game game, String name) {
        Review review = new Review();
        review.setGame(game);
        review.setGamer((Gamer) userService.findByNickname(name));
        review.setDescription(reviewDTO.getDescription());
        review.setRating(reviewDTO.getRating());
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.saveAndFlush(review);
    }

    public boolean moderateReview(String nickname, Long id, Long status) {
        Review review = findById(id);
        boolean isModerate = true;
        if (status == 1L) {
            review.setModerator((Moderator) userService.findByNickname(nickname));
            review.setModeratedAt(LocalDateTime.now());
        } else {
            reviewRepository.delete(review);
            isModerate = false;
        }
        reviewRepository.flush();
        return isModerate;
    }

    public Page<Review> getPageReviewByNickname(String nickname, Pageable pageable) {
        User user = userService.findByNickname(nickname);
        Page<Review> pageReviews = findByUserNickname(nickname, pageable);
        if (user.isModerator()) {
            Sort.Order order = pageable.getSort().getOrderFor("moderator");
            if (order != null) {
                if (order.isAscending()) {
                    pageReviews = reviewRepository.findByModeratorIsNull(pageable);
                } else {
                    pageReviews = reviewRepository.findByModeratorIsNotNull(pageable);
                }
            } else {
                pageReviews = reviewRepository.findAll(pageable);
            }
        }
        return pageReviews;
    }
}
