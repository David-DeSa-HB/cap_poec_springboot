package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.GameRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOPageableInterface;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService implements DAOPageableInterface<GameService> {

    private GameRepository gameRepository;

    @Override
    public List<GameService> findAll() {
        return null;
    }

    @Override
    public Object getObjectById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
