import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	public Item[] s;
	private int head, tail, n;

	public RandomizedQueue() {
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

	public void enqueue(Item item) {
		if (item == null)
			throw new NullPointerException();
		s[tail++] = item;
		if (tail == s.length)
			tail = 0;
		n++;
		if (n == s.length)
			resizeArray(2 * s.length);
	}

	public Item dequeue() {
		CheckForEmpty();
		int rndm = StdRandom.uniform(n);
		Item item = s[(rndm + head) % s.length];
		s[(rndm + head) % s.length] = null;
		int idx = (rndm + head) % s.length;
		while (idx != tail) {
			if (idx == s.length - 1) {
				s[idx] = s[0];
				idx = 0;
			} else {
				s[idx] = s[++idx];
			}
		}
		if (tail == 0) {
			tail = s.length - 1;
		} else {
			tail--;
		}
		n--;
		if (n == s.length / 4)
			resizeArray(s.length / 2);
		return item;
	}

	public Item sample() {
		CheckForEmpty();
		int rndm = StdRandom.uniform(n);
		Item item = s[(rndm + head) % s.length];
		return item;
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

	private void CheckForEmpty() {
		if (n == 0)
			throw new NoSuchElementException();
	}

	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
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
				return item;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		// return an independent iterator over items in random order
	}

	public static void main(String[] args) {
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		rq.enqueue("1");
		rq.enqueue("2");
		rq.enqueue("3");
		rq.enqueue("4");
		rq.enqueue("5");
		rq.enqueue("6");
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		rq.enqueue("7");
		rq.enqueue("8");
		System.out.println("sample " + rq.sample());
		System.out.println("sample " + rq.sample());
		rq.enqueue("9");
		rq.enqueue("10");
		rq.enqueue("11");
		System.out.println(rq.dequeue());
		System.out.println(rq.dequeue());
		System.out.println(Arrays.toString(rq.s));
	}
}