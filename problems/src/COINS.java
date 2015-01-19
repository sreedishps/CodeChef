import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 24/09/14.
 */
public class COINS {
    static long[] arr = new long[4000];
    public static void main(String[] args) throws IOException{

        long value;

        for( int i=1;i<4000;i++){
            arr[i] = Math.max(arr[i/2] + arr[i/3] + arr[i/4], i) ;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            System.out.println(getMaxValue(Long.parseLong(s)));
        }



    }
    public static long getMaxValue(long value){
        if(value < 12){
            return value;
        }
        if(value < 4000){
            return arr[Integer.parseInt(value+"")];
        }

       return Math.max(value,getMaxValue(value/2)+getMaxValue(value/3)+getMaxValue(value/4));
    }
}
