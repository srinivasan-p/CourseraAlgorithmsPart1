import java.util.Arrays;

public class MyShuffle {

	public void shuffle(Comparable[] inp) {
		for (int i = 0; i < inp.length; i++) {
			int rand = StdRandom.uniform(i + 1);
			exch(inp, i, rand);
		}
	}

	private void exch(Comparable[] inp, int i, int min) {
		Comparable temp = inp[i];
		inp[i] = inp[min];
		inp[min] = temp;
	}

	public static void main(String[] args) {
		Integer[] inp = { 1,2 };
		MyShuffle is = new MyShuffle();
		is.shuffle(inp);
		System.out.println(Arrays.toString(inp));
	}

}
