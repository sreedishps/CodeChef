import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 23/11/14.
 */
public class PETERSEN {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    Integer T = Integer.parseInt(br.readLine());
    while (T > 0) {
      s = br.readLine();
      System.out.println(printPath(s));
      T--;
    }
  }

  private static String printPath(String s) {
    char array[] = s.toCharArray();
    StringBuilder path = new StringBuilder();
    StringBuilder path2 = new StringBuilder();
    Long breakPoint = 0L;
    int vertex = 0;
    int vertex2 =0;
    boolean flag = false;
    for(Long i = 0L; i< s.length()-1 ; i++){
      Long j = i+1;
      if(array[i.intValue()] != array[j.intValue()]){
         breakPoint = j;
         path.append(getEdge(array[i.intValue()], array[j.intValue()]));
         vertex = Integer.parseInt(getEdge(array[i.intValue()], array[j.intValue()]).charAt(1)+"");
         vertex2 = Integer.parseInt(getEdge(array[i.intValue()], array[j.intValue()]).charAt(0)+"");
        flag = true;
         break;
      }
    }

    if(!flag){
      return printSingle(s);
    }

    for(Long pointer = breakPoint + 1L ; pointer < s.length() ; pointer++){
      vertex = getNext(vertex , s.charAt(pointer.intValue()));
      if(vertex == 10){
        return "-1";
      }
      path.append(vertex+"");
    }

    for(Long pointer = breakPoint - 2L ; pointer >= 0 ; pointer--){
      vertex2 = getNext(vertex2 , s.charAt(pointer.intValue()));
      if(vertex2 == 10){
        return "-1";
      }
      path2.append(vertex2+"");
    }

    path2 = path2.reverse();

    return path2.toString() + path.toString();
  }

  private static String printSingle(String s) {
    StringBuilder path = new StringBuilder();
    if(s.charAt(0) == 'A'){
      for(Long i = 0L; i< s.length() ; i++){
        if((i %2) == 0){
          path.append('0');
        }else{
          path.append('5');
        }
      }
    }
    if(s.charAt(0) == 'B'){
      for(Long i = 0L; i< s.length() ; i++){
        if((i %2) == 0){
          path.append('1');
        }else{
          path.append('6');
        }
      }
    }
    if(s.charAt(0) == 'C'){
      for(Long i = 0L; i< s.length() ; i++){
        if((i %2) == 0){
          path.append('2');
        }else{
          path.append('7');
        }
      }
    }
    if(s.charAt(0) == 'D'){
      for(Long i = 0L; i< s.length() ; i++){
        if((i %2) == 0){
          path.append('3');
        }else{
          path.append('8');
        }
      }
    }
    if(s.charAt(0) == 'E'){
      for(Long i = 0L; i< s.length() ; i++){
        if((i %2) == 0){
          path.append('4');
        }else{
          path.append('9');
        }
      }
    }
    return path.toString();
  }

  private static int getNext(int vertex , char dest){
    int next = 0;
      if(vertex == 0){
        if(dest  == 'A'){
          return 5;
        }
        else if(dest  == 'E'){
          return 4;
        }
        else if(dest  == 'B'){
          return 1;
        }
        else
          return 10;
      }

    if(vertex == 1){
      if(dest  == 'A'){
        return 0;
      }
      else if(dest  == 'B'){
        return 6;
      }
      else if(dest  == 'C'){
        return 2;
      }
      else
        return 10;
    }

    if(vertex == 2){
      if(dest  == 'B'){
        return 1;
      }
      else if(dest  == 'C'){
        return 7;
      }
      else if(dest  == 'D'){
        return 3;
      }
      else
        return 10;
    }

    if(vertex == 3){
      if(dest  == 'C'){
        return 2;
      }
      else if(dest  == 'D'){
        return 8;
      }
      else if(dest  == 'E'){
        return 4;
      }
      else
        return 10;
    }


    if(vertex == 4){
      if(dest  == 'D'){
        return 3;
      }
      else if(dest  == 'E'){
        return 9;
      }
      else if(dest  == 'A'){
        return 0;
      }
      else
        return 10;
    }


    if(vertex == 5){
      if(dest  == 'A'){
        return 0;
      }
      else if(dest  == 'D'){
        return 8;
      }
      else if(dest  == 'C'){
        return 7;
      }
      else
        return 10;
    }

    if(vertex == 6){
      if(dest  == 'B'){
        return 1;
      }
      else if(dest  == 'E'){
        return 9;
      }
      else if(dest  == 'D'){
        return 8;
      }
      else
        return 10;
    }


    if(vertex == 7){
      if(dest  == 'A'){
        return 5;
      }
      else if(dest  == 'C'){
        return 2;
      }
      else if(dest  == 'E'){
        return 9;
      }
      else
        return 10;
    }


    if(vertex == 8){
      if(dest  == 'A'){
        return 5;
      }
      else if(dest  == 'B'){
        return 6;
      }
      else if(dest  == 'D'){
        return 3;
      }
      else
        return 10;
    }


    if(vertex == 9){
      if(dest  == 'B'){
        return 6;
      }
      else if(dest  == 'C'){
        return 7;
      }
      else if(dest  == 'E'){
        return 4;
      }
      else
        return 10;
    }


    return next;
  }
  private static String getEdge(char c,char d) {
    if(c == 'A'){
      if(d == 'B'){
        return "01";
      }
      if(d == 'C'){
        return "57";
      }
      if(d == 'D'){
        return "58";
      }
      if(d == 'E'){
        return "04";
      }
    }


    if(c == 'B'){
      if(d == 'A'){
        return "10";
      }
      if(d == 'C'){
        return "12";
      }
      if(d == 'D'){
        return "68";
      }
      if(d == 'E'){
        return "69";
      }
    }


    if(c == 'C'){
      if(d == 'A'){
        return "75";
      }
      if(d == 'B'){
        return "21";
      }
      if(d == 'D'){
        return "23";
      }
      if(d == 'E'){
        return "79";
      }
    }


    if(c == 'D'){
      if(d == 'A'){
        return "85";
      }
      if(d == 'B'){
        return "86";
      }
      if(d == 'C'){
        return "32";
      }
      if(d == 'E'){
        return "34";
      }
    }

    if(c == 'E'){
      if(d == 'A'){
        return "40";
      }
      if(d == 'B'){
        return "96";
      }
      if(d == 'C'){
        return "97";
      }
      if(d == 'D'){
        return "43";
      }
    }

    return "";
  }
}
