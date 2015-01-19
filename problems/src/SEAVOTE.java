import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 03/01/15.
 */
public class SEAVOTE {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      Integer N = Integer.parseInt(br.readLine());
      String B[] = br.readLine().split(" ");
      Long sum = 0L;
      Long positive = 0L;
      for(int i =0;i<N;i++){
        Long num = Long.parseLong(B[i]);
        sum += num;
        if(num.compareTo(0L) > 0 ){
          positive++;
        }
      }

      if(sum.compareTo(100L) < 0){
        System.out.println("NO");
        continue;
      }

      if(sum.compareTo(100L) == 0){
        System.out.println("YES");
        continue;
      }

      if(sum.compareTo(100L) > 0){

        Long diff = sum - 100L;
        if(positive.compareTo(diff) > 0){
          System.out.println("YES");
        }else{
          System.out.println("NO");
        }
        continue;
      }

    }
  }
}
