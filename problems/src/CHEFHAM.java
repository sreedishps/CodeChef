import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CHEFHAM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Long sum = 0L;
            Integer N = Integer.parseInt(br.readLine());
            Integer inp[] = new Integer[N];
            Integer inp2[] = new Integer[N];
            String temp[] = br.readLine().split(" ");
            boolean single[] = new boolean[100001];
            boolean doubl[] = new boolean[100001];
            HashMap<Integer, Integer> doublesMap = new HashMap<>();
            Integer firstKey = null;
            Integer currentKey = null;
            Integer doublesCount = 0, singlesCount = 0;

            for (int i = 0; i < N; i++) {
                inp[i] = Integer.parseInt(temp[i]);
                inp2[i] = Integer.parseInt(temp[i]);
                if (single[inp[i]]) {
                    single[inp[i]] = false;
                    doubl[inp[i]] = true;
                    doublesCount++;
                    singlesCount--;
                } else {
                    single[inp[i]] = true;
                    singlesCount++;

                }
            }

            for (int i = 1; i <= 100000; i++) {
                if (!doubl[i]) {
                    continue;
                }

                if (firstKey == null) {
                    firstKey = i;
                    currentKey = i;
                    continue;
                }


                doublesMap.put(currentKey, i);
                currentKey = i;
            }
            doublesMap.put(currentKey, firstKey);


            for (int i = 0; i < N; i++) {
                if (doublesMap.containsKey(inp[i])) {
                    inp[i] = doublesMap.get(inp[i]);
                }
            }

            if (singlesCount > 1) {
                Integer firstNum = null, currentNum = null, firstIndex = null;
                for (int i = 0; i < N; i++) {
                    if (!doublesMap.containsKey(inp[i])) {
                        if (firstNum == null) {
                            firstNum = inp[i];
                            firstIndex = i;
                            currentNum = inp[i];
                            continue;
                        }

                        Integer tempN = inp[i];
                        inp[i] = currentNum;
                        currentNum = tempN;
                    }
                }

                inp[firstIndex] = currentNum;
            } else if (singlesCount == 1 && doublesCount > 0) {
                Integer lonerIndex = null;
                for (int i = 0; i < N; i++) {
                    if (!doublesMap.containsKey(inp[i])) {
                        lonerIndex = i;
                    }
                }
                for (int i = 0; i < N; i++) {
                    if (doublesMap.containsKey(inp[i])) {
                        Integer tempN = inp[i];
                        inp[i] = inp[lonerIndex];
                        inp[lonerIndex] = tempN;
                        break;
                    }
                }

            }

            if (doublesCount == 1 && singlesCount > 1) {
                Integer lonerIndex1 = null, lonerIndex2 = null;
                for (int i = 0; i < N; i++) {
                    if (doublesMap.containsKey(inp[i])) {
                        if (lonerIndex1 == null) {
                            lonerIndex1 = i;
                        } else lonerIndex2 = i;
                    }
                }
                int index = 0;
                for (int i = 0; i < N; i++) {
                    if (!doublesMap.containsKey(inp[i])) {
                        Integer tempN = inp[i];
                        inp[i] = inp[lonerIndex1];
                        inp[lonerIndex1] = tempN;
                        index = i+1;
                        break;

                    }
                }

                for (int i = index; i < N; i++) {
                    if (!doublesMap.containsKey(inp[i])) {
                        Integer tempN = inp[i];
                        inp[i] = inp[lonerIndex2];
                        inp[lonerIndex2] = tempN;
                        index = i+1;
                        break;

                    }
                }

            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                if(!inp[i].equals(inp2[i])){
                    count++;
                }
            }

            System.out.println(count);
            for (int i = 0; i < N; i++) {
                System.out.print(inp[i] + " ");
            }
            System.out.println();


        }
    }
}
