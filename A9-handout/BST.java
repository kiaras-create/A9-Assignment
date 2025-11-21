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
            return this.getRight().lookup(data);
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
        BST<E> node = this;
        BST<E> parent = null;
        while (node != null){
            if(evictee.compareTo(node.getData()) == 0){
                return node;
            }

            else if(evictee.compareTo(node.getData()) < 0){
                parent = node;
                node =(BST<E>) node.getLeft();
                if (node == null){
                    return node;
                }
            }

            else if(evictee.compareTo(node.getData())> 0){
                parent = node;
                node = (BST<E>) node.getRight();
            }
        }

        // deleting
        // if the target element is a root node, single
        if (node.getLeft() == null && node.getRight()==null){
            if (parent == null){
                node.setData(null);
                return this;
            }

        // if the node only has a right child
        } else if (node.getLeft() == null && node.getRight() != null) {
            // store the right child in a node to keep track of
            BST <E> replace = (BST <E>) node.getRight();
            
            // if the parent's left child is equal to the node, replace the node with the new child "replace"
            if (parent.getLeft() == node) {
                parent.setLeft(replace);
            // if the parent's right child is equal to the node, replace the node with the new child "replace"
            } else if (parent.getRight() == node) {
                parent.setRight(replace);
            }

        // if the node only has a left child
        } else if (node.getLeft() != null && node.getRight() == null) {
            BST <E> replace = (BST <E>) node.getLeft();
         
            // if the parent's left child is equal to the node, replace the node with the new child "replace"
            if (parent.getLeft() == node) {
                parent.setLeft(replace);
            // if the parent's right child is equal to the node, replace the node with the new child "replace"
            } else if (parent.getRight() == node) {
                parent.setRight(replace);
            }
        
        // if node has two children
        } else if (node.getLeft() != null && node.getRight() != null) {
            // in the end, this will store our new data that we replaced the node with
            BST<E> tempParent = node;
            // pointer
            BST<E> successor = (BST <E>) node.getRight();

            // traverses through to find largest value in the left subtree of the node
            // stops when the node is a leaf
            while (successor.getLeft() != null) {
                tempParent = successor;
                successor = (BST <E>) successor.getLeft();
            }

            // replaces the data of the node with the largest value in the left subtree
            node.setData(successor.getData());

            // stores the right child of the node that we want to use to replace
            BST<E> child = (BST <E>) successor.getRight();

            // if the left child of the new node is equivalent to the successor, set the left child's data as child
            if (tempParent.getLeft() == successor) {
                tempParent.setLeft(child);
            // if the first statement doesn't hold true, set the right child's data as child
            // right child of the new node is equivalent to the successor
            } else {
                tempParent.setRight(child);
            }

        }
        return this;

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
    
