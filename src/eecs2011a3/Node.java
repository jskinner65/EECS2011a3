package eecs2011a3;

class Node<k> {
	int key, height;
	Node<k> left, right;

	public Node(int d) {
		key = d;
		height = 1;
	}
}
