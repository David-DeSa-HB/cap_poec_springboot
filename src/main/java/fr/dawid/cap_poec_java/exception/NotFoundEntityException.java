package fr.dawid.cap_poec_java.exception;

public class NotFoundEntityException extends RuntimeException{

    public NotFoundEntityException() {
            super("Entity not found");
        }
}
