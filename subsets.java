import java.util.*;

public class subsets{

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        System.out.println(subset02(nums, ans, res, 0, new boolean[nums.length]));
        //System.out.println(subset01(nums, ans, res, 0));
        System.out.println(res);
    }
    //preorder
    public static int subset01(int[] nums, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res, int idx){
        
        res.add(new ArrayList<>(ans));
        int count = 0;

        for(int i = idx; i < nums.length; i++){
            ans.add(nums[i]);
            count += subset01(nums, ans, res, i + 1);
            ans.remove(ans.size() - 1);
        }

        return count + 1;
    }

    public static int subset02(int[] nums, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res, int idx, boolean[] visited){
        if(idx >= nums.length) return 0;    
        res.add(new ArrayList<>(ans));
            
        int count = 0;

        if(idx < nums.length)
        count += subset02(nums, ans, res, idx + 1, visited);
        

        if(!visited[idx] && idx < nums.length){
            visited[idx] = true;
            ans.add(nums[idx]);
            count += subset02(nums, ans, res, idx + 1, visited);
            ans.remove(ans.size()-1);
            visited[idx] = false;
        }
        
        return count + 1;
    }
}