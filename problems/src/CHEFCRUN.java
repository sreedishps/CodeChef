import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreps on 8/6/2016.
 */
public class CHEFCRUN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer N = Integer.parseInt(br.readLine());
            Integer input[] = new Integer[N];
            String temp[] = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(temp[i]);
            }
            temp = br.readLine().split(" ");
            Integer start = Integer.parseInt(temp[0]) - 1;
            Integer end = Integer.parseInt(temp[1]) - 1;

            Integer s = start;
            Integer e = end;

            //get right Path
            Integer rightCost = 0;
            Integer rightRunningMin = Integer.MAX_VALUE;
            while (start != end){
                rightCost += input[start];
                start = (start + 1) % N;
                if(rightRunningMin > rightCost){
                    rightRunningMin = rightCost;
                }
            }

            //get the split cost right path
            start = s;
            end = e;
            Integer rightSplitMin = Integer.MAX_VALUE, endTempMin= Integer.MAX_VALUE,startTempMin= Integer.MAX_VALUE;
            Integer endTemp = 0,startTemp = rightCost;
            while (start != end){
                if(endTemp <  endTempMin){
                    endTempMin = endTemp;
                }
                if(startTemp < startTempMin){
                    startTempMin = startTemp;
                }

                if(startTempMin + endTempMin < rightSplitMin){
                    rightSplitMin = startTempMin + endTempMin;
                }

                end = (end - 1 + N) % N;
                endTemp += input[end];
                startTemp -= input[end];
            }


            start = s;
            end = e;
            //get left Path
            Integer leftCost = 0;
            Integer leftRunningMin = Integer.MAX_VALUE;
            while (start != end){
                start = (start - 1 + N) % N;
                leftCost += input[start];
                if(leftRunningMin > leftCost){
                    leftRunningMin = leftCost;
                }
            }

            //get the split cost left side
            start = s;
            end = e;
            Integer leftSplitMin = Integer.MAX_VALUE;
            endTempMin= Integer.MAX_VALUE;
            startTempMin= Integer.MAX_VALUE;
            endTemp = 0;
            startTemp = leftCost;

            while (start != end){
                if(endTemp <  endTempMin){
                    endTempMin = endTemp;
                }
                if(startTemp < startTempMin){
                    startTempMin = startTemp;
                }

                if(startTempMin + endTempMin < leftSplitMin){
                    leftSplitMin = startTempMin + endTempMin;
                }

                endTemp += input[end];
                startTemp -= input[end];
                end = (end + 1 + N) % N;
            }


            //get right cost from destination
            start = s;
            end = e;
            Integer endRight = 0;
            Integer endRightMinimum = Integer.MAX_VALUE;
            while (start != end){
                endRight += input[end];
                end = (end + 1) % N;
                if(endRightMinimum > endRight){
                    endRightMinimum = endRight;
                }
            }


            //get left cost from destination
            start = s;
            end = e;
            Integer endLeft = 0;
            Integer endLeftMinimum = Integer.MAX_VALUE;
            while (start != end){
                end = (end - 1 + N) % N;
                endLeft += input[end];

                if(endLeftMinimum > endLeft){
                    endLeftMinimum = endLeft;
                }
            }

            Integer answer = Math.min(leftCost,rightCost);

            answer = Math.min(answer ,leftCost + 2 * rightRunningMin );
            answer = Math.min(answer , rightCost + 2 * leftRunningMin );

            answer = Math.min(answer, rightCost + 2 * endRightMinimum);
            answer = Math.min(answer, leftCost + 2 * endLeftMinimum);

            answer = Math.min(answer , 2 * rightCost + endRight);
            answer = Math.min( answer , 2 * leftCost + endLeft);

            answer = Math.min(answer , 2 * rightCost + leftCost + endRight);
            answer = Math.min( answer , 2 * rightCost + leftCost + endLeft);
            answer = Math.min( answer ,leftCost + rightSplitMin);
            answer = Math.min( answer ,rightCost + leftSplitMin);

            System.out.println(answer);

        }
    }


}
