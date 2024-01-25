package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.Classification;
import fr.dawid.cap_poec_java.entity.Genre;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.GenreRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOPageableInterface;
import fr.dawid.cap_poec_java.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService implements DAOPageableInterface<Genre> {

    private GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Object getObjectById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
