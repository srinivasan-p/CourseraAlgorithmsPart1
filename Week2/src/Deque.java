import java.util.Iterator;

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
		if (head == 0)
			head = s.length - 1;
		else
			head--;
		s[head] = item;
		n++;
		if (n == s.length)
			resizeArray(2 * s.length);
	}

	public void addLast(Item item) {
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

	public Iterator<Item> iterator() {
		return null;
		// return an iterator over items in order from front to end
	}

	private void resizeArray(int cap) {
		Item[] copy = (Item[]) new Object[cap];
		for (int i = 0; i < s.length; i++) {
			
		}
	}

	public static void main(String[] args) {
		// unit testing
	}
}
