public class PercolationStats {
	private double[] ratios;
	private int T;

	public PercolationStats(int n, int trials) {
		if (n <= 0 || trials <= 0) {
			throw new java.lang.IllegalArgumentException();
		}
		ratios = new double[trials];
		T = trials;
		for (int i = 0; i < trials; i++) {
			Percolation per = new Percolation(n);
			int openedSites = 0;
			while (!per.percolates()) {
				int row = (int) (edu.princeton.cs.algs4.StdRandom.uniform() * n) + 1;
				int col = (int) (edu.princeton.cs.algs4.StdRandom.uniform() * n) + 1;
				if (!per.isOpen(row, col)) {
					per.open(row, col);
					openedSites++;
				}
			}
			ratios[i] = (double) openedSites / (n * n);
		}
	}

	public double mean() {
		return edu.princeton.cs.algs4.StdStats.mean(ratios);
	}

	public double stddev() {
		return edu.princeton.cs.algs4.StdStats.stddev(ratios);
	}

	public double confidenceLo() {
		return mean() - ((1.96 * stddev()) / Math.sqrt(T));
	}

	public double confidenceHi() {
		return mean() + ((1.96 * stddev()) / Math.sqrt(T));
	}

	public static void main(String[] args) {
		PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println("mean                    = " + ps.mean());
		System.out.println("stddev                  = " + ps.stddev());
		System.out.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());

	}
}