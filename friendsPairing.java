import java.util.*;

public class friendsPairing {
    public static int c = 1;
    public static void friendsPair(int count, int n, boolean[] used, String asf){
        if(count == n){
            System.out.println(c++ + "." + asf);
            return;
        }


        int fup = 1;
        while(fup <= n && used[fup]) fup++; //find unused person

        used[fup] = true;
        friendsPair(count + 1, n, used, asf + "(" + fup + ") ");

        for(int pp = fup + 1; pp <= n; pp++){
            if(!used[pp]){ //second unused person
                used[pp] = true;
                friendsPair(count + 2, n, used, asf + "(" + fup + "," + pp + ") ");
                used[pp] = false;
            }
        }
        used[fup] = false;
    }
    
    public static void main(String[] args){
        int n = 3;
        friendsPair(0, n, new boolean[n + 1], "");
    }
}
