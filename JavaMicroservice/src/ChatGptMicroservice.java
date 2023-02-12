import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ChatGptMicroservice 
{
  private static final String API_KEY = "API_KEY here";
  private static final String API_ENDPOINT = "API_ENDPOINT here";

  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a question: ");
    String question = input.nextLine();
    String answer = getAnswerFromChatGpt(question);
    System.out.println("Answer: " + answer);
    appendQuestionAndAnswerToCsv(question, answer);
  }

  private static String getAnswerFromChatGpt(String question) 
  {
    try 
    {
      URL url = new URL(API_ENDPOINT + "?question=" + question + "&api_key=" + API_KEY);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      int responseCode = conn.getResponseCode();
      if (responseCode == 200) 
      {
        Scanner responseScanner = new Scanner(conn.getInputStream());
        return responseScanner.nextLine();
      } 
      else 
      {
        System.err.println("Failed to get answer from ChatGPT: " + responseCode);
        return "";
      }
    } 
    catch (IOException e) 
    {
      System.err.println("Failed to get answer from ChatGPT: " + e.getMessage());
      return "";
    }
  }

  private static void appendQuestionAndAnswerToCsv(String question, String answer) 
  {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("questions_and_answers.csv", true))) 
    {
      writer.write(question + "; " + answer);
      writer.newLine();
    } 
    catch (IOException e) 
    {
      System.err.println("Failed to append to CSV: " + e.getMessage());
    }
  }
}
