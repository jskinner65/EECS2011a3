package AutoInfoSys;

/**
 * An general Binary Tree interface, in which each node has at most two children.
 * This is a specialization of the Tree interface.
 *
 * This interface supports three additional accessor methods.
 */
public interface BinaryTree<E> extends Tree<E> {
    /**
     * Accessor method that returns <code>Position</code> of p's left child or null.
     * @param p  The internal node whose child is to be returned.
     * @return <code>Position</code> of p's left child or null if none exists.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid.
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    /**
     * Returns <code>Position</code> of p's right child or null.
     * @param p  The internal node whose child is to be returned.
     * @return <code>Position</code> of p's left right or null if none exists.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid.
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    /**
     * Returns <code>Position</code> of p's sibling or null.
     * @param p  The node whose sibling is to be returned.
     * @return <code>Position</code> of p's sibling or null if none exists.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid.
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
