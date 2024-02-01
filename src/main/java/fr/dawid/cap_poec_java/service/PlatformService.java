package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.Platform;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.PlatformRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatformService implements DAOEntityInterface<Platform> {

    PlatformRepository platformRepository;

    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public List<Platform> findAllSorted() {
        return platformRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Platform findById(Long id) {
        return platformRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
