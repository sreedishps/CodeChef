import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 08/01/15.
 */
public class ONEKING {
  private static Node leftmost;
  private static class Node {
    private int a;
    private int b;
    private Node left, right;
    private int max;
    private boolean alive;

    public Node(int a,int b) {
      this.a = a;
      this.b = b;
      this.max = b;
      this.alive = true;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(br.readLine());
    while(T > 0) {
      T--;
      Integer N = Integer.parseInt(br.readLine());
      Node root = null;
      while(N > 0){
        N--;
        String s = br.readLine();
        Integer A = Integer.parseInt(s.split(" ")[0]);
        Integer B = Integer.parseInt(s.split(" ")[1]);
        if(root == null){
          root = new Node(A,B);
        }else{
          treeInsert(root, A, B);
        }
      }
      int counter =0;

       while(true){

        leftmost = null;
        getLeftMost(root);
        if(leftmost == null){
          System.out.println(counter);
          break;
        }
        counter++;
        int bestPoint = getBestPoint(root,leftmost);
      // System.out.println("bomb = "+bestPoint);
        bombIt(root,bestPoint);

      }
    }
  }

  private static void bombIt(Node root, int i) {
    if(root == null){
      return ;
    }
    else if((i >= root.a) && (i<= root.b)){
      root.alive = false;
      bombIt(root.left,i);
      bombIt(root.right, i);
    }else if(i < root.a){
      bombIt(root.left, i);
    } else if(i > root.b){
      if(i <= root.max){
        bombIt(root.right, i) ;
        bombIt(root.left, i);
      }else{
        return;
      }
    }else{
      return;
    }
  }

  private static int getBestPoint(Node root, Node leftMost) {
    int max = 0;
    int point = 0;
    for(int i = leftMost.a; i<= leftMost.b ; i++){
      int temp = getOverlapsBruteForce(root,i);
      if( temp > max){
        max = temp;
        point = i;
      }
    }
    return point;
  }

  private static void getLeftMost(Node root) {
    if(root == null){
      return;
    }
    getLeftMost(root.left);
    if(root.alive){
      leftmost = root;
      return;
    }
    getLeftMost(root.right);
  }

  private static int getOverlaps(Node root, int i) {
    if(root == null){
      return 0;
    }
    else if((i >= root.a) && (i<= root.b)){
     // System.out.println(root.a+" "+root.b);
      if(root.alive)
        return 1 + getOverlaps(root.left,i) + getOverlaps(root.right,i);
      else{
        return  getOverlaps(root.left,i) + getOverlaps(root.right,i);
      }
    }else if(i < root.a){
      return getOverlaps(root.left,i);
    } else if(i > root.b){
      if(i <= root.max){
        return getOverlaps(root.right,i) + getOverlaps(root.left,i);
      }else{
        return 0;
      }
    }else{
      return 0;
    }
  }
  private static int getOverlapsBruteForce(Node root, int i) {
    if(root == null){
      return 0;
    }
    else if((i >= root.a) && (i<= root.b)){
      // System.out.println(root.a+" "+root.b);
      if(root.alive)
        return 1 + getOverlapsBruteForce(root.left,i) + getOverlapsBruteForce(root.right,i);
      else{
        return  getOverlapsBruteForce(root.left,i) + getOverlapsBruteForce(root.right,i);
      }
    }else {
      return  getOverlapsBruteForce(root.left,i) + getOverlapsBruteForce(root.right,i);
    }
  }

  private static void inOrder(Node root) {
    if(root == null){
      return;
    }
    inOrder(root.left);
    System.out.println(root.a + " " + root.alive+" "+root.max);
    inOrder(root.right);
  }

  private static void treeInsert(Node root, Integer a, Integer b) {
    Node temp = new Node(a,b);

    while(true){
      if((root.left == null) && (root.a > a )){
        if(root.max < temp.max){
          root.max = temp.max;
        }
        root.left = temp;
        break;
      }else if((root.right == null) && (root.a <= a )){
        if(root.max < temp.max){
          root.max = temp.max;
        }
        root.right = temp;
        break;
      }else if((root.left != null) && (root.a > a )){
        if(root.max < temp.max){
           root.max = temp.max;
        }
        root = root.left;
      }else if((root.right != null) && (root.a <= a )){
        if(root.max < temp.max){
          root.max = temp.max;
        }
        root = root.right;
      }
    }
  }

}