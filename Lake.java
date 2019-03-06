import java.io.*;
import java.util.*;

public class Lake{
  private int [][] pasture;
  private int [][] stoompInstructions;
  private int lakeElevation;

  public Lake(String fileName){
    try{
      File file = new File(fileName);
      Scanner sys = new Scanner(file);
      //Hope, I'm alloed to use delimeters
      sys.useDelimiter("\\s*");
      String line1 = sys.nextLine();

    }
    catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+fileName);
    }
  }

}
