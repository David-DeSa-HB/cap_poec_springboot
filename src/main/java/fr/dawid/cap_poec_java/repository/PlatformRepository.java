package fr.dawid.cap_poec_java.repository;

import fr.dawid.cap_poec_java.entity.Platform;
import fr.dawid.cap_poec_java.repository.interfaces.EntityNomenclatureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends
        JpaRepository<Platform, Long>,
        EntityNomenclatureRepository<Platform>
{

}