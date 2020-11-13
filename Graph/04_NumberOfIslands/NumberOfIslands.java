import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private static final int DFS = 0;
    private static final int BFS = 1;

    private int numIslands(char[][] grid, int searchType) {
        int num = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    search(i, j, grid, seen, searchType);
                    num++;
                }
            }
        }
        return num;
    }

    // choose the search method
    private void search(int i, int j, char[][] grid, boolean[][] seen, int searchType){
        if(searchType == DFS){
            dfs(i, j, grid, seen);
        }
        else if(searchType == BFS){
            bfs(i, j, grid, seen);
        }
        else{
            throw new IllegalArgumentException("searchType should be either 0 or 1");
        }
    }

    // use depth first search
    private void dfs(int row, int col, char[][] grid, boolean[][] seen){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0' || seen[row][col]){
            return;
        }
        seen[row][col] = true;
        dfs(row+1, col, grid, seen);
        dfs(row-1, col, grid, seen);
        dfs(row, col+1, grid, seen);
        dfs(row, col-1, grid, seen);
    }

    // use breadth first search
    private void bfs(int row, int col, char[][] grid, boolean[][] seen){
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : directions){
                int nRow = curr[0] + dir[0];
                int nCol = curr[1] + dir[1];
                if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] != '0' && !seen[nRow][nCol]){
                    seen[nRow][nCol] = true;
                    q.add(new int[]{nRow, nCol});
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        // use dfs
        assert(solution.numIslands(
                    new char[][] {{'1','1','0','0','0'},
                                  {'1','1','0','0','0'},
                                  {'0','0','1','0','0'},
                                  {'0','0','0','1','1'}}, DFS)
        == 3);

        // use bfs
        assert(solution.numIslands(
                    new char[][] {{'1','1','0','0','0'},
                                  {'1','1','0','0','0'},
                                  {'0','0','1','0','0'},
                                  {'0','0','0','1','1'}}, BFS)
        == 3);

        // use dfs
        assert(solution.numIslands(
                    new char[][] {{'1','1','1','1','0'},
                                  {'1','1','0','1','0'},
                                  {'1','1','0','0','0'},
                                  {'0','0','0','0','0'}}, DFS)
        == 1);

        // use bfs
        assert(solution.numIslands(
                    new char[][] {{'1','1','1','1','0'},
                                  {'1','1','0','1','0'},
                                  {'1','1','0','0','0'},
                                  {'0','0','0','0','0'}}, BFS)
        == 1);
    }
}
