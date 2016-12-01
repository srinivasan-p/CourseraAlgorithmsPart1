import java.util.Arrays;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[][] grid;
	private int size;
	private WeightedQuickUnionUF QU;

	public Percolation(int n) {
		if (n <= 0) {
			throw new java.lang.IllegalArgumentException();
		}
		grid = new boolean[n][n];
		size = n;
		QU = new WeightedQuickUnionUF(n * n + 2);
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(grid[i], false);
		}
	}

	public void open(int row, int col) {
		validateRange(row, col);
		grid[row - 1][col - 1] = true;
		if (row == 1) {
			QU.union(getQUIdx(1, col), 0);
		}
		if (row == size) {
			QU.union(getQUIdx(size, row), size * size + 1);
		}
		if (row - 1 >= 1 && isOpen(row - 1, col)) {
			QU.union(getQUIdx(row - 1, col), getQUIdx(row, col));
		}
		if (col + 1 <= size && isOpen(row, col + 1)) {
			QU.union(getQUIdx(row, col + 1), getQUIdx(row, col));
		}
		if (row + 1 <= size && isOpen(row + 1, col)) {
			QU.union(getQUIdx(row + 1, col), getQUIdx(row, col));
		}
		if (col - 1 >= 1 && isOpen(row, col - 1)) {
			QU.union(getQUIdx(row, col - 1), getQUIdx(row, col));
		}

	}

	private int getQUIdx(int row, int col) {
		validateRange(row, col);
		return size * (row - 1) + col;
	}

	public boolean isOpen(int row, int col) {
		validateRange(row, col);
		return grid[row - 1][col - 1];
	}

	public boolean isFull(int row, int col) {
		validateRange(row, col);
		return QU.connected(0, getQUIdx(row, col));
	}

	public boolean percolates() {
		return QU.connected(0, size * size + 1);
	}

	private void validateRange(int row, int col) {
		if (row < 1 || row > size || col < 1 || col > size) {
			throw new java.lang.IndexOutOfBoundsException();
		}
	}

	public static void main(String[] args) {
		int size = 10;
		Percolation pc = new Percolation(size);
		while (!pc.percolates()) {
			int row = (int) (edu.princeton.cs.algs4.StdRandom.uniform() * size) + 1;
			int col = (int) (edu.princeton.cs.algs4.StdRandom.uniform() * size) + 1;
			System.out.println(row + " " + col);
			pc.open(row, col);
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (pc.grid[i][j]) {
					System.out.print("# ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}

	}
}