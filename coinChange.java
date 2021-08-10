import java.util.*;

public class coinChange {
    

    public static int infinitePermutations(int[] coins, int target, String asf){
        if(target == 0){
            System.out.println(asf);
            return 1;
        }


        int count = 0;
        for(int i = 0; i < coins.length; i++){
            if(target - coins[i] >= 0)
            count += infinitePermutations(coins, target - coins[i], asf + coins[i] + " ");
        }
        return count;
    }

    public static int infiniteCombinations(int[] coins, int tar, int idx, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < coins.length; i++){
            if(tar - coins[i] >= 0)
            count += infiniteCombinations(coins, tar - coins[i], i, asf + coins[i] + " ");
        }
        return count;
    }

    public static int singleCombination(int[] coins, int tar, int idx, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;

        for(int i = idx; i < coins.length; i++){
            if(tar - coins[i] >= 0)
            count += singleCombination(coins, tar - coins[i], i + 1, asf + coins[i] + " ");
        }

        return count;
    }

    public static int singlePermutation(int[] coins, int tar, String asf){
        if(tar == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] > 0 && tar - coins[i] >= 0){
                int ans = coins[i];
                coins[i] = -coins[i];
                count += singlePermutation(coins, tar - ans, asf + ans + " ");
                coins[i] = ans;
            }
        }
        return count;
    }

    //bits solution
    public static int SingleCombination01(int[] coins, int tar, String asf, int idx){
        if(tar == 0 || idx >= coins.length){
            if(tar == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(tar - coins[idx] >= 0){
            count += SingleCombination01(coins, tar - coins[idx], asf + coins[idx] + " ", idx + 1);
        }
            count += SingleCombination01(coins, tar, asf, idx + 1);

        return count;
    }

    public static int infCombination01(int[] coins, int tar, String asf, int idx){
        if(tar == 0 || idx >= coins.length){
            if(tar == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(tar - coins[idx] >= 0){
            count += infCombination01(coins, tar - coins[idx], asf + coins[idx] + " ", idx);
        }
            count += infCombination01(coins, tar, asf, idx + 1);

        return count;
    }

    public static int infPermutation01(int[] coins, int tar, String asf, int idx){
        if(tar == 0 || idx >= coins.length){
            if(tar == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(tar - coins[idx] >= 0){
            count += infPermutation01(coins, tar - coins[idx], asf + coins[idx] + " ", 0);
        }
            count += infPermutation01(coins, tar, asf, idx + 1);

        return count;
    }

    public static int singlePermutation01(int[] coins, int tar, String asf, int idx, boolean[] visited){
        if(tar == 0 || idx == coins.length){
            if(tar == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(tar - coins[idx] >= 0 && !visited[idx]){
            visited[idx] = true;
            count += singlePermutation01(coins, tar - coins[idx], asf + coins[idx] + " ", 0, visited);
            visited[idx] = false;
        }
            count += singlePermutation01(coins, tar, asf, idx + 1, visited);

        return count;
    }

    public static void main(String[] args){
        int[] coins = {2, 3, 5, 7};
        //System.out.println(infinitePermutations(coins, 10, ""));
        //System.out.println(infiniteCombinations(coins, 10, 0, ""));
        //System.out.println(singleCombination(coins, 10, 0, ""));
        //System.out.println(singlePermutation(coins, 10, ""));
        boolean[] visited = new boolean[coins.length];
        //System.out.println(singlePermutation01(coins, 10, "", 0, visited));
        //System.out.println(infPermutation01(coins, 10, "", 0));
        //System.out.println(SingleCombination01(coins, 10, "", 0));
        System.out.println(infCombination01(coins, 10, "", 0));
    }
}
