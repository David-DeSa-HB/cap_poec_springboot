package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.Publisher;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.PublisherRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService implements DAOEntityInterface<Publisher> {

    private PublisherRepository publisherRepository;

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> findAllSorted() {
        return publisherRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
