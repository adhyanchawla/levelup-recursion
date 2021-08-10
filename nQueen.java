public class nQueen {
    public static void main(String[] args){
        
        // int n = 4;
        // int[][] board = new int[n][n];
        boolean[][] boxes = new boolean[4][4];
        //System.out.println(nQueen2D_comb(boxes, 0, 4, 0, ""));
        //System.out.println(nQueen2D_perm(boxes, 4, 0, ""));
        //System.out.println(queenCombination1D(new int[5], 0, 3, 0, "", new boolean[7]));
        //System.out.println(queenCombination1D_01(new int[7], 0, 4, 0, ""));
        //System.out.println(queenPerm1D_subs(new int[7], 0, 4, 0, "", new boolean[7]));
        //System.out.println(queenPerm1D(new int[7], 4, 0, "", new boolean[7]));
        //System.out.println(nQueen2D_comb01(boxes, 0, 4, 0, ""));
        System.out.println(nQueen2D_perm01(boxes, 0, 4, 0, ""));
    } 

    // tbn : total no boxes
    //method 1 subsequence
    public static int queenCombination1D(int[] boxes, int bno, int tq, int qpsf, String asf, boolean[] visited){
        if(bno == boxes.length){
            if(tq == qpsf){
                System.out.println(asf);
                return 1;
            }

            return 0;
        }

        int count = 0;

        count += queenCombination1D(boxes, bno + 1, tq, qpsf, asf, visited);

        
            //visited[bno] = true;
            count += queenCombination1D(boxes, bno + 1, tq, qpsf + 1, asf + "b" + bno + "q" + qpsf + " ", visited);
            //visited[bno] = false;
        
        
        return count;
    }

    //method 2 nCr
    public static int queenCombination1D_01(int[] boxes, int bno, int tq, int cq, String asf){
        if(tq == cq){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for(int i = bno; i < boxes.length; i++){
            count += queenCombination1D_01(boxes, i + 1, tq, cq + 1, asf + "b" + bno + "q" + cq + " ");
        }

        return count;
    }

    //method 1 permutation
    public static int queenPerm1D_subs(int[] boxes, int bno, int tq, int qpsf, String asf, boolean[] visited){
        if(bno == boxes.length || qpsf == tq){
            if(qpsf == tq){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if(!visited[bno]){
            visited[bno] = true;
            count += queenPerm1D_subs(boxes, 0, tq, qpsf + 1, asf + "b" + bno + "q" + qpsf + " ", visited);
            visited[bno] = false;
        }
        count += queenPerm1D_subs(boxes, bno + 1, tq, qpsf, asf, visited);
        return count;
    }

    //method 2 permutation
    public static int queenPerm1D(int[] boxes, int tq, int qpsf, String asf, boolean[] visited){
            if(tq == qpsf){
                System.out.println(asf);
                return 1;    
        }
        
        int count = 0;
        
        for(int i = 0; i < boxes.length; i++){
            if(!visited[i]){
                visited[i] = true;
                count += queenPerm1D(boxes, tq, qpsf + 1, asf + "b" + i + "q" + qpsf + " ", visited);
                visited[i] = false;
            }
        }
        
        return count;
    }

    //2d 
    public static int nQueen2D_comb(boolean[][] boxes, int bno, int tq, int qpsf, String asf){
        if(tq == qpsf){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        int n = boxes.length, m = boxes[0].length;
        for(int i = bno; i < n * m; i++){
            int r = i % m;
            int c = i / m;
            count += nQueen2D_comb(boxes, i + 1, tq, qpsf + 1, asf + "(" + r + ", " + c + ")");
        }
        return count;
    }

    public static int nQueen2D_perm(boolean[][] boxes, int tq, int qpsf, String asf){
        if(tq == qpsf){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = boxes.length, m = boxes[0].length;
        for(int i = 0; i < n * m; i++){
            int r = i % m;
            int c = i / m;
            if(!boxes[r][c]){
                boxes[r][c] = true;
                count += nQueen2D_perm(boxes, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }

        }
        return count;
    }

    //subsequnce
    public static int nQueen2D_comb01(boolean[][] boxes, int bno, int tq, int qpsf, String asf){
        int n = boxes.length, m = boxes[0].length;
        int r = bno % m;
        int c = bno / m;
        if(r == n || c == m || tq == qpsf){
            if(qpsf == tq){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += nQueen2D_comb01(boxes, bno + 1, tq, qpsf, asf);
        count += nQueen2D_comb01(boxes, bno + 1, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
        
        return count;
    }

    //subsequence
    public static int nQueen2D_perm01(boolean[][] boxes, int bno, int tq, int qpsf, String asf){
        int n = boxes.length;
        int m = boxes[0].length;
        int r = bno % m, c = bno / m;

        if(r == n || c == m || tq == qpsf){
            if(qpsf == tq){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        count += nQueen2D_perm01(boxes, bno + 1, tq, qpsf, asf);

        if(!boxes[r][c]){
            boxes[r][c] = true;
            count += nQueen2D_perm01(boxes, 0, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
            boxes[r][c] = false;
        }

        return count;
    }

    // //isSafe Optimised
    // static boolean[] row, col, diag, adiag;
    // public static int nQueen03(int n, int m, int bno, int tq, int qpsf, String asf){
    //     if(tq == qpsf){
    //         System.out.println(asf);
    //         return 1;
    //     }
    //     int count = 0;
    //     for(int i =  bno; i < n * m; i++){
    //         int r = i / m;
    //         int c = i % m;

    //         if(!row[r] && !col[c] && !diag[r + c] !adiag[r - c + m - 1]){
    //             row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
    //             count += nQueen03(n, m, i + 1, tq, qpsf + 1, asf);
    //         }
    //     }
    //     return count;
    // }
    
}
