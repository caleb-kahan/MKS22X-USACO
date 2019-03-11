public class Silver{
  public static void silver(String fileName){
    int [][] pasture= newint[0][0];
    Integer time=0;
    Integer row1=0;
    Integer col1=0;
    Integer row2=0;
    Integer col2=0;
    initialize(pasture,time,row1,col1,row2,col2,fileName);
  }
  public static int initialize(int [][] pasture, Integer time, Integer row1, Integer col1, Integer row2, Integer col2,String fileName){
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
    pasture = new int[row][col];
    time = sys.nextInt();
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        pasture[i][j]=sys.next();
      }
    }
    row1=sys.nextInt();
    row2=sys.nextInt();
    row3=sys.nextInt();
    row4=sys.nextInt();
  }
}
