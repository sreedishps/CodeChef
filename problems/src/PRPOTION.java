import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 05/10/14.
 */
public class PRPOTION {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Long T =  Long.parseLong(br.readLine());
        while(T > 0){
            T--;

            int i =0;
            s = br.readLine();
            Long R = Long.parseLong(s.split(" ")[0]);
            Long G = Long.parseLong(s.split(" ")[1]);
            Long B = Long.parseLong(s.split(" ")[2]);
            Long M = Long.parseLong(s.split(" ")[3]);

            Long Rarr[] = new Long[R.intValue()];
            Long Garr[] = new Long[G.intValue()];
            Long Barr[] = new Long[B.intValue()];

            s= br.readLine();

            for(i=0;i<R;i++){
               Rarr[i] = Long.parseLong(s.split(" ")[i]);
            }

            s= br.readLine();

            for(i=0;i<G;i++){
                Garr[i] = Long.parseLong(s.split(" ")[i]);
            }

            s= br.readLine();

            for(i=0;i<B;i++){
                Barr[i] = Long.parseLong(s.split(" ")[i]);
            }


            while(M>0){
                M--;
                Long Rmax = getMax(Rarr);
                Long Gmax =  getMax(Garr);
                Long Bmax =  getMax(Barr);

                Long max = 0L;
                if(Rmax > Gmax){
                    max = Rmax;
                }else{
                    max = Gmax;
                }

                if(Bmax > max){
                    MakeHalf(Barr);
                }
                else{
                    if(max == Rmax){
                        MakeHalf(Rarr);
                    }
                    else {
                        MakeHalf(Garr);
                    }
                }
            }

            Long Rmax = getMax(Rarr);
            Long Gmax =  getMax(Garr);
            Long Bmax =  getMax(Barr);

            Long max = 0L;

            if(Rmax > Gmax){
                max = Rmax;
            }else{
                max = Gmax;
            }

            if(Bmax > max){
                System.out.println(Bmax);
            }
            else{
                if(max == Rmax){
                    System.out.println(Rmax);
                }
                else {
                    System.out.println(Gmax);
                }
            }

        }

    }

    private static void MakeHalf(Long[] arr) {
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i] /2;
        }
    }

    private static Long getMax(Long[] arr) {
        Long max = 0L;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
