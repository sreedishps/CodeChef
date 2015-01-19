import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 07/11/14.
 */
public class CHEFSEG {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      String num = br.readLine();
      Long X = Long.parseLong(num.split(" ")[0]);
      Long K = Long.parseLong(num.split(" ")[1]);
      int counter = 0;
      Long val = 1L;
      while(true){
        if(val <= K){
          val *= 2;
          counter++;
        }else{
          break;
        }
      }
      Long diff = K - (val/2) ;
      diff = diff* 2 + 1;
      System.out.println(new BigDecimal((Double.parseDouble(X+"")/Double.parseDouble(val+"")*diff)+"").toPlainString());

    }
  }

}

