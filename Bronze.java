import java.io.*;
import java.util.*;

public class Bronze{
  public static void bronze(){
    int [][] pasture=new int[0][0];
    int [][] stompInstructions=new int[0][0];
    int lakeElevation=initialize(pasture,stompInstructions,fileName);
    stomp(stompInstructions, pasture);


    }
    public static int initialize(int [][] pasture, int [][] stompInstructions, String fileName){
      try{
        File file = new File(fileName);
      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+fileName);
      }
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
  		           if(j!=2)num = sys.nextInt();
  	         }
          }
  	      i++;
      }
   }
   public static void stomp(int [][] stompInstructions, int [][] pasture){
     for(int i=0;i<stompInstructions.length;i++){
       int [] stomper = stompInstructions[i];
       int row = stomper[0]-1;
       int col = stomper[1]-1;
       int distance = stomper[2];
       int highest = 0;
       for(int j=0;j<3;j++){
         for(int k=0;k<3;k++){
           if(highest<pasture[row+j][col+k]) highest=pasture[row+j][col+k];
         }
       }
       int max = highest - distance;
       for(int j=0;j<3;j++){
         for(int k=0;k<3;k++){
           if(max<pasture[row+j][col+k]) pasture[row+j][col+k]=max;
         }
       }
     }
   }
}
