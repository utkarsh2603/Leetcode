class Solution {
    static int count=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int uniquePathsIII(int[][] grid) {
        int zero = 0; 
        int sx = 0; 
        int sy = 0; 
        int m=grid.length;
        int n=grid[0].length;
        boolean v[][]=new boolean[m][n];
        for(int r = 0; r < grid.length; r++){ 
            for(int c = 0; c < grid[0].length; c++){ 
                if(grid[r][c] == 0) zero++;
                else if(grid[r][c] == 1){
                    sx = r; 
                    sy = c;
                }
                else if(grid[r][c]==-1){
                    v[r][c]=true;
                }
            }
        }
        count=0;
        backtrack(grid, sx, sy, zero,v);
        return count;
    }
    public void backtrack(int grid[][], int x, int y, int zero,boolean v[][]){
       
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length 
         ||v[x][y]) return ;

        if(grid[x][y] == 2 && zero==-1)
        {
           count++;
           return;
        }

        v[x][y]=true;
        zero--; 
        // up right down left
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            backtrack(grid,nx,ny,zero,v);
        }
       
        v[x][y]=false;
        zero++;
    }
}