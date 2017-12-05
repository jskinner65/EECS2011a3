package AutoInfoSys;

/**
 * An abstraction for node used in the Tree structure.
 * Every <code>Position</code> will represent a node and an element
 * will be stored at each <code>Position</code>.
 */
public interface Position<E> {
    /**
     * Accessor method that returns the element at this <code>Position</code>.
     * @return Element of type <code>E</code> stored at this <code>Position</code>.
     * @throws IllegalStateException
     */
    E getElement() throws IllegalStateException;
}
