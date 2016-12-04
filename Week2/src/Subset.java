public class Subset {
	public static void main(String[] args) {
		String s = StdIn.readLine();
		String[] in = s.split(" ");
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		for (String str : in) {
			rq.enqueue(str);
		}
		for (int i = 1; i <= k; i++) {
			System.out.println(rq.dequeue());
		}
	}
}