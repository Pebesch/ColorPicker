package ch.schmucki.exceptions;

public class RGBFormatException extends Exception {
    public RGBFormatException() {}
    public RGBFormatException(String message) {
        super(message);
    }
    public RGBFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
