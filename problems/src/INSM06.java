import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 26/09/14.
 */
public class INSM06 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s = br.readLine();
        Integer N = Integer.parseInt(s.split(" ")[0]);
        Integer M = Integer.parseInt(s.split(" ")[1]);

        int arr[][] = new int[N][N];
        for(int i=0;i<N;i++){
            s = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(s.split(" ")[j]);
            }
        }

        while(M > 0){
            M--;
            int angle = Integer.parseInt(br.readLine());
            rotate_matrix_cw_90(arr,((M/90) + 1)%4);
            printMatrix(arr,N);
            rotate_matrix_cw_90(arr,4 - ((M/90 + 1)%4 ));
        }



    }

    private static void printMatrix(int[][] arr, Integer N) {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate_matrix_cw_90(int m[][], int n)
    {
        int i, j;


        for (i = 0; i < n; i++)
        {
            for (j = i + 1; j < n; j++)
            {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }

        // mirror the matrix horizontally.
        for (i = 0; i < n / 2; i++)
        {
            for (j = 0; j < n; j++)
            {
                int tmp = m[j][i];
                m[j][i] = m[j][n - i - 1];
                m[j][n - i - 1] = tmp;
            }
        }
    }
}
