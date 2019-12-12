public class Solution
{
    public int NumIslands(char[][] grid)
    {
        int count = 0;
        if (grid != null)
        {
            for (int i = 0; i < grid.Length; i++)
            {
                for (int j = 0; j < grid[i].Length; j++)
                {
                    if (grid[i][j] == '1')
                    {
                        DFS(grid, i, j);
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    private void DFS(char[][] grid, int x, int y)
    {
        if (x < 0 || x > grid.Length-1 || y < 0 || y > grid[0].Length-1 || grid[x][y] != '1')
        {
            return;
        }
        grid[x][y] = '#';

        DFS(grid, x + 1, y);
        DFS(grid, x - 1, y);
        DFS(grid, x, y + 1);
        DFS(grid, x, y - 1);
    }
}