import java.util.Arrays;

public class MySelectionSort {

	public void sort(Comparable[] inp) {
		for (int i = 0; i < inp.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < inp.length; j++) {
				if (less(inp[j], inp[min])) {
					min = j;
				}
			}
			exch(inp, i, min);
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
		String[] inp = { "we", "dfg", "asd", "zxc", "hnj" };
		MySelectionSort ss = new MySelectionSort();
		ss.sort(inp);
		System.out.println(Arrays.toString(inp));
	}
}
