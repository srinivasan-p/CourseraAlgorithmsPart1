import java.util.Arrays;

public class MyShellSort {

	public void sort(Comparable[] inp) {
		int N = inp.length;
		int h = 1;
		while (h < N / 3) {
			h = (3 * h) + 1;
		}

		while (h > 0) {
			for (int i = h; i < N; i++) {
				for (int j = i; j > 0; j -= h) {
					if ((j - h) > -1 && less(inp[j], inp[j - h])) {
						exch(inp, j, j - h);
					} else {
						break;
					}
				}
			}
			h = h / 3;
		}

	}

	private void exch(Comparable[] inp, int i, int min) {
		Comparable temp = inp[i];
		inp[i] = inp[min];
		inp[min] = temp;
	}

	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void main(String[] args) {
		Integer[] inp = { 5, 7, 3, 8, 4, 9, 2, 1, 0, 10, 45, 67, 11 };
		MyShellSort ss = new MyShellSort();
		ss.sort(inp);
		System.out.println(Arrays.toString(inp));
	}

}
