/**
 * Created by sreps on 8/11/2016.
 */
public class TopCoder {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[]= {1,4,3};
        int f[] = {4,5};
        System.out.println(mindiff(a,b,f));
    }

    public static String makerope(String s) {
        int dotCount = 0;

        int countRope[] = new int[100];
        for (int i = 0; i < 100; i++) {
            countRope[i] = 0;
        }

        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                dotCount++;
                countRope[current]++;
                current = 0;
            } else {
                current++;
            }
        }
        countRope[current]++;

        StringBuilder str = new StringBuilder();
        for (int i = 2; i < 100; i += 2) {
            if (countRope[i] > 0) {
                while (countRope[i] > 0) {
                    for (int j = 0; j < i; j++) {
                        str.append("-");
                    }
                    if(dotCount > 0){
                        str.append(".");
                        dotCount--;
                    }
                    countRope[i]--;
                }
            }
        }

        for (int i = 1; i < 100; i += 2) {
            if (countRope[i] > 0) {
                while (countRope[i] > 0) {
                    for (int j = 0; j < i; j++) {
                        str.append("-");
                    }
                    if(dotCount > 0){
                        str.append(".");
                        dotCount--;
                    }
                    countRope[i]--;
                }
            }
        }

        while (dotCount > 0){
            str.append(".");
            dotCount--;
        }

        return str.toString();
    }

    public static int mindiff(int[] A, int[] B, int[] F)
    {
        int[] elementsA = new int[1010];
        int[] elementsB = new int[1010];
        int[] elementsC = new int[1010];
        int totalStickers = F.length;

        for(int i = 0; i < 1010 ; i++){
            elementsA[i] = 0;
            elementsB[i] = 0;
            elementsC[i] = 0;
        }

        int totalMismatch = 0;
        for(int i = 0 ; i< A.length ; i++){
            elementsA[A[i]]++;
            elementsB[B[i]]++;
            if(A[i] != B[i]){
                totalMismatch++;
            }
        }

        for(int i = 0 ; i< F.length ; i++){
           elementsC[F[i]]++;
        }

        boolean flag[] = new boolean[1000];
        for(int i = 0 ; i< A.length ; i++){
            if(A[i] != B[i]){
                if(elementsC[B[i]] > 0){
                    A[i] = B[i];
                    elementsC[B[i]]--;
                    totalStickers--;
                    flag[i] = true;
                    totalMismatch--;
                }
            }
        }

        if(totalStickers > 0){
            for(int i = 0 ; i< A.length ; i++){
                if(flag[i]){
                    continue;
                }
                if(A[i] == B[i]){
                    if(elementsC[B[i]] > 0){
                        elementsC[B[i]]--;
                        totalStickers--;
                        flag[i] = true;
                    }
                }
            }
        }

        if(totalMismatch > totalStickers){
            return totalMismatch;
        }

       else return totalStickers;

    }
}
