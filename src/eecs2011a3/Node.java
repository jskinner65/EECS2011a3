package eecs2011a3;

class Node<k> {
	String key;
	int height;
	Node<k> left, right;

	public Node(String d) {
		key = d;
		height = 1;
	}
}
