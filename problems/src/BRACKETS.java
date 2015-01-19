import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 23/11/14.
 */
public class BRACKETS {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while (T > 0) {
      s = br.readLine();
      Long balance = getBalance(s);
      System.out.println(printBracket(balance));
      T--;
    }
  }

  private static Long getBalance(String s) {
    Long balance = 0L;
    Long maxBalance = 0L;
    for(Long i =0L;i< s.length() ; i++){
      if(s.charAt(Integer.parseInt(i+"")) == '('){
        balance++;
      }
      else{
        balance--;
      }
      if(balance > maxBalance){
        maxBalance = balance;
      }
    }
    return maxBalance;
  }

  private static String printBracket(Long balance) {
    StringBuilder s = new StringBuilder();
    for(Long i = 0L ; i<balance;i++){
      s.append("(");
    }
    for(Long i = 0L ; i<balance;i++){
      s.append(")");
    }
    return s.toString();
  }
}
