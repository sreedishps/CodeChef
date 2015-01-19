import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sreedish on 11/12/14.
 */
public class XMAX {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s ;
    Integer T = 1;
    while(T > 0){
      T--;
      s = br.readLine();
      Integer N = Integer.parseInt(s);

      Long arr[] = new Long[N];


      for(int i=0;i<N;i++){
        s = br.readLine();
        arr[i] =Long.parseLong(s);
      }
      //gaussian elimination
      Arrays.sort(arr);


      Long max = Long.highestOneBit(arr[N-1]);

      for(int i=N-1;i>=0;i--){
        if(Long.highestOneBit(arr[i]) < max){
          boolean flag = false;
          for(int k =i-1;k>=0;k--){
            if(Long.highestOneBit(arr[k]) == max){
              Long temp = arr[i];
              arr[i] = arr[k];
              arr[k] = temp;
              flag = true;
              break;
            }
          }
          if(!flag){
            max = max/2;
            i++;
            continue;
          }

        }
        for(int j = i-1 ; j >=0 ; j--){
          if(Long.highestOneBit(arr[j]) == max){
            arr[j] = arr[j] ^ arr[i] ;
          }
        }
        for(int k=0;k<N;k++){
          //  System.out.println(arr[k]);
        }
        max = max / 2;

      }
      Long K = arr[N-1];
     Long temp;
      for(int i=N-1;i>=0;i--){
        temp = K ^ arr[i];
        if(temp > K){
          K = temp;
        }
      }
      System.out.println(K);
    }

  }


}