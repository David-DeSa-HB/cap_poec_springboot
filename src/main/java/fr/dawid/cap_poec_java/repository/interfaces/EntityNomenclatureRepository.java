package fr.dawid.cap_poec_java.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface EntityNomenclatureRepository<T> {

    Optional<T> findByName(String name);

    Optional<T> findBySlug(String slug);

    List<T> findAllByOrderByNameAsc();
}
