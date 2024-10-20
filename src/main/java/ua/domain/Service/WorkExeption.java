package ua.domain.Service;

public class WorkExeption extends RuntimeException {
    public WorkExeption() {
    }

    public WorkExeption(String message) {
        super(message);
    }

    public WorkExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkExeption(Throwable cause) {
        super(cause);
    }
}
