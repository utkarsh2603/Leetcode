class Solution {
    public int minPathSum(int[][] grid) {
    int n = grid.length;
        int m = grid[0].length;
        int[][] qb = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                qb[i][j] = -1;
            }
        }
        int ans = mps(grid,0,0,n,m,qb);
        System.out.println(ans);
        return ans;
    }

    public int mps(int[][] grid, int r, int c,int n,int m,int[][] qb){
        int min = Integer.MAX_VALUE;
        int vs = Integer.MAX_VALUE, hs = Integer.MAX_VALUE;
        if(r==n-1 && c==m-1){
            return grid[r][c];
        }

        if(qb[r][c] != -1){
            return qb[r][c];
        }

        if(r<n-1 && c<m-1){
            vs = grid[r][c]+mps(grid,r+1,c,n,m,qb);
            hs = grid[r][c]+mps(grid,r,c+1,n,m,qb);
        }if(r>=n-1 && c<m-1){
            hs = grid[r][c]+mps(grid,r,c+1,n,m,qb);
        }if(r<n-1 && c>=m-1){
            vs = grid[r][c]+mps(grid,r+1,c,n,m,qb);
        }

        if(hs<min){min = hs;}
        if(vs<min){min = vs;}

        qb[r][c] = min;
        return qb[r][c];
        
    }
}