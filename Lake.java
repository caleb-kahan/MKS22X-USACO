import java.io.*;
import java.util.*;

public class Lake{
  private int [][] pasture;
  private int [][] stompInstructions;
  private int lakeElevation;

  public Lake(String fileName){
    try{
      File file = new File(fileName);
      Scanner sys = new Scanner(file);
      //Hope, I'm alloed to use delimeters
      sys.useDelimiter("\\s*");
      int i = 1;
      int row =0;
      int col =0;
      pasture=new int[row][col];
      while(sys.hasNextInt()){
        int num = sys.nextInt();
        if(i==1)row=num;
        if(i==2)col=num;
        if(i==3)lakeElevation=num;
        if(i==4)stompInstructions = new int [num][3];
	if(i>=5) pasture = new int[row][col];
        if(i>=5 && i<=row*col+4){
          int actualColumn = (i-5) % col;
          int actualRow = (i-5) / col;
          pasture[actualRow][actualColumn]=num;
        }
        if(i>row*col+4){
	  for(int j=0;j<3;j++){
	  	stompInstructions[i-(row*col+5)][j]=num;
		num = sys.nextInt();
	  }
          
        }
	i++;
      }

    }
    catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+fileName);
    }
  }

}
