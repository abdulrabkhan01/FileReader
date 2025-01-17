package com.ark.filereversal.processing;

import com.ark.filereversal.util.FileReversalException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdul Rab Khan
 * @Date 17-Jan-2025
 * <p>
 * This class perform the actual processing logic to
 * reverse the file contents.
 * </p>
 */
public class FileReverser implements Reverser {

    @Override
    public void reverse(BufferedReader reader, BufferedWriter writer) throws FileReversalException {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            List<String> output = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                StringBuilder currentLine = new StringBuilder(line);
                output.add(currentLine.reverse().toString());
            }
            for (int i = 0; i < output.size(); i++) {
                stringBuilder.append(output.get(i));
                if (i < output.size() - 1) {
                    stringBuilder.append("\n");
                }
            }
            String reversedContent = stringBuilder.toString();
            writer.write(reversedContent);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileReversalException("Error during file reversal: " + e.getMessage(), e);
        }
    }
}
