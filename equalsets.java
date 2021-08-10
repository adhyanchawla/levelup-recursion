import java.util.*;

public class equalsets {

    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        countEqualSets(0, arr, 0, "", 0, "");
    }

    public static int countEqualSets(int idx, int[] arr, int sum1, String asf1, int sum2, String asf2){
        if(idx == arr.length){
            if(sum1 == sum2){
                System.out.println(asf1 + " = " + asf2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += countEqualSets(idx + 1, arr, sum1 + arr[idx], asf1 + arr[idx] + " ", sum2, asf2);
        count += countEqualSets(idx + 1, arr, sum1, asf1, sum2 + arr[idx], asf2 + arr[idx] + " ");
        return count;
    }

    public static void equalSubsets02(int[] arr, int idx){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++)
            ans.add(new ArrayList<>());

        int sum = 0;
        for (int ele : arr)
            sum += ele;

        if ((sum & 1) != 0)
            return;

        equalSet(arr, 0, sum / 2, ans, 0, new int[2]);
        System.out.println(ans);
    }

    public static void equalSet(int[] arr, int idx, int sum, ArrayList<ArrayList<Integer>> ans, int conessf, int[] subsetSum){
        if(idx == arr.length) {
            if(conessf == 2){
                for(int i = 0; i < subsetSum.length - 1; i++) {
                    if(subsetSum[i] != subsetSum[i + 1]){
                        return;
                    }
                }

                for(int i = 0; i < ans.size(); i++) {
                    System.out.println(ans.get(i) + " ");
                }
                System.out.println();
            }

            return;
        }

        int ce = arr[idx];
        for(int i = 0; i < 2; i++){
            //to combine with non empty 
            if(ans.get(i).size() > 0) {
                ans.get(i).add(ce);
                sum += ce;
                equalSet(arr, idx + 1, sum, ans, conessf, subsetSum);
                ans.get(i).remove(ans.get(i).size() - 1);
                sum -= ce;
            }
            //to add in first empty subset 
            else {
                ans.get(i).add(ce);
                subsetSum[i] += ce;
                equalSet(arr, idx + 1, sum, ans, conessf + 1, subsetSum);
                subsetSum[i] -= ce;
                ans.get(i).remove(ans.get(i).size() - 1);
                break;
            }
        }
    }
}