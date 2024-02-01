package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.Classification;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.ClassificationRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassificationService implements DAOEntityInterface<Classification> {

    private ClassificationRepository classificationRepository;


    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }

    @Override
    public List<Classification> findAllSorted() {
        return classificationRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Classification findById(Long id) {
        return classificationRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
