public class CPLAYFix {
    public static void main(String[] args) {

        for(int i = 2000000 ; i < 4000000 ; i++){
            String binaryIntInStr = Integer.toBinaryString(i);
            String input = (String.format("%20s", binaryIntInStr).replace(" ", "0"));
//input = "10101101010000000001";
            System.out.println(input);
            int a = check1(input);
             check2(input);

            System.out.println(a);
        }
    }

    private static void check2(String temp) {
        int teamA = 0;
        int teamB = 0;
        int i = 0;
        for (i = 0; i < 20; i += 2) {
            if (temp.charAt(i) == '1') {
                teamA++;
            }

            if (check(teamA, teamB, i + 1)) {
                break;
            }

            if (temp.charAt(i + 1) == '1') {
                teamB++;
            }

            if (check(teamA, teamB, i + 2)) {
                break;
            }
        }
        if(i == 20)
            System.out.println("TIE");
    }

    private static boolean check(int teamA, int teamB, int kick) {
        if (kick <= 5) {
            return false;
        }

      //  if (kick == 5 && teamA == 3 && teamB == 0) {
     //       System.out.println("TEAM-A 5");
     //       return true;
     //   }

        if (kick == 6 && teamA == 0 && teamB == 3) {
            System.out.println("TEAM-B 6");
            return true;
        }

        if (kick == 7 && ((teamA - teamB) > 2)) { // A win
            System.out.println("TEAM-A 7");
            return true;
        }

        if (kick == 7 && ((teamB - teamA) > 1 )) { // B win
            System.out.println("TEAM-B 7");
            return true;
        }



        if (kick == 8 && (teamA - teamB) >= 2) { // A win
            System.out.println("TEAM-A 8");
            return true;
        }

        if (kick == 8 && (teamB - teamA) >= 2) { // B win
            System.out.println("TEAM-B 8");
            return true;
        }



        if (kick == 9 && (teamA - teamB) >= 2) { // A win
            System.out.println("TEAM-A 9");
            return true;
        }

        if (kick == 9 && (teamB > teamA)) { // B win
            System.out.println("TEAM-B 9");
            return true;
        }



        if (kick == 10 && (teamA > teamB)) {
            System.out.println("TEAM-A 10");
            return true;
        }

        if (kick == 10 && (teamB > teamA)) {
            System.out.println("TEAM-B 10");
            return true;
        }

        if (kick > 10 && (kick % 2 == 1)) {
            return false;
        }

        if (kick > 10 && teamA > teamB) {
            System.out.println("TEAM-A " + kick);
            return true;
        }

        if (kick > 10 && teamA < teamB) {
            System.out.println("TEAM-B " + kick);
            return true;
        }

        return false;
    }

    private static int check1(String input) {
        int a = 0 , b = 0 ;
        for(int i = 0 ; i < 10 ; i++){
            if(i % 2 == 0 && input.charAt(i) == '1'){
                a++;
            }

            if(i % 2 == 1 && input.charAt(i) == '1'){
                b++;
            }
        }

        if(a > b){
            return  1;
        }

        if(b > a){
            return 2;
        }
        for(int i = 10 ; i < 20 ; i+=2){
            if(input.charAt(i) == '1'){
                a++;
            }
            if(input.charAt(i+1) == '1'){
                b++;
            }

            if(a > b){
                return  1;
            }

            if(b > a){
                return 2;
            }
        }
        return 3;
    }
}

