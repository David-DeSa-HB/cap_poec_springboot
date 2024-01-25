package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.entity.BusinessModel;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.BusinessModelRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOPageableInterface;
import fr.dawid.cap_poec_java.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusinessModelService implements DAOPageableInterface<BusinessModel> {

    private BusinessModelRepository businessModelRepository;


    @Override
    public List<BusinessModel> findAll() {
        return businessModelRepository.findAll();
    }

    @Override
    public Object getObjectById(Long id) {
        return businessModelRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }
}
