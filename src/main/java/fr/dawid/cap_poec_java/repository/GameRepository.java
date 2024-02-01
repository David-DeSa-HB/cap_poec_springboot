package fr.dawid.cap_poec_java.repository;

import fr.dawid.cap_poec_java.entity.Game;
import fr.dawid.cap_poec_java.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends
        JpaRepository<Game, Long> ,
        EntityNomenclatureRepository<Game> {

    public void deleteBySlug(String slug);
}