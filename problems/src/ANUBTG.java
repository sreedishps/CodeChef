import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sreedish.ps on 18/01/15.
 */
public class ANUBTG {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      Integer N = Integer.parseInt(br.readLine());
      String s[] = br.readLine().split(" ");

      Integer arr[] = new Integer[N];

      for(int i=0;i<N;i++){
        arr[i] = Integer.parseInt(s[i]);
      }

      Arrays.sort(arr);


      int cost = 0;
      for(int i=N-1;i>=0;i--){

        cost+=arr[i];
        i--;
        if(i>=0){
          cost+=arr[i];
          i--;
        }
        i--;
      }
      System.out.println(cost);
    }
  }
}
