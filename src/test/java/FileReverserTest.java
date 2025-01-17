import com.ark.filereversal.processing.FileReverser;
import com.ark.filereversal.processing.Reverser;
import com.ark.filereversal.util.FileReversalException;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Abdul Rab Khan
 * @Date 17-Jan-2025
 * <p>
 * Unit Tests for File Reverser.
 * </p>
 */
public class FileReverserTest {
    private Reverser reverser = new FileReverser();

    @Test
    public void shouldReverseSingleLineInput() throws FileReversalException, IOException {
        String input = "ABC";
        String expectedOutput = "CBA";
        testReversal(input, expectedOutput);
    }

    @Test
    public void shouldReverseMultiLineInput() throws FileReversalException, IOException {
        String input = "Line 1\nLine 2\nLine 3";
        String expectedOutput = "1 eniL\n2 eniL\n3 eniL";

        testReversal(input, expectedOutput);
    }

    @Test
    public void shouldHandleEmptyInput() throws FileReversalException, IOException {
        String input = "";
        String expectedOutput = "";
        testReversal(input, expectedOutput);
    }

    @Test
    public void shouldHandleInputWithSpecialCharacters() throws FileReversalException, IOException {
        String input = "a!@#$%^&*()";
        String expectedOutput = ")(*&^%$#@!a";
        testReversal(input, expectedOutput);
    }

    private void testReversal(String input, String expectedOutput) throws FileReversalException, IOException {
        StringWriter stringWriter = new StringWriter();
        BufferedReader reader = new BufferedReader(new StringReader(input));
        BufferedWriter writer = new BufferedWriter(stringWriter);
        reverser.reverse(reader, writer);
        String actualOutput = stringWriter.toString();
        System.out.println("Actual Output " + actualOutput);
        assertEquals(expectedOutput, actualOutput);
    }

}
