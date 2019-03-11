public class Silver{
  public static int silver(String fileName){
    int [][] optimize = new int [0][0];
    Integer time=0;
    Integer row1=0;
    Integer col1=0;
    Integer row2=0;
    Integer col2=0;
    initialize(optimize,time,row1,col1,row2,col2,fileName);
    if(! immediateCheck) return 0;


  }
  public static int initialize(int[][] optimize, Integer time, Integer row1, Integer col1, Integer row2, Integer col2,String fileName){
    try{
      File file = new File(fileName);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename: "+fileName);
    }
    Scanner sys = new Scanner(file);
    //Hope, I'm alloed to use delimeters
    sys.useDelimiter("\\s*");
    int row = sys.nextInt();
    int col = sys.nextInt();
    optimize = new int[row][col];
    time = sys.nextInt();
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        if(sys.next()=="*")
          pasture[i][j]=-1;
      }
    }
    row1=sys.nextInt()-1;
    col1=sys.nextInt()-1;
    row2=sys.nextInt()-1;
    col2=sys.nextInt()-1;
    pasture[row1][col1]=1;
  }
  public static boolean immediateCheck(int r1, int c1, int r2, int c2, int time){
    boolean oddTime = time%2==1;
    boolean oddDistance = (Math.abs(r2-r1)+Math.abs(c2-r2))%2==1;
    return oddTime == oddDistance;
  }
  public static void generate(int[][]optimize){
    for(int i=0;i<optimze.length;i++){
      for(int j=0;j<optimize[0].length;j++){
        
      }
    }
  }
}
