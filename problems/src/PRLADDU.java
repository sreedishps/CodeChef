import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by sreedish.ps on 06/10/14.
 */
public class PRLADDU {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int arr[] = new int[100001];
        Integer T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;

            Integer N = Integer.parseInt(br.readLine());

            s = br.readLine();

            StringTokenizer st = new StringTokenizer(s);

            int i =0;
            while (st.hasMoreElements()) {
                arr[i] = Integer.parseInt(st.nextElement()+"");
                i++;
            }



            int  vil = 0, cost = 0;

            for (int din = 0; din < N; din++) {
                while (arr[din] < 0 && din < N) {
                    if(din == N){
                        break;
                    }
                    while (arr[vil] <= 0 && vil < N) {
                        vil++;
                    }
                    if(vil == N){
                        break;
                    }
                    if (arr[din]+ arr[vil] <= 0) {
                        cost = cost + (arr[vil] * Math.abs(din - vil));
                        arr[din] = arr[din] + arr[vil];
                        arr[vil] = 0;
                        vil++;
                    }
                    else if(arr[din]+ arr[vil] > 0) {
                        cost = cost + (Math.abs(arr[din]) * Math.abs(din - vil));
                        arr[vil] = arr[din] + arr[vil];
                        arr[din] = 0;
                    }
                }
            }

            System.out.println(cost);
        }
    }
}
