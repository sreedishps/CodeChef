import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 13/11/14.
 */
public class CHEFWORD {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while (T > 0) {
      T--;
      s = br.readLine();
      Long N = Long.parseLong(s.split(" ")[0]);
      Long K = Long.parseLong(s.split(" ")[1]);
      String word = br.readLine();

      Double probability[][] = new Double[26][26];
      Double evenClap[][] = new Double[26][26];
      Double oddClap[][] = new Double[26][26];

      for (int i = 0; i < 26; i++) {
        s = br.readLine();
        String temp[] = s.split(" ");
        for (int j = 0; j < 26; j++) {
          probability[i][j] = Double.parseDouble(temp[j]);
          oddClap[i][j] = probability[i][j];
        }
      }
      Long counter = new Long("2");
      while (counter.longValue() <= K.longValue()) {
        if ((counter.longValue() % 2) == 0) {
          for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
              Double prob = 0.0;
              for (int target = 0; target < 26; target++) {
                prob += probability[target][j] * oddClap[i][target];
              }
              evenClap[i][j] = prob;
            }
          }
        } else {
          for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
              Double prob = 0.0;
              for (int target = 0; target < 26; target++) {
                prob += probability[target][j] * evenClap[i][target];
              }
              oddClap[i][j] = prob;
            }
          }
        }
        counter++;
      }

      Double output = 0.0;
      for(int words = 0 ;words< N ; words++){
        String wordinlist = br.readLine();
        if(wordinlist.length() != word.length()){
          continue;
        }
        if((K % 2) == 0){
          Double temp = 1.0;
          for(int i=0;i<word.length();i++){
            int target = (word.charAt(i)) - 'a';
              int begin = (wordinlist.charAt(i)) - 'a' ;
            temp *= evenClap[target][begin];
          }
          output += temp;
        }else{
          Double temp = 1.0;
          for(int i=0;i<word.length();i++) {
            int target = (word.charAt(i)) - 'a';
            int begin = (wordinlist.charAt(i)) - 'a';
            temp *= oddClap[target][begin];
          }
          output += temp;
        }
      }
      System.out.println(output);
    }
  }
}

