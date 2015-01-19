/**
 * Created by sreedish.ps on 26/09/14.
 */
public class PRIME1 {
    public static boolean[] primeSieve(int a){
        boolean[] arr = new boolean[a];

        for(int i=0;i<a;i++){
            arr[i] = true;
        }
        arr[0] = arr[1] = false;

        for(int i=0; i<a ;i++){
            if(!arr[i]){
                continue;
            }
            for(int j=i+i;j < a ;j+=i){
                arr[j] = false;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int max = 1000000000;
        boolean[] arr = primeSieve((int)Math.sqrt(max));

        System.out.println(arr[999]);
    }
}
