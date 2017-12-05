package AutoInfoSys;

import java.util.Iterator;

/**
 * A general interface for a Tree in which nodes can have any number of children.
 * This Tree ADT uses the concept of <code>Position</code> to abstractly represent a node.
 * At each <code>Position</code> and element is stored.
 */
public interface Tree<E> extends Iterable<E> {
    /**
     * Accessor method to return the Position of the root of the tree.
     * @return <code>Position</code> of the root of tree.
     */
    Position<E> root();
    /**
     * Accessor method to return the Position of the parent of child p.
     * @return <code>Position</code> of the parent p.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid.
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    /**
     * Accessor method to return an iterable collection of the children of Position p.
     * @return iterable collection of <code>Position</code>s of children of p.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid.
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    /**
     * Accessor method to return the number of children of Position p.
     * @return <code>int</code> representing the number of children of p.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;
    /**
     * Query method to to determine whether p is an internal node.
     * @return <code>true</code> if p has at least one child.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid
     */
    boolean isInternal(Position<E> P) throws IllegalArgumentException;
    /**
     * Query method to to determine whether p is an external node.
     * @return <code>true</code> if p has no children.
     * @throws IllegalArgumentException if <code>Position</code> p is invalid
     */
    boolean isExternal(Position<E> P) throws IllegalArgumentException;
    /**
     * Query method to to determine whether p is the root of the tree.
     * @return <code>true</code> if p is the root (has no parent).
     * @throws IllegalArgumentException if <code>Position</code> p is invalid
     */
    boolean isRoot(Position<E> P) throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}
