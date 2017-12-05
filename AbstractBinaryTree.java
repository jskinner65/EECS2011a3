package AutoInfoSys;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);                 // get Position of p's parent
        if (parent == null) return null;                // If parent of p is null the p must be root in which case it has no siblings
        if (p == left(parent)) return right(parent);    // If p is left child, return its right sibling
        else return left(parent);                       // If p is right child, return its left sibling
    }

    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) count++;                   // if p has a left child, increment count
        if (right(p) != null) count++;                  // if p has a right child, increment count
        return count;
    }

    /**
     * Accessor method returns iterable collection of p's children
     * @param p The node for which an iterable collection of its children is to be returned.
     * @return iterable collection of every <code>Position</code> of p's children.
     */
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);        // an empty ArrayList serves as the snapshot
        if (left(p) != null) snapshot.add(left(p));                        // add children to the snapshot
        if (right(p) != null) snapshot.add(right(p));
        return snapshot;
    }
}
