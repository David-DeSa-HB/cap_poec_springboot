package fr.dawid.cap_poec_java.service.interfaces;


public interface DAOFindBySlugInterface<T>{
    T findBySlug(String slug);

}
