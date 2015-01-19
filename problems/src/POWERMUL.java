import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 07/11/14.
 */
public class POWERMUL {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      s = br.readLine();
      Long N = Long.parseLong(s.split(" ")[0]);
      Long M = Long.parseLong(s.split(" ")[1]);
      Long Q = Long.parseLong(s.split(" ")[2]);

      for(Long i=0L;i<Q;i++){
        Long R = Long.parseLong(br.readLine());
        if(N <= 5L){
          System.out.println(fomb(N,R,M) % M);
        }else if(N <= 500L){
          System.out.println(fomb500(N, R, M));
        }
      }

    }
  }

  private static BigInteger fomb500(Long n, Long r, Long m) {
    BigInteger num = new BigInteger("1");
    BigInteger numerator = new BigInteger("1");
    BigInteger denominator = new BigInteger("1");
    for(Long i = 1L;i<=r;i++){
        denominator = denominator.multiply(pow500(i,m));
    }
    for(Long i = n-r+1;i<=n;i++){
      numerator = numerator.multiply(pow500(i,m));
    }
    num = numerator.divide(denominator);
    num = num.mod(new BigInteger(m+""));
    return num;
  }

  private static Long fomb(Long n, Long r, Long m) {
    Long den = 1L;
    Long num = 1L;
    if(r > (n/2)){
      for(Long i=1L;i<=(n-r);i++){
          den *= pow(i,m);
      }
      for(Long i= r+1 ;i<=n;i++){
        num *= pow(i,m);
      }
      return (num/den) ;
    }else{
      for(Long i=1L ; i<= r;i++){
        den *= pow(i,m);
      }
      for(Long i= (n-r+1) ;i<=n;i++){
        num *= pow(i,m);
      }
      return (num/den) ;

    }
  }
  private  static long pow(Long i,Long m){
    Long answer = 1L;
    for(Long j=1L;j<= i ;j++){
      answer *= i;
    }
    return answer;
  }
  private  static BigInteger pow500(Long i,Long m){
    BigInteger answer = new BigInteger("1");
    BigInteger value = new BigInteger(i+"");
    for(Long j=1L;j<= i ;j++){
      answer = answer.multiply(value);
    }
    return answer;
  }

}
