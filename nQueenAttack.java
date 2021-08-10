public class nQueenAttack {

    //subsequnce
    public static int nQueen2D_comb01(boolean[][] boxes, int bno, int tq, int qpsf, String asf){
        int n = boxes.length, m = boxes[0].length;
        int r = bno / m;
        int c = bno % m;
        if(r == n || c == m || tq == qpsf){
            if(qpsf == tq){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(isSafeToPlaceQueen(boxes, r, c))
            count += nQueen2D_comb01(boxes, bno + 1, tq, qpsf, asf);

        if(isSafeToPlaceQueen(boxes, r, c)){
            count += nQueen2D_comb01(boxes, bno + 1, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
        }
        
        
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

        if(!boxes[r][c] && isSafeToPlaceQueen(boxes, r, c)){
            boxes[r][c] = true;
            count += nQueen2D_perm01(boxes, 0, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
            boxes[r][c] = false;
        }

        return count;
    }

    public static int nQueen(boolean[][] boxes, int bno, int tq, int qpsf, String asf){
        if(tq == qpsf){
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        int n = boxes.length;

        for(int i = bno; i < n * n; i++){
            int r = i / n;
            int c = i % n;
            if(isSafeToPlaceQueen(boxes, r, c)){
                boxes[r][c] = true;
                count += nQueen(boxes, i + 1, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }
    //combinations
    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int sr, int sc){
        int[][] dir = {{-1, 0}, {-1, -1}, {-1, 1}, {0, -1}};

        for(int d = 0; d < dir.length; d++){
            for(int jump = 1; jump <= boxes.length; jump++){
                int r = sr + jump * dir[d][0];
                int c =  sc + jump * dir[d][1];

                if(r >= 0 && c >= 0 && r < boxes.length && c < boxes.length){
                    if(boxes[r][c]){
                        return false;
                    }
                } 
                else{
                    break;
                }
            }
        }

        return true;
    }

    public static boolean isSafeToPlaceQueenPerm(boolean[][] boxes, int sr, int sc){
        int[][] dir = {{-1, 0}, {-1, -1}, {-1, 1}, {0, -1}, {1, 1}, {1, -1}, {1, 0}, {0, 1}};

        for(int d = 0; d < dir.length; d++){
            for(int jump = 1; jump <= boxes.length; jump++){
                int r = sr + jump * dir[d][0];
                int c =  sc + jump * dir[d][1];

                if(r >= 0 && c >= 0 && r < boxes.length && c < boxes.length){
                    if(boxes[r][c]){
                        return false;
                    }
                } 
                else{
                    break;
                }
            }
        }

        return true;
    }

    public static int nQueenPerm(boolean[][] boxes, int tq, int qpsf, String asf){
        if(tq == qpsf){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = boxes.length;

        for(int i = 0; i < n * n; i++){
            int r = i / n;
            int c = i % n;

            if(!boxes[r][c] && isSafeToPlaceQueenPerm(boxes, r, c)){
                boxes[r][c] = true;
                count += nQueenPerm(boxes, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }

        return count;
    }

    //isSafe Optimised branch and bound strategy
    static boolean[] row, col, diag, adiag;
    public static int nQueen03(int n, int m, int bno, int tq, int qpsf, String asf){
        if(tq == qpsf){
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i =  bno; i < n * m; i++){
            int r = i / m;
            int c = i % m;

            if(!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen03(n, m, i + 1, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return count;
    }
    // one solution
    public static boolean nQueen0301(int n, int m, int bno, int tq, int qpsf, String asf){
        if(tq == qpsf){
            System.out.println(asf);
            return true;
        }
        boolean ans = false;
        for(int i =  bno; i < n * m; i++){
            int r = i / m;
            int c = i % m;

            if(!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                ans = nQueen0301(n, m, i + 1, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
                if(ans) return true;
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return ans;
    }

    //nQueen Permutations branch and bound strategy
    public static int nQueen03Perm(int n, int m, int tq, int qpsf, String asf){
        if(tq == qpsf){
            System.out.println(asf);
            return 1;
        }
        int count = 0;

        for(int i = 0; i < n * m; i++){
            int r = i / m;
            int c = i % m;
            if(!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen03Perm(n, m, tq, qpsf + 1, asf + "(" + r + ", " + c + ") ");
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    //best optimised version
    public static int nQueen_comb(int n, int m, int floor, int tq, String asf){
        if(tq == 0){
            System.out.println(asf);
            return 1;
        }
        int count = 0;

        for(int i = 0; i < n; i++){
            int r = floor;
            int c = i;
            if(!col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen_comb(n, m, floor + 1, tq - 1, asf + "(" + r + ", " + c + ") ");
                col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    public static int nQueen_perm(int n, int m, int tq, int floor, String asf){
        if(tq == 0 || floor == n){
            if(tq == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            int r = floor;
            int c = i;
            if(!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen_perm(n, m, tq - 1, 0, asf + "(" + r + ", " + c + ") ");
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        count += nQueen_perm(n, m, tq, floor + 1, asf);
        return count;
    }
    public static void main(String[] args){
        int n = 4;
        int m = 4;
        row = new boolean[n];
        col = new boolean[m];
        diag = new boolean[n + m -1];
        adiag = new boolean[n + m - 1];
        //System.out.println(nQueen0301(n, m, 0, 4, 0, ""));
        //System.out.println(nQueen(new boolean[4][4], 0, 4, 0, ""));
        //System.out.println(nQueenPerm(new boolean[4][4], 4, 0, ""));
        //System.out.println(nQueen03Perm(n, m, 4, 0, ""));
        //System.out.println(nQueen2D_comb01(new boolean[4][4], 0, 4, 0, ""));
        //System.out.println(nQueen_comb(n, m, 0, 4, ""));
        System.out.println(nQueen_perm(n, m, 4, 0, ""));
    }
    
}
