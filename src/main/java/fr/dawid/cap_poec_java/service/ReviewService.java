package fr.dawid.cap_poec_java.service;


import fr.dawid.cap_poec_java.entity.Review;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.ReviewRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOPageableInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService implements DAOPageableInterface<Review> {

    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Object getObjectById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }

    public List<Review> findTop5ByOrderByCreatedAtDesc() {
        return reviewRepository.findTop5ByOrderByCreatedAtDesc();
    }
}
