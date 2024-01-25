package fr.dawid.cap_poec_java.repository;

import fr.dawid.cap_poec_java.entity.BusinessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessModelRepository extends JpaRepository<BusinessModel, Long> {

}