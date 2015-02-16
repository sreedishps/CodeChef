import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 17/02/15.
 */
public class STFM {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Long N = Long.parseLong(str.split(" ")[0]);
    Long M = Long.parseLong(str.split(" ")[1]);
    long fact[] = new long[M.intValue()];

    fact[0] = 1;
    for (int i = 1; i < M; i++) {
      fact[i] = fact[i - 1] * i;
      fact[i] %= M;
    }

    long dp[] = new long[M.intValue()];
    for(int i=1;i<M;i++){
      dp[i] = (dp[i-1]  + (i * fact[i])) % M ;
    }

    BigInteger result = BigInteger.ZERO;
    String s[] = br.readLine().split(" ");

    for(int i = 0; i< N; i++)
    {
      BigInteger num = new BigInteger(s[i]);
      result = result.add(new BigInteger(dp[(int)Math.min(Long.parseLong(s[i]),M-1)]+""));
      result = result.mod(new BigInteger(M+""));

      BigInteger temp = num.multiply(num);
      temp = temp.multiply(num.add(BigInteger.ONE));
      temp = temp.divide(new BigInteger("2"));
      temp = temp.mod(new BigInteger(M+""));
      result = result.add(temp);
      result = result.mod(new BigInteger(M+""));
    }

    System.out.println(result);

  }
}
