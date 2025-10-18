package school.javacore.exceptions.project.exception;

public class NoAvailableCopiesException extends RuntimeException {
    public NoAvailableCopiesException() {
        super("Нет доступных экземпляров!");
    }
}
