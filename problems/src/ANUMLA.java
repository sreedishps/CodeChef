import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.SortedSet;

/**
 * Created by sreedish.ps on 19/10/14.
 */
public class ANUMLA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Long T = Long.parseLong(br.readLine());
    while (T > 0) {
      T--;
      Long N = Long.parseLong(br.readLine());
      System.out.println(((N * (N+1)/2) + N));
    }

  }
}
