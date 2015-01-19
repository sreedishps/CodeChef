import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by sreedish.ps on 07/11/14.
 */
public class DISCHAR {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0){
      T--;
      s = br.readLine();
      HashSet<String> set = new HashSet<String>();
      for(Integer i=0;i<s.length();i++){
        set.add(s.charAt(i)+"");
      }
      System.out.println(set.size());
    }
  }
}
