import java.util.*;

public class bits {

    public static void onToOff(int n, int k){
        int n1 = ~(1 << k);
        n = n & n1;
        System.out.println(n);
    }

    public static void offToOn(int n, int k){
        int n1 = (1 << k);
        n = n | n1;
        System.out.println(n);
    }

    public static int countSetBits(int n){
        int count = 0;

        for(int i = 0; i < 32; i++){
            int mask = (1 << i);
            if((mask & n) != 0){
                count++;
            }
        }

        return count;
    }

    public static int countSetBits_02(int n){
        int count = 0;
        return count;
    }

    public static int countSetBits_03(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) != 0){
                count++;
            }
            n >>>= 1;
        }

        return count;
    }
    public static void main(String[] args){
        int n = 28;
        int k = 1;
        //onToOff(n, k);
        //offToOn(n, k);
        //System.out.println(countSetBits(n));
        System.out.println(countSetBits(29));
    }
}
