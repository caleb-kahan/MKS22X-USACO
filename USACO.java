import java.io.*;
import java.util.*;

public class USACO{
	public static int silver(String fileName){
    int [][] optimize;
    boolean [][] canMove;
    int [] rowsColsTime;
    int [] startEnd;
    Scanner sys=new Scanner("");
    try{
	File file = new File(fileName);
	sys = new Scanner(file);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+fileName);
    }
    rowsColsTime = generateRowsColsTime(sys);
    optimize = generateOptimize(rowsColsTime[0],rowsColsTime[1],sys);
    canMove = new boolean[rowsColsTime[0]][rowsColsTime[1]];
    startEnd = generateStartEnd(sys);
    if(! immediateCheck(startEnd[0],startEnd[1],startEnd[2],startEnd[3],rowsColsTime[2])) return 0;
    optimize[startEnd[0]][startEnd[1]]=1;
    for(int i=1;i<=rowsColsTime[2];i++){
      canMove = generateCanMove(i,startEnd[0], startEnd[1],canMove);
      optimize=generate(optimize,canMove);
    }
    sys.close();
    return optimize[startEnd[2]][startEnd[3]];
  }
  private static void printer(int [][] optimize){
	for(int i=0;i<optimize.length;i++){
		for(int j=0;j<optimize[0].length;j++){
			System.out.print(optimize[i][j]+" ");
		}
		System.out.println();
	}
    }
  public static int [] generateRowsColsTime(Scanner sys){
    //Hope, I'm alloed to use delimeters
    //sys.useDelimiter("\\s*");
    String toBeAnalyzed = sys.nextLine();
    String [] analyzer = toBeAnalyzed.split(" ");
    int [] returner = new int[3];
    returner[0]=Integer.parseInt(analyzer[0]);
    returner[1]=Integer.parseInt(analyzer[1]);
    returner[2]=Integer.parseInt(analyzer[2]);
    return returner;
  }
  public static int [][] generateOptimize(int rows, int cols, Scanner sys){
	int [][] optimize = new int[rows][cols];
	for(int i=0;i<rows;i++){
		String str = sys.nextLine();
		String [] values = str.split("");
      		for(int j=0;j<cols;j++){
        		if(values[j].equals("*")){
          			optimize[i][j]=-1;
			}
		}
	}
	return optimize;
  }
  public static boolean [][] generateCanMove(int time, int row, int col, boolean [][]canMove){
	for(int i=0;i<canMove.length;i++){
		for(int j=0;j<canMove[0].length;j++){
			if(! immediateCheck(row,col,i,j,time))
				canMove[i][j]=false;
			else canMove[i][j]=true;
		}
	}
	return canMove;
  }
					
  public static int [] generateStartEnd(Scanner sys){
	String toBeAnalyzed = sys.nextLine();
    	String [] analyzer = toBeAnalyzed.split(" ");
    	int [] returner = new int[4];
    	returner[0]=Integer.parseInt(analyzer[0])-1;
    	returner[1]=Integer.parseInt(analyzer[1])-1;
    	returner[2]=Integer.parseInt(analyzer[2])-1;
	returner[3]=Integer.parseInt(analyzer[3])-1;
	return returner;
   }
	
  public static boolean immediateCheck(int r1, int c1, int r2, int c2, int time){
    boolean oddTime = time%2==1;
    boolean oddDistance = (Math.abs(r2-r1)+Math.abs(c2-c1))%2==1;
    return oddTime == oddDistance;
  }
  public static int [][] generate(int[][]optimize, boolean[][]canMove){
    for(int i=0;i<optimize.length;i++){
      for(int j=0;j<optimize[0].length;j++){
        if(canMove[i][j]&&optimize[i][j]>-1){
		optimize[i][j]+=checker(optimize,i-1,j);
		optimize[i][j]+=checker(optimize,i,j-1);
		optimize[i][j]+=checker(optimize,i+1,j);
		optimize[i][j]+=checker(optimize,i,j+1);
	}	
      }
    }
    for(int i=0;i<optimize.length;i++){
      for(int j=0;j<optimize[0].length;j++){
        if(! canMove[i][j] && optimize[i][j]>0){
		optimize[i][j]=0;
	}	
      }
    }
    return optimize;
  }
  public static int checker(int [][] optimize, int i, int j){
    //If the 4 conditions are right, I don't have to worry about the last condition.
    if (i>=0 && j>=0 && i < optimize.length && j < optimize[0].length && optimize[i][j]>=1){
        return optimize[i][j];
    }
    return 0;
  }
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
