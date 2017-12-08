import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFUNI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String temp[] = br.readLine().split(" ");
            Integer X = Integer.parseInt(temp[0]);
            Integer Y = Integer.parseInt(temp[1]);
            Integer Z = Integer.parseInt(temp[2]);

            Integer A = Integer.parseInt(temp[3]);
            Integer B = Integer.parseInt(temp[4]);
            Integer C = Integer.parseInt(temp[5]);

            //reduce
            Integer min = Math.min(Math.min(X,Y),Z);
            min = min - min % 2;

            Long cost = 0L;
            Integer hopes = min/2;
            cost += (Math.min(Math.min( 6 * A , 3 * B), 2 * C));
            cost *= hopes;

            X -= min;
            Y -=min;
            Z -= min;

            Long dp[][][] = new Long[X+1][Y+1][Z+1];

            for(int i =0;i<= X ; i++){
                for(int j = 0 ; j <= Y ; j++){
                    for(int k = 0 ; k <= Z ; k++){
                        dp[i][j][k] = 0L;
                        Long minEnergy = Long.MAX_VALUE;

                        //one hope
                        if(i > 0){
                           if(minEnergy > (dp[i-1][j][k] + A)){
                               minEnergy = dp[i-1][j][k] + A;
                           }
                        }

                        if(j > 0){
                            if(minEnergy > (dp[i][j-1][k] + A)){
                                minEnergy = dp[i][j-1][k] + A;
                            }
                        }

                        if(k > 0){
                            if(minEnergy > (dp[i][j][k-1] + A)){
                                minEnergy = dp[i][j][k-1] + A;
                            }
                        }

                        //two hopes
                        if(i > 0 && j > 0){
                            if(minEnergy > (dp[i-1][j-1][k] + B)){
                                minEnergy = dp[i-1][j-1][k] + B;
                            }
                        }
                        if(j > 0 && k > 0){
                            if(minEnergy > (dp[i][j-1][k-1] + B )){
                                minEnergy = dp[i][j-1][k-1] + B;
                            }
                        }
                        if(i > 0 && k > 0){
                            if(minEnergy > (dp[i-1][j][k-1] + B)){
                                minEnergy = dp[i-1][j][k-1] + B;
                            }
                        }

                        //three hopes
                        if(i > 0 && j >0 && k > 0){
                            if(minEnergy > (dp[i-1][j-1][k-1] + C)){
                                minEnergy = dp[i-1][j-1][k-1] + C;
                            }
                        }

                        if(i == 0 && j == 0 && k==0){
                            continue;
                        }

                        dp[i][j][k] = minEnergy;
                    }
                }
            }

            cost += (dp[X][Y][Z]);

            System.out.println(cost);

        }
    }
}
