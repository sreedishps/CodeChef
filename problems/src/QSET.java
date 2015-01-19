import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 06/01/15.
 */
public class QSET {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    Integer N = Integer.parseInt(s.split(" ")[0]);
    Integer M = Integer.parseInt(s.split(" ")[1]);

    s = br.readLine();

    byte numbers[] = new byte[N];

    for(int i=0;i<N; i++){
      numbers[i] = (byte)Integer.parseInt(s.charAt(i)+"");
    }

    boolean arr[][][] = new boolean[N][N][3];

    for(int i=0;i<N;i++){
      set3( arr,i,i , (byte ) (numbers[i] % 3));
    }


    for(int i=0;i< N-1;i++){
      for(int j=i+1 ; j< N ;j++){
        set3(arr,i,j, (byte)((get3(arr,i,j-1) + numbers[j] ) % 3));
      }
    }


    for(int q =0;q<M;q++){
//      for(int i=0;i<N;i++){
//        for(int j=0;j<N;j++){
//          System.out.print(arr[i][j]+" ");
//        }
//        System.out.println();
//      }
      s = br.readLine();
      Integer A = Integer.parseInt(s.split(" ")[0]);
      Integer B = Integer.parseInt(s.split(" ")[1]);
      Integer C = Integer.parseInt(s.split(" ")[2]);

      if(A.equals(2)){
        getCount(arr,B-1,C-1);
      }

      if(A.equals(1)){
        int diff = (C - numbers[B-1] ) %3;
        numbers[B-1] =(byte) C.intValue() ;
        update(arr, diff, B ,N);

      }
    }

  }

  private static byte get3(boolean[][][] arr, int i, int j) {
    if(arr[i][j][0] == true){
      return (byte)0;
    }
    if(arr[i][j][1] == true){
      return (byte)1;
    }
    if(arr[i][j][2] == true){
      return (byte)2;
    }
    return (byte)0;
  }

  private static void set3(boolean[][][] booleans,int i,int j, byte b) {
    if(b == 0){
      booleans[i][j][0] = true;
      booleans[i][j][1] = false;
      booleans[i][j][2] = false;
    }else if(b ==1 ){
      booleans[i][j][0] = false;
      booleans[i][j][1] = true;
      booleans[i][j][2] = false;
    }else if(b == 2){
      booleans[i][j][0] = false;
      booleans[i][j][1] = false;
      booleans[i][j][2] = true;
    }

  }

  private static void update(boolean[][][] arr, int diff, Integer c,Integer N) {
   // System.out.println(diff);
    for(int i=0 ;i <= c-1 ;i++){
      for(int j= c-1 ;j< N ;j++){
       set3(arr,i,j,(byte)((get3(arr,i,j) + diff)%3));
      }
    }
  }

  private static void getCount(boolean[][][] arr, Integer b, Integer c) {
    int counter =0;
     for(int i=b;i<=c;i++){
      for(int j=i;j<=c;j++){
       if(get3(arr,i,j) == 0){
         counter++;
       }
      }
    }
    System.out.println(counter);
  }
}
