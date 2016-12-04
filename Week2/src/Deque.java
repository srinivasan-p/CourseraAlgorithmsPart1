import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private int head, tail, n;
	private Item[] s;

	public Deque() {
		s = (Item[]) new Object[1];
		head = 0;
		tail = 0;
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void addFirst(Item item) {
		validateInput(item);
		if (head == 0)
			head = s.length - 1;
		else
			head--;
		s[head] = item;
		n++;
		if (n == s.length)
			resizeArray(2 * s.length);
	}

	private void validateInput(Item item) {
		if (item == null)
			throw new NullPointerException();
	}

	public void addLast(Item item) {
		validateInput(item);
		if (tail == s.length - 1) {
			s[tail] = item;
			tail = 0;
		} else {
			s[tail++] = item;
		}
		n++;
		if (n == s.length)
			resizeArray(2 * s.length);
	}

	public Item removeFirst() {
		checkForEmpty();
		Item temp;
		if (head == s.length - 1) {
			temp = s[head];
			s[head] = null;
			head = 0;
		} else {
			temp = s[head];
			s[head--] = null;
		}
		n--;
		if (n == s.length / 4)
			resizeArray(s.length / 2);
		return temp;
	}

	public Item removeLast() {
		checkForEmpty();
		Item temp;
		if (tail == 0) {
			temp = s[s.length - 1];
			tail = s.length - 1;
			s[tail] = null;
		} else {
			temp = s[--tail];
			s[tail] = null;
		}
		n--;
		if (n == s.length / 4)
			resizeArray(s.length / 2);
		return temp;
	}

	private void checkForEmpty() {
		if (n == 0)
			throw new NoSuchElementException();
	}

	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = s[(i + head) % s.length];
			i++;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private void resizeArray(int cap) {
		Item[] copy = (Item[]) new Object[cap];
		for (int i = 0; i < n; i++) {
			copy[i] = s[(head + i) % s.length];
		}
		s = copy;
		head = 0;
		tail = n;
	}

	public static void main(String[] args) {
		Deque<String> dq = new Deque<String>();
		dq.addFirst("addfirst");
		dq.addFirst("addfirst2");
		dq.addFirst("addfirst3");
		dq.addLast("addlast1");
		dq.addFirst("addfirst4");
		dq.addLast("addlast2");

		// dq.removeFirst();
		// dq.removeLast();
		for (String string : dq) {
			System.out.println(string);
		}
		// System.out.println(Arrays.toString(dq.s));
	}
}
