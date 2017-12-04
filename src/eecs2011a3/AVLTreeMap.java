package eecs2011a3;

import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

@SuppressWarnings("all")
public class AVLTreeMap<K, V> {
	Node root;

	public AVLTreeMap() {

	}

	/*
	 * add the node to the root at the bottom left of the tree and rebalances the tree
	 */

	public void insertNode(Node node, Node newNode, String key) {
		if (root == null) {
			root = new Node<String>(key);
		} else {
			if (key != null) {
				if (height(node) > 1) {
					insertNode(node.left, null, key);
				} else {
					node.left = new Node<String>(key);
				}
			} else {
				Node bot = getBottomNode(node);
				bot.left = newNode;
				root = rightRotate(node);
			}
		}
	}

	
	/* finds the bottom left node */
	public Node getBottomNode(Node node) {
		boolean done = false;
		Node tempNode = node;
		Node result = null;
		while (!done) {
			if (node.left == null) {
				result = tempNode;
				done = true;
			} else {
				tempNode = tempNode.left;
			}

		}
		return result;
	}

	/*
	 * return the height of the node given.
	 */
	protected int height(Node node) {
		return node.height;
	}

	
	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/* performs a rotate Right based on the AVL algorithm */
	private Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}
	
	
	/* performs a rotate left based on the AVL algorithm */
	
	private Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}
	
	/*checks to see if the tree is balanced within one degree */	
	protected boolean isBalanced(Node p) {
		return Math.abs(height(p.left) - height(p.right)) <= 1;
	}

	
	/* removes the selected node and re-balances the remainder */
	private void delete(Node node) {
		Node oldRight = node.right;
		node = node.left;
		insertNode(node, oldRight, null);
	}
}
