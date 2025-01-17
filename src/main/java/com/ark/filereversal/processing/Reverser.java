package com.ark.filereversal.processing;

import com.ark.filereversal.util.FileReversalException;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * @author Abdul Rab Khan
 * @Date 17-Jan-2025
 * <p>
 *     This interface used to define the file reversal functionality.
 * </p>
 */
public interface Reverser {
    void reverse(BufferedReader reader, BufferedWriter writer) throws FileReversalException;
}
