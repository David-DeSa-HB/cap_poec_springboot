package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.BusinessModel;
import fr.dawid.cap_poec_java.entity.Classification;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.ClassificationRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOPageableInterface;
import fr.dawid.cap_poec_java.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassificationService implements DAOPageableInterface<Classification> {

    private ClassificationRepository classificationRepository;


    @Override
    public List<Classification> findAll() {
        return classificationRepository.findAll();
    }

    @Override
    public Object getObjectById(Long id) {
        return classificationRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
