package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.Genre;
import fr.dawid.cap_poec_java.entity.Platform;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.PlatformRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOPageableInterface;
import fr.dawid.cap_poec_java.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatformService implements DAOPageableInterface<Platform> {

    PlatformRepository platformRepository;
    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Object getObjectById(Long id) {
        return platformRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
