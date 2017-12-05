package AutoInfoSys;

import java.util.Iterator;

public class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>> {
    //----------------------- BST Node class -------------------------//
    protected static class BSTNode<E> extends Node<E> {
        int aux;
        BSTNode(E e, Node<E> p, Node<E> lC, Node<E> rC) {
            super(e, p, lC, rC);
            aux = 0;
        }
        public int getAux() { return aux; }
        public void setAux(int a) { aux = a; }
    }//----------------------- End of BST Node class -------------------------//

    // positional-based methods related to aux fields
    public int getAux(Position<Entry<K,V>> p) { return ((BSTNode<Entry<K,V>>) p).getAux(); }

    public void setAux(Position<Entry<K,V>> p, int v) { ((BSTNode<Entry<K,V>>) p).setAux(v); }

    // Override factory method to produce BST Node and not a regular Node
    protected Node<Entry<K,V>> createNode(Entry<K,V> e, Node<Entry<K,V>> parent, Node<Entry<K,V>> left, Node<Entry<K,V>> right) { return new BSTNode<>(e, parent, left, right); }

    // Re-links parent node with oriented child node
    private void relink(Node<Entry<K,V>> parent, Node<Entry<K,V>> child, boolean makeLeftChild) {
        child.setParent(parent);
        if (makeLeftChild) parent.setLeft(child);
        else parent.setRight(child);
    }

    /**
     * @Description: Rotates Position p (child) above its parent.
     * @param p Position (child) to be rotated above parent.
     */
    public void rotate(Position<Entry<K,V>> p) {
        Node<Entry<K,V>> x = validate(p);                       // return p (child) as a validated Node
        Node<Entry<K,V>> y = x.getParent();                     // parent of p (child)
        Node<Entry<K,V>> z = y.getParent();                     // grandparent of p (child)
        if (z == null) {                                        // if p does'nt have grandparent then it becomes root/parent
            root = x;
            x.setParent(null);
        } else relink(z, x, y == z.getLeft());      // make x direct child of y
        // rotate x and y and transfer of middle subtree
        if (x == y.getLeft()) {
            relink(y, x.getRight(), true);          // make x's right child y's left
            relink(x, y, false);                    // make y x's right child
        } else {
            relink(y, x.getLeft(), false);          // make x's left child y's right child
            relink(x, y, true);                     // make y left child of x
        }
    }

    // Performs tri-node restructuring of Position x with its parent/grandparent
    public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) {
        Position<Entry<K,V>> y = parent(x);
        Position<Entry<K,V>> z = parent(y);
        if ((x == right(y)) == (y == right(x))) {               // matching alignments
            rotate(y);                                          // rotate y once
            return y;                                           // y is root of new subtree
        } else {
            rotate(x);
            rotate(x);                                          // rotate x twice
            return x;                                           // x is root of new subtree
        }
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<Entry<K, V>>> positions() {
        return null;
    }
}
