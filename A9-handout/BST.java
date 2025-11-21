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

        if (node.getLeft() == null && node.getRight()==null){
            if (parent == null){
                node.setData(null);
                return this;
            }
        }
        
        else if(node.getLeft() == null || node.getRight() == null){
            if (parent.getLeft() == null){
                parent.setLeft(null);
            } else{
                parent.setRight(null);
            }

        }





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
    
