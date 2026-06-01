import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.*;
import java.util.List;

public class LeaderboardManager {

  public static String fileName = "leaderboard.txt";

  public static void record(String playerName, int yearsSurvived, double lifeHealth) {
    System.out.println("Name: " + playerName + " Years Survived: " + yearsSurvived + " End Life Health: " + lifeHealth);
    try {
      FileWriter fileWriter = new FileWriter(fileName, true);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
  
      String textToAdd = playerName.trim() + "," + yearsSurvived + "," + lifeHealth;
      bufferedWriter.write(textToAdd + "\n");
  
      bufferedWriter.close();
      System.out.println("Content appended to " + fileName + " successfully.");
  
    } catch (IOException e) {
      System.err.println("An error occurred while appending to the file: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void printResults() {
    //results header text
    final String HEADER = "Player Name          |  Years Survived    |  End Life Health";
    System.out.println(HEADER);
    //bar underneath header
    String underscore = "";
    for (int index=0; index< HEADER.length()+5; index++){
      underscore += "_";
    }
    System.out.println(underscore);

    //take in data, output it
    try {
      //formatting - trim the length of name
      final int MAX_PLAYER_NAME_LENGTH = 15;
      List<String> lines = Files.readAllLines(Paths.get(fileName));
      for (String line : lines) {
        String[] parts = line.split(",");        
        String playerName = parts[0];
        String yearsSurvived = parts[1];
        String lifeHealth = parts[2];
        //add spaces so all names exactly the same length
        if (playerName.length() > MAX_PLAYER_NAME_LENGTH) {
          playerName = playerName.substring(0,MAX_PLAYER_NAME_LENGTH);
        }

        for (int charIndex = playerName.length(); charIndex<MAX_PLAYER_NAME_LENGTH; charIndex++) {
          playerName += " ";
        }
        //final line output (name + category)
        String lineOutput = playerName + "      |  " + yearsSurvived + "                 |  " + lifeHealth;
        System.out.println(lineOutput);
             
      }
    } catch (IOException e) {
          e.printStackTrace();
      }
  }
       
}