import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 12/11/14.
 */
public class RBTREE {
  static boolean evenBlack;
  static boolean startNodeBlack;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    boolean black = true;
    evenBlack = true;
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      s = br.readLine();
      if(s.equals("Qi")) {
        evenBlack = !evenBlack;
        continue;
      }
      if(s.split(" ")[0].equals("Qb")){
        black = true;
      }else{
        black = false;
      }
      Long node1 = Long.parseLong(s.split(" ")[1]);
      Long node2 = Long.parseLong(s.split(" ")[2]);
      if ((getLevel(node1) % 2) == 0) {
        if (evenBlack) {
          startNodeBlack = true;
        } else {
          startNodeBlack = false;
        }
      } else if ((getLevel(node1) % 2) != 0) {
        if (evenBlack) {
          startNodeBlack = false;
        } else {
          startNodeBlack = true;
        }
      }
      Long distance = getDistance(node1,node2);
      if(black){
        if(startNodeBlack){
          System.out.println((distance/2) + (distance %2));
        }else{
          System.out.println((distance/2));
        }
      }else{
        if(!startNodeBlack){
          System.out.println((distance/2) + (distance %2));
        }else{
          System.out.println((distance/2));
        }
      }
    }
  }

  private static Long getDistance(Long a,Long b){
    Long distance = 0L;
    while(true) {
      Long aLevel = getLevel(a);
      Long bLevel = getLevel(b);
      if (aLevel == bLevel) {
        break;
      } else if (aLevel > bLevel) {
        a = getParent(a);
        distance++;
      } else {
        b = getParent(b);
        distance++;
      }
    }
    while(true){
      if(a.equals(b)){
        break;
      }else{
        a = getParent(a);
        b = getParent(b);
        distance += 2;
      }
    }
    return distance + 1;
  }
  private static Long getParent(Long l){
    return l/2;
  }
  private static Long getLevel(Long l) {
    Long bottom = 1L;
    Long top = 2L;
    Long answer = 0L;
    while(true){
      if(l >= bottom && l < top){
        break;
      }
      bottom = top;
      top = top * 2;
      answer++;
    }
    return answer;
  }
}
