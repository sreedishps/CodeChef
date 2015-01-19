import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 03/01/15.
 */
public class CHEFSTON {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      String s = br.readLine();
      Integer N = Integer.parseInt(s.split(" ")[0]);
      Integer K = Integer.parseInt(s.split(" ")[1]);
      String A[] = br.readLine().split(" ");
      String B[] = br.readLine().split(" ");
      Long max = 0L;
      Long cost = 0L;
     for(int i =0;i<N;i++){
      cost = ( K / Long.parseLong(A[i])) * Long.parseLong(B[i]);

       if(cost.compareTo(max) > 0){
         max = cost;
       }
     }
      System.out.println(max);
    }
  }
}
