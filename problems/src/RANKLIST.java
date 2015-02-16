import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 07/02/15.
 */
public class RANKLIST {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T-- >0)  {
      String s = br.readLine();
      Long N = Long.parseLong(s.split(" ")[0]);
      Long S = Long.parseLong(s.split(" ")[1]);

      Long total = N * (N +1);
      total = total/2;
      if(S.equals(total)){
        System.out.println("0");
      }else{
        long counter = 0;
        N--;
        while(total > S){
          total = total - N;
          N--;
          counter++;
        }

        System.out.println(counter);
      }
    }
  }
}
