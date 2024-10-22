package ua.domain.service;

public class WorkExeption extends RuntimeException {

   public WorkExeption(String message) {
        super(message);
    }

    public WorkExeption(String message, Throwable cause) {
        super(message, cause);
    }

}
