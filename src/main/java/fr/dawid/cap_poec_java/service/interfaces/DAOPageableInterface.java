package fr.dawid.cap_poec_java.service.interfaces;

import java.util.List;

public interface DAOPageableInterface <T> extends DAOServiceInterface{
    List<T> findAll();

}
