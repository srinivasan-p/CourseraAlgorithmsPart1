import java.util.Scanner;

public class MyResizingArray<Item> {
	private Item[] s;
	private int N = 0;

	public MyResizingArray() {
		s = (Item[]) new Object[1];
	}

	public void push(Item item) {
		if (N == s.length)
			resizeArray(s.length * 2);
		s[N++] = item;
	}

	public Item pop() {
		if (N == s.length / 4)
			resizeArray(s.length / 2);
		Item item = s[--N];
		s[N] = null;
		return item;
	}

	private void resizeArray(int l) {
		Item[] copy = (Item[]) new Object[l];
		for (int i = 0; i < s.length; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().split(" ");
		MyResizingArray<Integer> ra = new MyResizingArray<Integer>();
		for (int i = 0; i < in.length; i++) {
			if (in[i].equals("-"))
				System.out.print(ra.pop() + " ");
			else
				ra.push(Integer.parseInt(in[i]));
		}

	}
}
