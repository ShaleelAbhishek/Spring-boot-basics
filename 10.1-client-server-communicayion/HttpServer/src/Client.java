import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * A simple example to send HTTP request from Java
 *
 */
public class Client {

    public static void main(String args[]) throws IOException {

        Scanner scanner= new Scanner(System.in);
      while (true){

          System.out.println("type your name !");
          String name = scanner.nextLine();
          //end
          if (name.equals("close")){break;}

          URL url = new URL("http://localhost:8000/register?name="+name);

          HttpURLConnection con = (HttpURLConnection) url.openConnection();
          con.setRequestMethod("GET");

          BufferedReader in = new BufferedReader(new InputStreamReader(
                  con.getInputStream()));
          String inputLine;

          while ((inputLine = in.readLine()) != null) {
              System.out.println(inputLine);
          }

          in.close();
      }
    }
}