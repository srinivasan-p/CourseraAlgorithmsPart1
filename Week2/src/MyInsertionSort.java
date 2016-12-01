import java.util.Arrays;

public class MyInsertionSort {

	public void sort(Comparable[] inp) {
		for (int i = 0; i < inp.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(inp[j], inp[j - 1])) {
					exch(inp, j, j-1);
				} else {
					break;
				}
			}
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
		MyInsertionSort is = new MyInsertionSort();
		is.sort(inp);
		System.out.println(Arrays.toString(inp));
	}

}
