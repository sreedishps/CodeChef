import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by sreedish.ps on 08/01/15.
 */
public class ONEKING2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      Integer N = Integer.parseInt(br.readLine());
      TreeSet<String> nodes = new TreeSet<String>();

      while(N > 0){
        N--;
        String s = br.readLine();
        s+= " ";
        s+= N;
        nodes.add(s);
      }

      Integer bomb = 0;
      while(true){
        if(nodes.size() == 0){
          break;
        }
        String s = nodes.first();

        Integer A = Integer.parseInt(s.split(" ")[0]);
        Integer B = Integer.parseInt(s.split(" ")[1]);

        Integer size = B - A + 1;
        int max[] = new int[size];



          Iterator<String> itr = nodes.iterator();
            while(itr.hasNext()){
            s = itr.next();
            Integer tempA = Integer.parseInt(s.split(" ")[0]);
            Integer tempB = Integer.parseInt(s.split(" ")[1]);

            for(Integer tmp = tempA; tmp <= tempB ; tmp++){
              if((tmp >= A) && (tmp <= B)){
                max[tmp-A]++;
              }
            }

          }


        Integer toBomb = 0;
        Integer overlap =0;
        for(Integer i=A;i<=B;i++){
          if(max[i-A] > overlap){
            overlap = max[i-A];
            toBomb = i;
          }
        }
        //System.out.println("bombing "+toBomb);

        bomb++;
        
        itr = nodes.iterator();
        String toRemove = "";

        while(itr.hasNext()) {
          s = itr.next();
          Integer tempA = Integer.parseInt(s.split(" ")[0]);
          Integer tempB = Integer.parseInt(s.split(" ")[1]);

          if((toBomb>= tempA) && (toBomb<= tempB)){
            toRemove += s;
            toRemove += 'a';
          }
        }

        String arr[] = toRemove.split("a");
        for(int i=0;i<arr.length;i++){
          nodes.remove(arr[i]);
        }
      }

      System.out.print(bomb);

    }
  }



}