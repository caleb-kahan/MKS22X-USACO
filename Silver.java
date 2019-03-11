import java.io.*;
import java.util.*;

public class Silver{
  public static int silver(String fileName){
    int [][] optimize = new int [0][0];
    Integer time=0;
    Integer row1=0;
    Integer col1=0;
    Integer row2=0;
    Integer col2=0;
    try{
      initialize(optimize,time,row1,col1,row2,col2,fileName);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+fileName);
    }
    if(! immediateCheck(row1,col1,row2,col2,time)) return 0;
    for(int i=0;i<time;i++){
      generate(optimize);
    }
    return optimize[row2][col2];
  }
  public static void initialize(int[][] optimize, Integer time, Integer row1, Integer col1, Integer row2, Integer col2,String fileName)throws FileNotFoundException{
    File file = new File(fileName);
    Scanner sys = new Scanner(file);
    //Hope, I'm alloed to use delimeters
    sys.useDelimiter("\\s*");
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());
    System.out.println(sys.next());

    int row = sys.nextInt();
    int col = sys.nextInt();
    optimize = new int[row][col];
    time = sys.nextInt();
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        if(sys.next()=="*")
          optimize[i][j]=-1;
      }
    }
    row1=sys.nextInt()-1;
    col1=sys.nextInt()-1;
    row2=sys.nextInt()-1;
    col2=sys.nextInt()-1;
    optimize[row1][col1]=1;
  }
  public static boolean immediateCheck(int r1, int c1, int r2, int c2, int time){
    boolean oddTime = time%2==1;
    boolean oddDistance = (Math.abs(r2-r1)+Math.abs(c2-r2))%2==1;
    return oddTime == oddDistance;
  }
  public static void generate(int[][]optimize){
    for(int i=0;i<optimize.length;i++){
      for(int j=0;j<optimize[0].length;j++){
        optimize[i][j]+=checker(optimize,i,j);
      }
    }
  }
  public static int checker(int [][] optimize, int i, int j){
    int result = optimize[i][j];
    if (result>=1 && i>=0 && j>=0 && i < optimize.length && j < optimize[0].length)
        return result;
    return 0;
  }
}
