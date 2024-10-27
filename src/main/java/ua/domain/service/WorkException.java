package ua.domain.service;

public class WorkException extends RuntimeException {

   public WorkException(String message) {
        super(message);
    }

    public WorkException(String message, Throwable cause) {
        super(message, cause);
    }

}
