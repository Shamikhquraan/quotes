/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) throws IOException {

        String GET_URL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        requestGet(GET_URL);
    }
    public static String requestGet(String GET_URL) throws IOException {
try{
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // set the connection time out: :
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        // set a GET request :
        con.setRequestMethod("GET");
   // con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
    int responseCode = con.getResponseCode();
        // check if the response is OK 200 :
        if (responseCode==HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
// read the data from the URL request :
            String data =in.readLine();
            System.out.println("the data has been read :  "+data);
            // close the connection :
            in.close();
            // convert JSON format :
            Gson gson = new Gson();
            webQuotes resultQuote = gson.fromJson(data, webQuotes.class);
//
            //System.out.println("all quotes : "+ Arrays.toString(quoteee));

            Reader reader2 =new BufferedReader(new FileReader("app/src/main/resources/testFile.json"));
            Quotes[] recentQuotes2 = gson.fromJson(reader2, Quotes[].class);
            List<Quotes> listOfQuotes = new ArrayList<Quotes>(Arrays.asList(recentQuotes2));//list of all quotes
            Quotes toAddToFileQuote =new Quotes(resultQuote.getQuoteAuthor(),resultQuote.getQuoteText()); //create a new Quotes obj withe the same value of Quate from Api
            listOfQuotes.add(toAddToFileQuote);
            FileWriter fileWriter = new FileWriter("app/src/main/resources/testFile.json");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            Gson gson2 = new Gson();
            String output = gson2.toJson(listOfQuotes);
            bw.write(output);
            bw.flush();
            bw.close();

            System.out.println(resultQuote.toString());
            return resultQuote.toString();        }

}catch (IOException e){

    //if happen anyerror read from orginal file :
    System.out.println("we are sorry there is an error right now : "+e+" so we exchange online qoute with one wich choosen randomly from our amazing qoutes:");
    Gson gson = new Gson();
    Reader reader =new BufferedReader(new FileReader("app/src/main/resources/testFile.json"));
    Quotes[] recentQuotes = gson.fromJson(reader, Quotes[].class);
    int index = (int)(Math.random()*recentQuotes.length);
    System.out.println(recentQuotes[index].toString());
}
        return GET_URL;
    }
}