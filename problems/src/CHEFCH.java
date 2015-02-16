import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 06/02/15.
 */
public class CHEFCH {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T-- >0)  {
        String s = br.readLine();
        Long minus = 0L;
        Long plus = 0L;
        char m = '-';
        char p = '+';
        for(int i=0;i<s.length();i++){
          if(s.charAt(i) != m){
            minus++;
          }
          if(s.charAt(i) != p){
            plus++;
          }

          if(m == '-'){
            m = '+';
            p = '-';
          }else{
            p = '+';
            m = '-';
          }
        }

      System.out.println(Math.min(minus,plus));


    }
  }


}
