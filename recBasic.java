import java.util.*;

public class recBasic{

    public static void printIncreasing(int a, int b){
        if(a == b){
            System.out.println(a);
            return;
        }

        System.out.println(a);
        printIncreasing(a + 1, b);
    }

    public static void printDecreasing(int a, int b){
        if(a == b){
            System.out.println(a);
            return;
        }

        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int a, int b){
        if(a > b){
            return;
        }

        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void oddEven(int a, int b){
        if(a > b){
            return;
        }

        //uupr jaate hue odd
        if(a % 2 != 0){
            System.out.println(a);
        }

        oddEven(a + 1, b);

        if(a % 2 == 0){
            System.out.println(a);
        }
    }

    public static int factorial(int n){
        if(n == 0 || n == 1)
        return n;

        return factorial(n-1)*n;
    }

    public static int power(int a, int b){
        if(b == 0){
            return 1;
        }

        int pnm1 = power(a, b-1);
        return pnm1 * a;
    }

    public static int powerRec2(int a, int b){
        if(b == 0)
        return 1;

        if(b % 2 != 0){
            return powerRec2(a, b/2) * powerRec2(a, b/2) * a;
        }
        else{
            return powerRec2(a, b/2) * powerRec2(a, b/2);
        }
    }

    public static void printArr(int[] arr, int idx){
        if(idx == arr.length)
            return;
        
        System.out.print(arr[idx] + " ");
        
        printArr(arr, idx + 1);
    }

    public static void printArrReverse(int[] arr, int idx){
        if(idx == arr.length)
        return;

        printArrReverse(arr, idx + 1);

        System.out.print(arr[idx] + " ");
    }

    public static int maximum(int[] arr, int idx){
        if(idx >= arr.length){
            return -(int)1e9;
        }

        int max = arr[idx];
        int recAns = maximum(arr, idx + 1);
        if(recAns > max){
            max = recAns;
        }

        return max;
    }

    public static int minimum(int[] arr, int idx){
        if(idx == arr.length){
            return (int)1e9;
        }

        int min = arr[idx];
        int recAns = minimum(arr, idx + 1);
        if(recAns < min){
            min = recAns;
        }

        return min;
    }

    public static boolean find(int[]arr, int idx, int data){
        if(idx == arr.length)
        return false;

        boolean fdata = find(arr, idx + 1, data);
        if(fdata)
            return true;
        else return data == arr[idx];
    }

    public static int firstIndex(int[] arr, int idx, int data){
        if(idx == arr.length)
            return -1;
            
        if(arr[idx] == data){
            return idx;
        }    
        else return firstIndex(arr, idx + 1, data);
    }

    public static int lastIndex(int[] arr, int idx, int data){
        if(idx == arr.length)
            return -1;

        int li = lastIndex(arr, idx + 1, data);
        if(li != -1){
            return li;
        } else{
            if(arr[idx] == data){
                return idx;
            } else return -1;
        }    

    }

    public static int[] allIndeces(int[] arr, int idx, int data, int count){
        if(idx == arr.length){
            return new int[count];
        }

        if(arr[idx] == data){
            count++;
        }

        int[] ans = allIndeces(arr, idx + 1, data, count);
        if(arr[idx] == data){
            count--;
            ans[count] = idx;
        }
        return ans;
    }

    public static ArrayList<String> subsequence(String str, int idx){
        if(idx == str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("" + str.substring(idx));
            return base;
        }

        //char ch = str.charAt(idx);
        ArrayList<String> recAns = subsequence(str, idx + 1);
        ArrayList<String> myAns = new ArrayList<>();

        for(String ss : recAns){
            myAns.add(ss);
            myAns.add(str.charAt(idx) + ss);
        }

        return myAns;
    }

    public static int subsequence(String str, int idx, String ans, ArrayList<String> res){
        if(str.length() == idx){
            res.add(ans);
            return 1;
        }

        int count = 0;

        count += subsequence(str, idx + 1, ans + str.charAt(idx), res);
        count += subsequence(str, idx + 1, ans, res);

        return count;
    }

    public static String[] nokiaKeys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};


