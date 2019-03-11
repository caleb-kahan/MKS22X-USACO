import java.io.*;
import java.util.*;

public class Silver{
  public static int silver(String fileName){
    int [][] optimize;
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
    startEnd = generateStartEnd(sys);
    if(! immediateCheck(startEnd[0],startEnd[1],startEnd[2],startEnd[3],rowsColsTime[2])) return 0;
    optimize[startEnd[0]][startEnd[1]]=1;
    for(int i=0;i<rowsColsTime[2];i++){
      optimize=generate(optimize);
    }
    return optimize[startEnd[2]][startEnd[3]];
  }
  public static int [] generateRowsColsTime(Scanner sys){
    //Hope, I'm alloed to use delimeters
    sys.useDelimiter("\\s*");
    int row = sys.nextInt();
    int col = sys.nextInt();
    int time = sys.nextInt();
    int [] returner = new int[3];
    returner[0]=row;
    returner[1]=col; 
    returner[2]=time;
    return returner;
  }
  public static int [][] generateOptimize(int rows, int cols, Scanner sys){
	int [][] optimize = new int[rows][cols];
	for(int i=0;i<rows;i++){
      		for(int j=0;j<cols;j++){
        		if(sys.next()=="*"){
          			optimize[i][j]=-1;
			}
		}
	}
	return optimize;
  }
  public static int [] generateStartEnd(Scanner sys){
	int row1=sys.nextInt()-1;
    	int col1=sys.nextInt()-1;
    	int row2=sys.nextInt()-1;
    	int col2=sys.nextInt()-1;
	int [] returner = new int[4];
	returner[0]=row1;
	returner[1]=col1;
	returner[2]=row2;
	returner[3]=col2;
	return returner;
   }
	
  public static boolean immediateCheck(int r1, int c1, int r2, int c2, int time){
    System.out.println("Fishy");
    boolean oddTime = time%2==1;
    System.out.println(time);
    boolean oddDistance = (Math.abs(r2-r1)+Math.abs(c2-r2))%2==1;
    System.out.println(Math.abs(r2-r1)+Math.abs(c2-r2))
    return oddTime == oddDistance;
  }
  public static int [][] generate(int[][]optimize){
    for(int i=0;i<optimize.length;i++){
      for(int j=0;j<optimize[0].length;j++){
        optimize[i][j]+=checker(optimize,i,j);
      }
    }
    return optimize;
  }
  public static int checker(int [][] optimize, int i, int j){
    int result = optimize[i][j];
    if (result>=1 && i>=0 && j>=0 && i < optimize.length && j < optimize[0].length)
        return result;
    return 0;
  }
}
