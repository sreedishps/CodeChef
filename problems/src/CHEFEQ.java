import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 06/02/15.
 */
public class CHEFEQ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T-- >0)  {
      int len = Integer.parseInt(br.readLine());
      String str = br.readLine();
      String s[] = str.split(" ");
      int arr[] = new int[100001];
      int max = 0;
      int maxnum = 0;

      for(int i=0;i<len;i++){
        int num = Integer.parseInt(s[i]);
        arr[num]++;
        if(arr[num] > max){
          max = arr[num];
          maxnum = num;
        }
      }
      int counter = 0;

      for(int i=0;i<len;i++){
        int num = Integer.parseInt(s[i]);
        if(num != maxnum){
          counter++;
        }
      }

      System.out.println(counter);

    }
  }
}
