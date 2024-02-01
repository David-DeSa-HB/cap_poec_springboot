package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.BusinessModel;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.BusinessModelRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOEntityInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusinessModelService implements DAOEntityInterface<BusinessModel> {

    private BusinessModelRepository businessModelRepository;

    public List<BusinessModel> findAll() {
        return businessModelRepository.findAll();
    }

    @Override
    public List<BusinessModel> findAllSorted() {
        return businessModelRepository.findAllByOrderByNameAsc();
    }

    @Override
    public BusinessModel findById(Long id) {
        return businessModelRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
