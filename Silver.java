import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Silver{
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
    /*startEnd = generateStartEnd(sys);
    if(! immediateCheck(startEnd[0],startEnd[1],startEnd[2],startEnd[3],rowsColsTime[2])) return 0;
    optimize[startEnd[0]][startEnd[1]]=1;
    for(int i=1;i<=rowsColsTime[2];i++){
      //printer(optimize);
      //System.out.println();
      canMove = generateCanMove(i,startEnd[0], startEnd[1],canMove);
      optimize=generate(optimize,canMove);
    }
    sys.close();
    return optimize[startEnd[2]][startEnd[3]];*/
    return 0;
  }
  public static void printer(int [][] optimize){
	for(int i=0;i<optimize.length;i++){
		for(int j=0;j<optimize[0].length;j++){
			System.out.print(optimize[i][j]+" ");
		}
		System.out.println();
	}
    }
  public static int [] generateRowsColsTime(Scanner sys){
    //Hope, I'm alloed to use delimeters
    sys.useDelimiter("\\s*");
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
      		for(int j=0;j<cols;j++){
			String str = sys.next();
        		if(str.equals("*")){
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
    	int [] returner = new int[3];
    	returner[0]=Integer.parseInt(analyzer[0]);
    	returner[1]=Integer.parseInt(analyzer[1]);
    	returner[2]=Integer.parseInt(analyzer[2]);
	int row1=Integer.parseInt(sys.next(Pattern.compile("\\S*")))-1;
	//System.out.println(row1);
    	int col1=Integer.parseInt(sys.next(Pattern.compile("\\S*")))-1;
	//System.out.println(col1);
    	int row2=Integer.parseInt(sys.next(Pattern.compile("\\d*")))-1;
    	int col2=Integer.parseInt(sys.next(Pattern.compile("\\d*")))-1;
	int [] returner = new int[4];
	returner[0]=row1;
	returner[1]=col1;
	returner[2]=row2;
	returner[3]=col2;
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
}
