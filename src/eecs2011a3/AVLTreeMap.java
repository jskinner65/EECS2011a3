package eecs2011a3;

import java.util.Comparator;
import java.util.TreeMap;

public class AVLTreeMap<K, V> extends TreeMap<K, V> {
	Tree tree = new Tree();
	/**
	 * 
	 */

	public AVLTreeMap() {
		super();
	}

	public AVLTreeMap(Comparator<K> comp) {
		super(comp);
	}

	protected int height(Position<Entry<K, V>> p) {
		return tree.getAux(p);

	}

	protected void recomputeHeight(Position<Entry<K, V>> p) {
		tree.setAux(p, 1 + Math.max(height(leftOf(p)), height(rightOf(p))));
	}

	protected boolean isBalanced(Position<Entry<K, V>> p) {
		return Math.abs(height(leftOf(p)) - height(rightOf(p))) <= 1;
	}

	private Position<Entry<K, V>> rightOf(Position<Entry<K, V>> p) {
		// TODO Auto-generated method stub
		return null;
	}

	private Position<Entry<K, V>> leftOf(Position<Entry<K, V>> p) {
		// TODO Auto-generated method stub
		return null;
	}

	protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
		if (height(leftOf(p)) > height(rightOf(p)))
			return leftOf(p);
		if (height(leftOf(p)) < height(rightOf(p)))
			return rightOf(p);
		if (isRoot(p))
			return leftOf(p);
		if (p == leftOf(parentOf(p)))
			return leftOf(p);
		else
			return rightOf(p);
	}

	private Position<Entry<K, V>> parentOf(Position<Entry<K, V>> p) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isRoot(Position<Entry<K, V>> p) {
		// TODO Auto-generated method stub
		return false;
	}

	protected void rebalance(Position<Entry<K, V>> p) {
		int oldHeight, newHeight;
		do {
			oldHeight = height(p);
			if (!isBalanced(p)) {
				p = restructre(tallerChild(tallerChild(p)));
				recomputeHeight(leftOf(p));
				recomputeHeight(rightOf(p));
			}
			recomputeHeight(p);
			newHeight = height(p);
			p = parentOf(p);
		} while (oldHeight != newHeight && p != null);
	}

	private Position<Entry<K, V>> restructre(Position<Entry<K, V>> tallerChild) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void rebalanceInsert(Position<Entry<K, V>> p) {
		rebalance(p);
	}

	protected void rebalanceDelete(Position<Entry<K, V>> p) {
		if (!isRoot(p))
			rebalance(parentOf(p));
	}


}
