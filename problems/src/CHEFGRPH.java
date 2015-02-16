import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sreedish.ps on 09/02/15.
 */
public class CHEFGRPH {
  static HashMap<Long,Long> layerWays;
  static HashMap<String,Long> incoming;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Long N = Long.parseLong(str.split(" ")[0]);
    Long M = Long.parseLong(str.split(" ")[1]);
    Integer K = Integer.parseInt(str.split(" ")[2]);

    HashMap<Long, List<String>> edges = new HashMap<Long, List<String>>();

    incoming = new HashMap<String, Long>();
    incoming.put((N + 1) + " " + "0", 0L);

    /*
    get all the extra edges
     */
    for (int i = 0; i < K.intValue(); i++) {
      str = br.readLine();
      Long p = Long.parseLong(str.split(" ")[0]);
      List<String> currentValue = edges.get(p);
      if (currentValue == null) {
        currentValue = new ArrayList<String>();
        currentValue.add(str);
        edges.put(p, currentValue);
      } else {
        currentValue.add(str);
      }

    }

    /*
    process layer by layer
     */

  }
}
