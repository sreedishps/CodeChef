import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 21/12/14.
 */
public class RRJOKE {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      Integer N = Integer.parseInt(br.readLine());
      Integer answer = 0;
      for(int i=1;i<=N;i++){
        answer = answer ^ i;
      }
      while(N>0){
        N--;
        br.readLine();
      }
      System.out.println(answer);
      T--;
    }
  }

}
