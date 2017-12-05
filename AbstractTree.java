package AutoInfoSys;

/**
 * An abstract base class implementing the methods and providing 
 * some functionality for the general tree interface.
 * This class will be used the make more concrete Tree structures.
 */
public abstract class AbstractTree<E> implements Tree<E> {
    /**
     * <code>Position</code> p is an internal node if it
     * has more than zero (at least one) children.
     */
    public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
    /**
     * <code>Position</code> p is an external node if it has zero children.
     */
    public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
    /**
     * <code>Position</code> p is the root of the tree if it is equal to
     * return value of <code>root()</code> which is the root of the tree.
     */
    public boolean isRoot(Position<E> p) { return p == root(); }
    public boolean isEmpty() { return size() == 0; }
}
