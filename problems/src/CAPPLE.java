import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sreedish.ps on 07/12/14.
 */
public class CAPPLE {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      Integer N = Integer.parseInt(br.readLine());
      String s = br.readLine();
      HashSet<String> set  = new HashSet<String>();
      String arr[] = s.split(" ");
      for(int i =0 ; i< N ; i++){
        set.add(arr[i]);
      }
      System.out.println(set.size());
      T--;
    }
  }
}
