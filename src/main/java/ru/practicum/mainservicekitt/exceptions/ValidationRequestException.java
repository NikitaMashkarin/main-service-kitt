package ru.practicum.mainservicekitt.exceptions;

public class ValidationRequestException extends RuntimeException {

    public ValidationRequestException(String message) {
        super(message);
    }
}