    public static int nokiaKeyPad(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        char no = str.charAt(0);
        int num = no - '0';

        for(int i = 0; i < nokiaKeys[num].length(); i++){
            char ch = nokiaKeys[num].charAt(i);
            count += nokiaKeyPad(str.substring(1), ans +  ch);
        }
        return count;
    }

    public static ArrayList<String> nokiaKeys1(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char no = str.charAt(0);
        int num = no - '0';
        ArrayList<String> myAns = new ArrayList<>();
        for(int i = 0; i < nokiaKeys[num].length(); i++){

            char ch = nokiaKeys[num].charAt(i);
            ArrayList<String> recAns = nokiaKeys1(str.substring(1));

            for(String ss : recAns){
                myAns.add(ch + ss);
            }
        }

        return myAns;
    }

    public static int stairPath(int n, String psf, ArrayList<String> ans){
        if(n == 0){
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for(int jump = 1; jump <= 3 && n - jump >= 0; jump++){
            count += stairPath(n-jump, psf + jump, ans);
        }    

        return count;
    }

    public static ArrayList<String> stairPath01(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for(int i = 1; i <= 3  && n - i >= 0; i++){
            ArrayList<String> recAns = stairPath01(n-i);
            for(String s : recAns){
                myAns.add(i + s);
            }
        }

        return myAns;
    }

    public static int boardPath(int n, String psf, ArrayList<String> ans){
        if(n == 0){
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for(int jump = 1; jump <= 6 && n - jump >= 0; jump++){
            count += boardPath(n - jump, psf + jump, ans);
        }
        return count;
    }

    public static int boardPath01(int[] arr, int n, String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int jump = 0; jump < arr.length && n - arr[jump] >= 0; jump++){
            count += boardPath01(arr, n - arr[jump], ans + arr[jump]);
        }
        return count;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans){
        if(sr == er && sc == ec){
            ans.add(psf);
            return 1;
        }
        int count = 0;
        //horizontal
        if(sc + 1 <= ec){
            count += mazePath_HVD(sr, sc + 1, er, ec, psf + "H", ans);
        }

        //vertical
        if(sr + 1 <= er){
            count += mazePath_HVD(sr+1, sc, er, ec, psf + "V", ans);
        }

        //diagonal
        if(sr + 1 <= er && sc + 1 <= ec){
            count += mazePath_HVD(sr+1, sc+1, er, ec, psf + "D", ans);
        }
        return count;
    }

    public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans){
        if(sr == er && sc == ec){
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for(int jump = 1; jump <= er && jump + sr <= er; jump++){
            count += mazePath_HVD_multi(sr + jump, sc, er, ec, psf + "V" + jump, ans);
        }

        for(int jump = 1; jump <= ec && jump + sc <= ec; jump++){
            count += mazePath_HVD_multi(sr, sc + jump, er, ec, psf + "H" + jump, ans);
        }

        for(int jump = 1; jump <= er && jump + sr <= er && jump + sc <= ec; jump++){
            count += mazePath_HVD_multi(sr + 1, sc + 1, er, ec, psf + "D" + jump, ans);
        }

        return count;
    }

        // public static int specialMatrix()

    //     class Solution
    // {
    //     public static int val = (int)1e9 + 7;
    //     public static int floodFill(int sr, int sc, int[][] dir, int[][] maze)
    //     {
    //         if(sr == maze.length-1 && sc == maze[0].length-1)
    //         {
    //             return 1;
    //         }
            
    //         int count = 0;
    //         maze[sr][sc] = 1; //block
            
            
    //         for(int d = 0; d < dir.length; d++)
    //         {
    //             int r = sr + dir[d][0];
    //             int c = sc + dir[d][1];
                
    //             if(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] == 0)
    //             {
    //                 count = (count % val + floodFill(r, c, dir, maze) % val) % val;
    //                 //count += floodFill(r, c, dir, maze);
    //             }
    //         }
            
    //         maze[sr][sc] = 0;
    //         return count;
    //     }
    //     public int FindWays(int n, int m, int[][] blocked_cells)
    //     {
    //         int[][] arr = new int[n][m];
    //         if(n == 0 || m == 0)
    //         {
    //             return 0;
    //         }
            
    //         for(int[] cell: blocked_cells)
    //         {
    //             int i = cell[0] - 1;
    //             int j = cell[1] - 1;
                
    //             arr[i][j] = 1; //blocked means 1
    //         }
            
    //         if(arr[n-1][m-1] == 1 || arr[0][0] == 1)
    //         return 0;
            
    //         int [][]dir = {{0, 1}, {1, 0}};
            
    //         int ans = floodFill(0, 0, dir, arr);
            
    //         return ans;
    //         // Code here
    //     }
    // }

    //path with max gold

    // class Solution {
    //     //static int max = 0;
    //     public int travelAndCollectGold(int[][] grid, int sr, int sc, int[][] dir, int sum)
    //     {
    //         grid[sr][sc] += 1000; 
    //         int maxGold = 0;
            
    //         for(int d = 0; d < dir.length; d++)
    //         {
    //             int r = sr + dir[d][0];
    //             int c = sc + dir[d][1];
                
    //             if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != 0 && grid[r][c] <= 100 && grid[r][c] >= 1)
    //             {
    //                 maxGold = Math.max(maxGold, grid[r][c] + travelAndCollectGold(grid, r, c, dir, sum));
    //             }   
    //         }
            
    //         grid[sr][sc] -= 1000;
    //         return maxGold;
    //     }
    //     public int getMaximumGold(int[][] grid) {
            
    //         int n = grid.length;
    //         int m = grid[0].length;
            
    //         //boolean[][] visited = new boolean[n][m];
    //         int [][] dir = {{1, 0}, {0, 1},{-1, 0},{0, -1}};
    //         //int max = -(int)1e9;
    //         int max = 0;
    //         for(int i = 0; i < n; i++)
    //         {
    //             for(int j = 0; j < m; j++)
    //             {
    //                 if(grid[i][j] != 0)
    //                 max = Math.max(max, grid[i][j] + travelAndCollectGold(grid, i, j, dir, 0));  
    //             }
    //         }
            
    //         return max;
    //     }
    // }


    public static void main(String[] args){

        //printIncreasing(1, 6);
        //printDecreasing(1, 7);
        //printIncreasingDecreasing(1, 5);
        //oddEven(1, 6);

        //System.out.println(powerRec2(2, 5));
        int[] arr = {21, 42, 34, 11, 45, 11, 2, 32, 25, 34, 36, 34};
        //printArrReverse(arr, 0);
        //System.out.println(lastIndex(arr, 0, 35));
        // int[] ans = allIndeces(arr, 0, 34, 0);
        // for(int ele : ans){
        //     System.out.print(ele + " ");
        // }
        String str = "abc";    
        //ArrayList<String> ans = subsequence(str, 0);
        //System.out.println(ans);

         ArrayList<String> ans = new ArrayList<>();
        // System.out.println(subsequence(str, 0, "", ans));
        // System.out.println(ans);

        //System.out.println(nokiaKeyPad("123", ""));
        //System.out.println(ans);
        //ans = nokiaKeys1("456");

        int []arr1 = {1, 2, 11, 5, 6, 2};
        // System.out.println(boardPath(8, "", ans));    
        // System.out.println(ans);
        //System.out.println(boardPath01(arr1, 10, ""));

        System.out.println(mazePath_HVD_multi(0, 0, 2, 2, "", ans));
        System.out.println(ans);       
    }
}