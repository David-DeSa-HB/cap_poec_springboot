package fr.dawid.cap_poec_java.service.interfaces;

import java.util.List;

public interface DAOFindAllInterface<T> {

    List<T> findAll();

    List<T> findAllSorted();

}
