import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GIT01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            String s = br.readLine();
            Integer N = Integer.parseInt(s.split(" ")[0]);
            Integer Q = Integer.parseInt(s.split(" ")[1]);

            String inp[] = new String[N];

            for (int i = 0; i < N; i++) {
                inp[i] = br.readLine();
            }

            int cost1 = 0, cost2 = 0;

            boolean redLine = true;
            boolean redFlower = true;
            for (int i = 0; i < N; i++) {

                if (redLine) {
                    redFlower = true;
                }else{
                    redFlower = false;
                }

                for (int j = 0; j < Q; j++) {
                    if (inp[i].charAt(j) == 'R') {
                        if (!redFlower) {
                            cost1 += 5;
                        }
                    }

                    if (inp[i].charAt(j) == 'G') {
                        if (redFlower) {
                            cost1 += 3;
                        }
                    }

                    redFlower = !redFlower;
                }
                redLine = !redLine;
            }

            redLine = false;
            redFlower = false;
            for (int i = 0; i < N; i++) {

                if (redLine) {
                    redFlower = true;
                }else {
                    redFlower = false;
                }

                for (int j = 0; j < Q; j++) {
                    if (inp[i].charAt(j) == 'R') {
                        if (!redFlower) {
                            cost2 += 5;
                        }
                    }

                    if (inp[i].charAt(j) == 'G') {
                        if (redFlower) {
                            cost2 += 3;
                        }
                    }

                    redFlower = !redFlower;
                }
                redLine = !redLine;
            }

            System.out.println(Math.min(cost1,cost2));
        }
    }
}
