package AutoInfoSys;

import java.util.Iterator;

/**
 * Concrete implementation of a binary tree using  a node-based, linked structure.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    //-------------------- Node class ---------------------//
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node (E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        //---------------- GETTER ----------------------//
        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public Node<E> getLeft() { return left; }
        public Node<E> getRight() { return right; }
        //----------------- SETTER -----------------------//
        public void setElement(E e) { element = e; }
        public void setParent(Node<E> node) { parent = node; }
        public void setLeft(Node<E> node) { left = node; }
        public void setRight(Node<E> node) { right = node; }
    }//-------------------- End of Node ------------------//

    /**
     * Factory method to create new node with element e and return node instance
     * @param e element at this node.
     * @param p parent of this node.
     * @param l left child.
     * @param r right child.
     * @return new <code>Node</code> instance.
     */
    protected Node<E> createNode(E e, Node<E> p, Node<E> l, Node<E> r) {
        return new Node<E>(e, p, l, r);
    }

    // LinkedBinaryTree attributes
    protected Node<E> root;                 // root of tree
    protected int size;                     // number of nodes in the tree

    //-------------------- CONSTRUCTOR -------------------//
    public LinkedBinaryTree() {            
        root = null;                        // initialize to null
        size = 0;                           // initialize to zero
    }

    /**
     * Protected utility method. Validates or ensures that given <code>Position</code> is a valid node.
     * @param p <code>Position</code> to be validated.
     * @return <code>Node</code> instance of validated <code>Position</code>.
     * @throws IllegalArgumentException if <code>Position</code> is invalid.
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not a valid position type");
        Node<E> node = (Node<E>) p;                     // safe cast
        if (node.getParent() == node) throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    //---------------------------- accessor methods (not already implemented in AbstractBinaryTree)----------//

    public int size() {
        return size;
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    //-------------------- update methods supported by this class -----------------------//

    /**
     * Update method creates a root for an empty tree and stores e as the element.
     * <code>Position</code> of that root is returned.
     * @param e Element to be stored at new root.
     * @return <code>Position</code> of the new root.
     * @throws IllegalStateException if the tree is not empty.
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Update method creates a new node, a new left child of Position p storing element e.
     * @param p The <code>Position</code> for which a new left child is created.
     * @param e Element to be stored at new <code>Position</code>.
     * @return <code>Position</code> of new node.
     * @throws IllegalArgumentException if the p has a left child.
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Update method creates a new node, a new right child of Position p storing element e.
     * @param p The <code>Position</code> for which a new right child is created.
     * @param e Element to be stored at new <code>Position</code>.
     * @return <code>Position</code> of new node.
     * @throws IllegalArgumentException if the p has a right child.
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Update method to replace element at p with new one.
     * @param p  <code>Position</code> whose element is to be changed.
     * @param e new element.
     * @return previously stored element.
     * @throws IllegalArgumentException if p is invalid.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E tmp = node.getElement();
        node.setElement(e);
        return tmp;
    }

    /**
     * Update method that attaches trees t1 and t2 as left and right subtrees to leaf <code>Position</code> p,
     * and resets t1 and t2 to empty trees.
     * @param p  leaf <code>Position</code> recieving subtrees t1 and t2.
     * @param t1 <code>LinkedBinaryTree</code> left subtree.
     * @param t2 <code>LinkedBinaryTree</code> right subtree.
     * @throws IllegalArgumentException if p is not a leaf.
     */
    public void attatch(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {                            // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {                            // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes node at Position p and replaces it with its child, if any.
     * @param p <code>Position</code> that is being removed.
     * @return element that had been stored at <code>Position</code> p.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) child.setParent(node.getParent());
        if (node == root) root = child; 
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) parent.setLeft(child);
            else parent.setRight(child);
        }
        size--;
        E tmp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return tmp;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }
}
