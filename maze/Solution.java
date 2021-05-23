package maze;

import java.util.*;

public class Solution {

	public static final int ROAD = 0;
	public static final int WALL = 1;

	public enum DIRECTION {
		UP, DOWN, LEFT, RIGHT
	}

	public static class Coordinate {
		public int x;
		public int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}

	// A mehod that would return the Direction if indexToCheck is not a wall and is
	// an adjacent to adjacentRelativeTo and is not in falseyIndexes, null otherwise
	private static DIRECTION checkAndGetDirection(int maze[][], Coordinate coordinateToCheck,
			Coordinate adjacentRelativeTo, ArrayList<Coordinate> falseyValues) {
		if (maze[coordinateToCheck.getX()][coordinateToCheck.getY()] != 1) {
			for (Coordinate coordinate : falseyValues) {
				if (coordinate.getX() == coordinateToCheck.getX() && coordinate.getY() == coordinateToCheck.getY()) {
					return null;
				}
			}

			// get the direction if its non-wall non-falsely adjacent
			if (coordinateToCheck.getX() == adjacentRelativeTo.getX()
					&& coordinateToCheck.getY() == adjacentRelativeTo.getY() - 1)
				return DIRECTION.LEFT;
			if (coordinateToCheck.getX() == adjacentRelativeTo.getX()
					&& coordinateToCheck.getY() == adjacentRelativeTo.getY() + 1)
				return DIRECTION.RIGHT;
			if (coordinateToCheck.getX() == adjacentRelativeTo.getX() - 1
					&& coordinateToCheck.getY() == adjacentRelativeTo.getY())
				return DIRECTION.UP;
			if (coordinateToCheck.getX() == adjacentRelativeTo.getX() + 1
					&& coordinateToCheck.getY() == adjacentRelativeTo.getY())
				return DIRECTION.DOWN;

		}
		return null;
	}

	/**
	 * The method for you to implement.
	 */
	public List<DIRECTION> explore(int[][] maze, Coordinate start, Coordinate end) {
		List<DIRECTION> result = new ArrayList<>();
		ArrayList<Coordinate> previousMoves = new ArrayList<>(List.of(start));
		ArrayList<Coordinate> falseyValues = new ArrayList<>(List.of(start));
		Coordinate adjacentRelativeTo = start;
		Coordinate coordinateToCheck;
		// iterating through each element of the maze
		whileLoop: while (true) {
			for (int i = (adjacentRelativeTo.getX() > 0 ? adjacentRelativeTo.getX() - 1 : 0); i <= adjacentRelativeTo
					.getX() + 1 && i < maze.length; i++) { // ith column
				for (int j = adjacentRelativeTo.getY() > 0 ? adjacentRelativeTo.getY() - 1
						: 0; j <= adjacentRelativeTo.getY() + 1 && j < maze[0].length; j++) { // jth row
					// if previous moves is empty, then no way is possible to clear the maze, return
					// null
					if (previousMoves.isEmpty()) {
						return null;
					}
					// for each element from very beginning of maze, set
					// coordinateToCheck=maze[i][j], check if that element is vailidAdjescent of
					// adjacentRelativeTo
					coordinateToCheck = new Coordinate(i, j);
					// if it's an adjacent element then add it's direction to result and add it's
					// coordinate to previousMoves, clear falsey values, add itself to falseyValues,
					// set adjRelTo equals to it
					DIRECTION direction = checkAndGetDirection(maze, coordinateToCheck, adjacentRelativeTo,
							falseyValues);
					if (direction != null) {
						result.add(direction);
						previousMoves.add(coordinateToCheck);
						falseyValues.add(coordinateToCheck);
						adjacentRelativeTo = coordinateToCheck;
						continue whileLoop; // goto where its written whileloop:
					}
					// if previousMoves coordinate == end, return result
					if (previousMoves.get(previousMoves.size() - 1).getX() == end.getX()
							&& previousMoves.get(previousMoves.size() - 1).getY() == end.getY()) {
						return result;
					}
					// if it's not, check next
					// repeat
				}
			}
			// if no vailid adjascent is found then, add adjRelTo to falseyValues, delete
			// the last element of previousMoves,delete last element of result, set
			// adjRelTo=last element Of previousMoves.
			falseyValues.add(adjacentRelativeTo);
			previousMoves.remove(previousMoves.size() - 1);
			if (!result.isEmpty()) {
				result.remove(result.size() - 1);
			}
			if (!previousMoves.isEmpty()) {
				adjacentRelativeTo = previousMoves.get(previousMoves.size() - 1);				
			}
		}
	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 0 } };
		Solution solution = new Solution();
		System.out.println(solution.explore(maze, new Coordinate(3, 4), new Coordinate(0, 1))); // Should be [DOWN,
																								// RIGHT, RIGHT, DOWN,
																								// DOWN, RIGHT]
	}
}