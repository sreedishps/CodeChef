import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class VK18 {
    static HashMap<Integer,Integer> mem = new HashMap<>();
    static HashMap<Integer,Integer> HouseMap = new HashMap<>();
    static Integer max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        HouseMap.put(1,2);
        HouseMap.put(2,12);
        HouseMap.put(3,36);

        Integer previousValue = 24;
        Integer newValue;
        for(int i = 4; i <= 1000000 ; i++){
            newValue = previousValue - 2 * count(i) + 2 * count(2 * i - 1) + count( 2 * i) + count( 2 * i - 2);
            HouseMap.put(i,newValue + HouseMap.get(i-1));
            previousValue = newValue;
        }

       for(int i = 1 ; i < 1000 ; i++ ) {
            System.out.println(i + " " + HouseMap.get(i));
       }

        while (T-- > 0) {
            Long sum = 0L;
            Integer N = Integer.parseInt(br.readLine());

//            for(int i = 2 ; i <= N + 1 ; i++){
//                sum += (count(i) * (i -1 ));
//            }
//
//            for(int i = 2 ; i <= N ; i++){
//                sum += (count(N + i) * (N - i + 1));
//            }



            System.out.println(HouseMap.get(N));
        }
    }

    private static Integer count(int room) {
        if(!mem.containsKey(room)){
            mem.put(room,Math.abs(even(room) - odd(room)));
        }
        return mem.get(room);
    }

    private static int odd(int room) {
        int sum = 0;
        while (room > 0){
            if((room % 10) % 2 != 0){
                sum += room % 10;
            }
            room = room / 10;
        }
        return sum;
    }

    private static int even(int room) {
        int sum = 0;
        while (room > 0){
            if((room % 10) % 2 == 0){
                sum += room % 10;
            }
            room = room / 10;
        }
        return sum;
    }
}
