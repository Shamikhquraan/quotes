/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class App {
    public static void main(String[] args){
        Gson gson = new Gson();
        try {
//here we read the file by it path .
            Reader sampleReader = new FileReader("app/src/main/resources/data.json");
            //i made like qoutTamplet
            Quotes[] recentQuotes = gson.fromJson(sampleReader, Quotes[].class);
            //random qoutes depend on the random number ...
            int index = (int)(Math.random()*recentQuotes.length);
            System.out.println(recentQuotes[index]);
        } catch (IOException ex) {
            //if there is no qoute will print this :
            System.out.println("file not found ..at this path: " + ex.getMessage());
        }
    }
}