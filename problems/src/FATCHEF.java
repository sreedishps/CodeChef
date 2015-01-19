import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by sreedish.ps on 09/10/14.
 */
public class FATCHEF {
    static BigInteger getCount(char arr[],int first,int last){
        if(first == last){
            return new BigInteger("1");
        }
        if((first +1) == last){
            return new BigInteger("1");
        }

        BigInteger  count = new BigInteger("1");
        for(int runner = first+1;runner<=last;runner++){
              if(arr[runner] != '1'){
                 if(arr[first] == arr[runner]){
                    first = runner;
                    continue;
                }
                else if (arr[first] != arr[runner]){
                      int distance = runner -first ;
                    first = runner;

                     count = count.multiply(new BigInteger(distance+""));
                    continue;
                }
            }
        }
        return count;
    }

    static BigInteger  solve(char arr[],int N,int M){

        BigInteger total = new BigInteger("1");
        if(M == 1){
            return total;
        }

        if(M == 2){
            if((arr[1] != '1') && (arr[N] != '1')){ //both on end
                return ( arr[1] == arr[N] )?new BigInteger("1"):new BigInteger("1");
            }
            else {
                int first =0, last=0;
                for(int i=1;i<=N;i++){
                    if(arr[i] != '1'){
                        first = i;
                        break;
                    }
                }
                for(int i=N;i>0;i--){
                    if(arr[i] != '1'){
                        last = i;
                        break;
                    }
                }
                return getCount(arr,first,last);
            }
        }
        if(M > 2){
            if((arr[1] != '1' ) && (arr[N] != '1')){
                int second =0;
                int secondlast =0;
                for(int i=2;i<=N;i++){
                    if(arr[i] != '1'){
                        second = i;
                        break;
                    }
                }
                for(int i=N-1;i>1;i--){
                    if(arr[i] != '1'){
                        secondlast = i;
                        break;
                    }
                }

                BigInteger count = getCount(arr,second,secondlast);
                BigInteger firstpart = (arr[1] == arr[second])?new BigInteger(0+""):getCount(arr,1,second);
                BigInteger lastpart = (arr[secondlast] == arr[N])?new BigInteger(0+""):getCount(arr,secondlast,N);

                count = count.multiply(firstpart).add(count.multiply(lastpart));

                return count;

            }else{
                int first=0, last=0;
                for(int i=1;i<=N;i++){
                    if(arr[i] != '1'){
                        first = i;
                        break;
                    }
                }
                for(int i=N;i>0;i--){
                    if(arr[i] != '1'){
                        last = i;
                        break;
                    }
                }
                return getCount(arr,first,last);

            }
        }


        return total;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int N,M,temp;
        Integer T = Integer.parseInt(br.readLine());
        while(T > 0){
            T--;
            s= br.readLine();
            N = Integer.parseInt(s.split(" ")[0]);
            M = Integer.parseInt(s.split(" ")[1]);
            char arr[] = new char[N+1];
            for(int i=1;i<=N;i++){
                arr[i] = '1';
            }

            for(int i=1;i<=M;i++){
                s= br.readLine();
                temp = Integer.parseInt(s.split(" ")[1]);
                arr[temp] = s.split(" ")[0].toCharArray()[0];
            }

            System.out.println(solve(arr, N, M).mod(new BigInteger(1000000009+"")));
        }

    }
}
