package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.Platform;
import fr.dawid.cap_poec_java.entity.Publisher;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.PublisherRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOPageableInterface;
import fr.dawid.cap_poec_java.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService implements DAOPageableInterface<Publisher> {

    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Object getObjectById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
