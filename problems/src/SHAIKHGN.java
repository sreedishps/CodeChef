import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by sreps on 8/5/2016.
 */
public class SHAIKHGN {
    Integer previous;
    Integer current;
    Integer empty;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        boolean adj[][] = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String temp[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (temp[j].equals("0")) {
                    continue;
                } else {
                    adj[i][j] = true;
                }
            }
        }

        Integer M = Integer.parseInt(br.readLine());
        Long queries[][] = new Long[M][2];
        int counter = 0;
        HashMap<Long, HashMap<Long, Result>> queryMap = new HashMap<>();

        while (M-- > 0) {
            String kx[] = br.readLine().split(" ");
            Long k = Long.parseLong(kx[0]);
            Long x = Long.parseLong(kx[1]) - 1;

            queries[counter][0] = k;
            queries[counter][1] = x;

            if (queryMap.get(x) == null) {
                HashMap<Long, Result> temp = new HashMap<>();
                temp.put(k, new Result());
                queryMap.put(x, temp);
            } else {
                queryMap.get(x).put(k, new Result());
            }

            counter++;
        }

        for (Long startFriend : queryMap.keySet()) {
            HashMap<Long, TreeSet<Long>> propagation = new HashMap<>();
            propagation.put(0l, new TreeSet<Long>());
            propagation.get(0l).add(startFriend);
            long mod = getPropagation(1l, adj, propagation, N);

        }
    }

    static class Result{
        Long count;
        TreeSet<Long> friends;
        Result(){
            count  = 0l;
            friends = new TreeSet<Long>();
        }
    }

    private static long getPropagation(long currentMinute, boolean[][] adj, HashMap<Long, TreeSet<Long>> propagation, Integer N) {
        TreeSet<Long> lastMinuteSet = propagation.get(currentMinute - 1);
        TreeSet<Long> currentMinutSet = new TreeSet<Long>();
        for(Long i : lastMinuteSet){
            for(Long j = 0l; j < N ; j++){
                if(adj[i.intValue()][j.intValue()]){
                    currentMinutSet.add(j);
                }
            }
        }

        for(Map.Entry<Long, TreeSet<Long>> alreadySeen : propagation.entrySet()){
             if(alreadySeen.getValue().equals(currentMinutSet)){
                 return currentMinute - alreadySeen.getKey();
             }
        }

        propagation.put(currentMinute, currentMinutSet);
        return  getPropagation(currentMinute+1, adj,propagation,N);
    }
}
