import java.util.Scanner;

public class MyLinkedList {

	Node first = null;

	private class Node {
		String item;
		Node next;
	}

	void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}

	String pop() {
		String popedStr = first.item;
		first = first.next;
		return popedStr;
	}

	boolean isEmpty() {
		return first == null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().split(" ");
		MyLinkedList ll = new MyLinkedList();
		for (int i = 0; i < in.length; i++) {
			if (in[i].equals("-"))
				System.out.print(ll.pop() + " ");
			else
				ll.push(in[i]);
		}
	}
}
