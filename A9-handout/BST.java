/**
 * Implements binary search trees.
 *
 * @author YOUR_NAME_HERE
 * @version Fall 2025
 */
public class BST<E extends Comparable<E>> extends BinaryTree<E> implements BST_Ops<E> {
    
    public BST(E data){
          super(data);
    }
      

    /**
     *  Returns the node of the given element, or null if not found
     *
     *  @param query The element to search
     *  @return the node of the given element, or null if not found
     */
    public BST<E> lookup(E data) {

        if (this.getData() == null) {
            return null;
        }

        if (this.getData() == data) {
            return t;
        }

        if (int compareTo(data) < 0) {
            lookup(data);
        }

    }

    /**
     *  Inserts a new node into the tree
     *
     *  @param data The element to insert
     */
    public void insert(E data) {
        if (this.getData() == null){
            this.setData(data);
            return;
        }
        BST<E> current = this;

        while (true){
            if (data.compareTo(current.getData()) == 0){
                return;
            }
            else if (data.compareTo(current.getData())<0){
                if (current.getLeft() == null){
                    current.setLeft(new BST<E>(data));
                    return;
                }
           current = (BST<E>) current.getLeft();

            }
            else if (data.compareTo(current.getData())>0){
                if (current.getRight() == null){
                    current.setRight(new BST<E>(data));
                    return;
                }
            current = (BST<E>) current.getRight();

            }
        }

    }

    /**
     *  Deletes the specified element from the tree
     *  Returns the modified tree because the root node 
     *  may have changed
     *  
     *  @param evictee The element to delete
     *  @return tree as modified
     */
    public BST<E> deleteWithCopyLeft(E evictee) {

    }

    /**
     *  Apply left rotation
     *  Returns the modified tree because the root node 
     *  may have changed
     *
     *  @return tree as modified
     */
    public BST<E> rotateLeft() {

    }

    /**
     *  Apply right rotation
     *  Returns the modified tree because the root node 
     *  may have changed
     *
     *  @return tree as modified
     */
    public BST<E> rotateRight() {

    }
            /** Override inherited manipulator to accept only BST */
        @Override
        public void setLeft(BinaryTree<E> left) {
          if ((left==null)||(left instanceof BST<E>)) {
            super.setLeft(left);
          } else {
            throw new UnsupportedOperationException("Only BST children allowed");
          }
        }

        /** Override inherited manipulator to accept only BST */
        @Override
        public void setRight(BinaryTree<E> right) {
          if ((right==null)||(right instanceof BST<E>)) {
            super.setRight(right);
          } else {
            throw new UnsupportedOperationException("Only BST children allowed");
          }
        }
    }
    
