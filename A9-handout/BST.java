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

        // stop condition, if current node's data is null
        if (this.getData() == null) {
            return null;
        }

        // stop condition, if given element's data and current node's data matches
        if (this.getData() == data) {
            return this;
        }

        // if current node's data is before the given element's data
        if (this.getData().compareTo(data) < 0) {
            return lookup(data);
        } else {
            // else if current node's data is after given element's data
            return lookup(data);
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
        if (this.getRight() == null) {
            return this; // cannot rotate left if it doesn't have a right child
        }

        //Get the right child that will become the new node after rotation
        BST<E> rightChild = (BST<E>) this.getRight();
        
        // Move its left subtree to be the right subtree
        this.setRight(rightChild.getLeft());

        // Make this node the left child of the right child
        rightChild.setLeft(this);

        // Return the new node of the rotated subtree
        return rightChild;

    }

    /**
     *  Apply right rotation
     *  Returns the modified tree because the root node 
     *  may have changed
     *
     *  @return tree as modified
     */
    public BST<E> rotateRight() {
        if (this.getLeft() == null){
            return this; // cannot rotate right if it doesn't have a left child
        }

        // Get the left child that will become the new node after rotation
        BST<E> leftChild = (BST<E>) this.getLeft();
        
        // Move its right subtree to be the left subtree
        this.setLeft(leftChild.getRight());

        //Make this node the right child of the left child
        leftChild.setRight(this);

        // Return the new node of the rotated subtree
        return leftChild;

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
    
