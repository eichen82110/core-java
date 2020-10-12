package org.hooah.problems;

//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
public class NumberOfIslands {
	
	//return
	// 0 if null grid, grid only contains '0's (water)
	// at 1east 1 if there is at least 1 '1' on the grid
	int numIslands(final char[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		int numIslands = 0;
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				if(grid[row][col] == '1') {
					//attempt to "sink" the current index of the grid
					numIslands += sink(grid, row, col);
				}
			}
		}
		return numIslands;
	}
	
	
	private int sink(char[][] grid, int row, int col) {
		//check the bounds of row and col and if the current index is an island or not (1 or 0)
		
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col]=='0'){
			return 0;
		}
		//set current index to zero so we don't reuse it
		grid[row][col]='0';
		
		//sinks all neighbors
		sink(grid, row+1, col);
		sink(grid, row-1, col);
		sink(grid, row, col+1);
		sink(grid, row, col-1);
		//increment number of islands
		return 1;
	}
	
	public static void main(String[] args) {
		NumberOfIslands numberOfIslands = new NumberOfIslands();
		
		//should have only 1 island.  The entire grid is it's own island
		char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
		
		//land at (row,col):
		// (0,0) (0,1) (0,2) (0,3)
		// (1,0) (1,1)       (1,3)
		// (2,0) (2,1)
		//
		
		
		//water at (row,col):
		//                         (0,4)
		//             (1,2)       (1,4)
		//             (2,2) (2,3) (2,4)
		// (3,0) (3,1) (3,2) (3,3) (3,4)
		System.out.println("Grid 1 has " + numberOfIslands.numIslands(grid1) + " islands.");
		
		
		//should have only 3 islands
		char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
		System.out.println("Grid 2 has " + numberOfIslands.numIslands(grid2) + " islands.");
		
		
	}
	
}
