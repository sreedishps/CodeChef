import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 07/11/14.
 */
public class PRPALN {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      s = br.readLine();
      if(check(s,true)){
        System.out.println("YES");
      }else{
        System.out.println("NO");
      }
    }
  }

  private static boolean check(String s,boolean flag) {
    int len = s.length()-1;
    for(int i=0;i<len;i++,len--){
      if(s.charAt(i) == s.charAt(len)){
        continue;
      }
      else{
            return palinCheck(removeCharAt(s,i)) || palinCheck(removeCharAt(s,len));
      }
    }
    return true;
  }
  public static boolean palinCheck(String s){
   // System.out.println(s);
    return s.equals(new StringBuilder(s).reverse().toString());
  }
  public static String removeCharAt(String s, int pos) {
    return s.substring(0, pos) + s.substring(pos + 1);
  }
}
