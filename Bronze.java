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
    pasture=generatePasture(rowsColsElevationStomping[0],rowsColsElevationStomping[1],sys);
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
	int [][] pasture = new int[rows][cols];
	for(int i=0;i<rows;i++){
		String str = sys.nextLine();
		String [] values = str.split(" ");
      		for(int j=0;j<cols;j++){
          		pasture[i][j]=Integer.parseInt(values[j]);
		}
	}
	return pasture;
    }
    public static int[][] generateStompInstructions(int times,Scanner sys){
	int [][] stompInstructions = new int[times][3];
	for(int i=0;i<times;i++){
		String toBeAnalyzed = sys.nextLine();
    		String [] analyzer = toBeAnalyzed.split(" ");
		for(int j=0;j<3;j++){
			int [] stompInstruction = new int[3];
    			stompInstructions[i][0]=Integer.parseInt(analyzer[0]);
    			stompInstructions[i][1]=Integer.parseInt(analyzer[1]);
    			stompInstructions[i][2]=Integer.parseInt(analyzer[2]);
		}
	}
	return stompInstructions;
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
