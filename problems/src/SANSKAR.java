import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by uma on 12/12/14.
 */
public class SANSKAR {
  static  boolean answer = false;
  static long counter =0L;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      s = br.readLine();
      Integer N = Integer.parseInt(s.split(" ")[0]);
      Integer K = Integer.parseInt(s.split(" ")[1]);
      Long arr[] = new Long[N];
      s = br.readLine();
      String sarr[] = s.split(" ");
      Long sum = 0L;
      for (int i = 0; i < N; i++) {
        arr[i] = Long.parseLong(sarr[i]);
        sum = sum + (arr[i]);
      }
      if(sum % K != 0){
        System.out.println("no");
        continue;
      }
      Long partialSum = sum/K ;
      Long indSum[] = new Long[K];

      for(int i=0;i<K;i++){
        indSum[i] = partialSum;
      }

      for(int i=0,k=0;i<N;i++){
        if(arr[i] >= Math.ceil((double) partialSum / 2)){
          indSum[k] = indSum[k] - arr[i];
          arr[i] = 0L;
          k++;
        }
        if(k >= K){
          break;
        }
      }
      for(int i=0;i<K;i++){
        if(indSum[i].equals(0L)){
          continue;
        }
        for(int j=0;j<N;j++){
          if(arr[j].equals(0L)){
            continue;
          }
          if(arr[j].equals(indSum[i])){
            indSum[i] = indSum[i] - arr[j];
            arr[j] = 0L;
          }
        }
      }
      counter =0;
      if(find(arr,indSum,N,K,partialSum)){
        System.out.println("yes");
      }else{
        System.out.println("no");
      }
      System.out.println(counter);
    }
  }

  private static boolean find(Long[] arr, Long[] indSum, Integer n, Integer k, Long partialSum) {
    counter++;
    //System.out.println(counter);
    for(int i=0,counter =0;i<k;i++){
      if(indSum[i].equals(0L)){
        counter++;
      }
      else{
        break;
      }
      if(counter == k.intValue()){
        answer = true;
      }
    }
    if(answer){
      return answer;
    }
        for(int i =0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<k;i++){
            System.out.print(indSum[i] + " ");
        }
        System.out.println();

    for(int j=0;j<k;j++){
      if(indSum[j].equals(0L)){
        continue;
      }
      for(int i=0;i<n;i++){
        if(arr[i].equals(0L)){
          continue;
        }
        if((indSum[j] - (arr[i])) >= 0L){
          indSum[j] = indSum[j] - (arr[i]);
          Long temp = arr[i];
          arr[i] = 0L;
          find(arr,indSum,n,k,partialSum);
          arr[i] = temp;
          indSum[j] = indSum[j] + (arr[i]);
          if(answer){
            return answer;
          }
        }

      }
    }

    return answer;
  }

}