import java.io.*;
import java.util.*;

public class Bronze{
  public static int bronze(String fileName){
    int [] rowsColsElevationStomping = new int [4];
    int [][] pasture;
    int [][] stompInstructions;
    Scanner sys=new Scanner("");
    try{
	File file = new File(fileName);
	sys = new Scanner(file);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+fileName);
    }
    rowsColsElevationStomping = generateRowsColsElevationStomping(sys);
    pasture=generatePasture(rowsColsEelevationStomping[0],rowsColsElevationStomping[1],sys);
    stompInstructions = generateStompInstructions(rowsColsElevationStomping[3],sys);
    pasture = stomp(stompInstructions, pasture);
    return makeALakeAndCalculateVolume(pasture,rowsColsElevationStomping[2]);
    }
    public static int [] generateRowsColsElevationStomping(Scanner sys){
	String toBeAnalyzed = sys.nextLine();
    	String [] analyzer = toBeAnalyzed.split(" ");
    	int [] returner = new int[4];
    	returner[0]=Integer.parseInt(analyzer[0]);
    	returner[1]=Integer.parseInt(analyzer[1]);
    	returner[2]=Integer.parseInt(analyzer[2]);
	returner[3]=Integer.parseInt(analyzer[3]);
	return returner;
    }
    public static int [][] generatePasture(int rows, int cols, Scanner sys){
	int [][] pasture = new int[rows][cols]
	for(int i=0;i<rows;i++){
		String str = sys.nextLine();
		String [] values = str.split(" ");
      		for(int j=0;j<cols;j++){
          		pasture[i][j]=values[j];
		}
	}
	return optimize;
    }
    public static int[][] generateStompInstructions(int times,sys){
	int [][] stompInstructions = new int[times][3];
	for(int i=0;i<times;i++){
		String toBeAnalyzed = sys.nextLine();
    		String [] analyzer = toBeAnalyzed.split(" ");
		for(int j=0;j<3;j++){
			int [] stompInstruction = new int[3];
    			stompInstruction[0]=Integer.parseInt(analyzer[0]);
    			stompInstruction[1]=Integer.parseInt(analyzer[1]);
    			stompInstruction[2]=Integer.parseInt(analyzer[2]);
		}
	}
	return stompInstuctions;
     }
		
		
    public static int initialize(int [][] pasture, int [][] stompInstructions, String fileName){
      int lakeElevation=0;
      File file = new File(fileName);
      //Hope, I'm alloed to use delimeters
      Scanner sys = new Scanner(file);
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
      return lakeElevation;

   }
   public static int [][] stomp(int [][] stompInstructions, int [][] pasture){
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
     return pasture;
   }
   public static int makeALakeAndCalculateVolume(int [][] pasture, int lakeElevation){
     int combine =0;
     for(int i=0;i<pasture.length;i++){
       for(int j=0;j<pasture[0].length;j++){
         if(pasture[i][j]>=lakeElevation){
           pasture[i][j]=0;
         }
         else{
           pasture[i][j]=lakeElevation-pasture[i][j];
           combine+=pasture[i][j];
         }
      }
    }
    return 72*72*combine;
  }
}
