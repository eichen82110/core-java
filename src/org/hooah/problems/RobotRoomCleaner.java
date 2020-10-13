package org.hooah.problems;

import java.util.HashSet;
import java.util.Set;

/** Given a robot cleaner in a room modeled as a grid.
 
 Each cell in the grid can be empty or blocked.
 
 The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 
 When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 
 Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 interface Robot {
 // returns true if next cell is open and robot moves into the cell.
 // returns false if next cell is obstacle and robot stays on the current cell.
 boolean move();
 
 // Robot will stay on the same cell after calling turnLeft/turnRight.
 // Each turn will be 90 degrees.
 void turnLeft();
 void turnRight();
 
 // Clean the current cell.
 void clean();
 }
 **/
public class RobotRoomCleaner {
	interface Robot {
		// returns true if next cell is open and robot moves into the cell.
		// returns false if next cell is obstacle and robot stays on the current cell.
		boolean move();
		
		// Robot will stay on the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		void turnLeft();
		void turnRight();
		
		// Clean the current cell.
		void clean();
	}
	
	Set<String> set = new HashSet<>();
	int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	
	
	public void cleanRoom(Robot robot) {
		set.add(0 + " " + 0);
		dfs(robot, 0, 0, 0);
	}
	
	private void dfs(Robot robot, int i, int j, int dir) {
		robot.clean();
		for (int z = 0; z < 4; z++) {
			int k = (z + dir) % 4;
			if (set.add((i + dirs[k][0]) + " " + (j + dirs[k][1])) && robot.move()) {
				dfs(robot, i + dirs[k][0], j + dirs[k][1], k);
				robot.turnRight();
				robot.turnRight();
				robot.move();
				robot.turnRight();
				robot.turnRight();
			}
			robot.turnRight();
		}
	}

}
