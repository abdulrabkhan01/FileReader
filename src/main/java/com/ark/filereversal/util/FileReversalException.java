package com.ark.filereversal.util;

/**
 * @author Abdul Rab Khan
 * @Date 17-Jan-2025
 * <p>
 * This class will be used to throw custom exception in case of
 * file reversal errors.
 * </p>
 */
public class FileReversalException extends Exception {
    public FileReversalException(String message) {
        super(message);
    }

    public FileReversalException(String message, Throwable cause) {
        super(message, cause);
    }
}
