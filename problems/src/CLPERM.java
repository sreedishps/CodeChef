import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 11/01/15.
 */
public class CLPERM {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      String s = br.readLine();
      Integer N = Integer.parseInt(s.split(" ")[0]);
      Integer K = Integer.parseInt(s.split(" ")[1]);

      if(K.equals(0)){
        Integer tries  = N * (N+1) /2 ;
        if(tries %2 == 0){
          System.out.println("Chef");
        }else{
          System.out.println("Mom");
        }
      }else{
        boolean numberarray[] = new boolean[N+1];
        s = br.readLine();
        for(int i =0;i<K;i++){
          Integer index = Integer.parseInt(s.split(" ")[i]);
          numberarray[index] = true;
        }
        int i=0;
        while (true){
          i++;
          if(check(i,numberarray,N,K)){
            continue;
          }else{
            if((i%2) == 0){
              System.out.println("Mom");
            }else{
              System.out.println("Chef");
            }
            break;
          }
        }
      }
    }
  }

  private static boolean check(int i, boolean[] numberarray ,Integer N,Integer K) {



    if(i < 0){
      return false;
    }
    if(i == 0){
      return true;
    }
    boolean answer = false;
    if(i > 0){
      for(int j= 1;j <= N ; j++){
        if(!numberarray[j] && j<= i){
              numberarray[j] = true;
              answer  = answer || check(i-j,numberarray,N,K);
              numberarray[j] = false;
          if(answer){
            return true;
          }
        }
      }
    }
    return false;
  }
}
