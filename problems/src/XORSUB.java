import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 09/12/14.
 */
public class XORSUB {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    String s;

    while(T > 0) {
      s = br.readLine();
      Integer N = Integer.parseInt(s.split(" ")[0]);
      Integer K = Integer.parseInt(s.split(" ")[1]);

      s = br.readLine();

      Integer[] arr = new Integer[N];
      for(int i=0;i<N;i++){
        arr[i] = Integer.parseInt(s.split(" ")[i]);
      }


      T--;
    }
  }
}
