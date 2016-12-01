import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private int head, tail = 0;
	private Item[] s;

	public Deque() {
		s = (Item[]) new Object[1];
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public int size() {
		return tail - head;
	}

	public void addFirst(Item item) {
		// s[]
	}

	public void addLast(Item item) {
		// add the item to the end
	}

	public Item removeFirst() {
		Item temp = s[head];
		s[head++] = null;
		return temp;
	}

	public Item removeLast() {
		Item temp = s[--tail];
		s[tail] = null;
		return temp;
	}

	public Iterator<Item> iterator() {
		return null;
		// return an iterator over items in order from front to end
	}

	public static void main(String[] args) {
		// unit testing
	}
}