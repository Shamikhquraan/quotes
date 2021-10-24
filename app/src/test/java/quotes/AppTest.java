package quotes;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {
    @Test public void testQuotes() {
        Gson gson = new Gson();
        try {
            Reader reader = new FileReader("../app/src/main/resources/data.json");
            Quotes[] recentQuotes = gson.fromJson(reader, Quotes[].class);
            String expected = "Today's Quote: Quote:  “Ask no questions, and you'll be told no lies.�? author: Charles Dickens";
            System.out.println(recentQuotes[1].toString());
            Quotes output = recentQuotes[1];
            assertEquals(expected,output);
        } catch (IOException ex) {
            System.out.println("file not found ... " + ex.getMessage());
            Assertions.assertTrue(false);
        }
    }

}