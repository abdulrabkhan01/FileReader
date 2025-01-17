package com.ark.filereversal;

import com.ark.filereversal.processing.FileReverser;
import com.ark.filereversal.processing.Reverser;
import com.ark.filereversal.util.FileReversalException;

import static com.ark.filereversal.util.Constants.*;

import java.io.*;

/**
 * @author Abdul Rab Khan
 * @Date 17-Jan-2025
 * <p>
 * This class entry point for the App to perform the
 * File Reversals.
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        Reverser reverser = new FileReverser();
        String inputFilePath = getInputFilePath();
        String outputFilePath = getOutputFilePath();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter fileWriter = new BufferedWriter(new java.io.FileWriter(outputFilePath))) {

            try {
                reverser.reverse(fileReader, fileWriter); // Call the interface method
            } catch (FileReversalException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Reversed content written to " + outputFilePath);
    }

    private static String getOutputFilePath() {
        return OUTPUT_FILE_PATH + "/" + OUTPUT_FILE_NAME;
    }

    private static String getInputFilePath() {
        return INPUT_FILE_PATH + "/" + INPUT_FILE_NAME;
    }
}
