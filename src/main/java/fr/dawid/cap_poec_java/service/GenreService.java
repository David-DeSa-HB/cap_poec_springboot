package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.Genre;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.GenreRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService implements DAOEntityInterface<Genre> {

    private GenreRepository genreRepository;


    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findAllSorted() {
        return genreRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
