import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 03/01/15.
 */
public class GCDQ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      String s = br.readLine();
      Integer N = Integer.parseInt(s.split(" ")[0]);
      Integer Q = Integer.parseInt(s.split(" ")[1]);

      String Astring[] = br.readLine().split(" ");
      Integer A[] = new Integer[N];
      for(int i =0;i<N;i++){
        A[i] = Integer.parseInt(Astring[i]);
      }

      Integer left[] = new Integer[N];
      Integer right[] = new Integer[N];

      left[0] = A[0];
      right[N-1] = A[N-1];

      for(int i =1;i<N;i++){
        left[i] = GCD(left[i-1], A[i]);
      }

      for(int i = N-2 ;i >= 0 ;i--){
        right[i] = GCD(right[i+1], A[i]);
      }
//
//      for (int i =0;i<N;i++){
//        System.out.print(left[i]+" ");
//      }
//      System.out.println();
//      for (int i =0;i<N;i++){
//        System.out.print(right[i]+" ");
//      }
//      System.out.println();

     while (Q > 0){
       Q--;
       s = br.readLine();
       int l,r;
       Integer L = Integer.parseInt(s.split(" ")[0]);
       Integer R = Integer.parseInt(s.split(" ")[1]);

       if(L.compareTo(1) == 0){
         l=0;
       }else{
         l = left[L-2];
       }

       if(R.compareTo(N) == 0){
         r =0;
       }else{
         r = right[R];
       }

       System.out.println( GCD(l ,r));
     }

    }
  }
  public static int GCD(int a, int b) {
    if (b==0) return a;
    return GCD(b,a%b);
  }
}
