/**
 * Class to implement tree conversions
 *
 * @author YOUR_NAME_HERE
 * @version Fall 2025
 */


public class Conversion {
  /** Converts a sorted array to a balanced BST */
  
  public static <T extends Comparable<T>> BST<T> arrayToBST(T[] arr) {

    //If array is empty just return null tree
    if(arr==null ||arr.length==0){

      return null;
    }

    return arrayToBSTHelper(arr,0,arr.length);
  }

  /**
   * Recursive helper to create a balanced BST
   * @param <T> type of the element in the array
   * @param arr the sorted array
   * @param low the starting index for this part of the array
   * @param high the end index for this part of the array
   * @return the node created from this part of the array
   */
  private static <T extends Comparable<T>> BST<T> arrayToBSTHelper(T[]arr,int low, int high){

    //low index can't be greater than high
    if(low >= high){
      return null;
    }
    
    //Finds the middle index
    int mid = (high + low) / 2;

    //Create a new node with the middle element 
    BST<T> node = new BST<T>(arr[mid]);

    //Recursively do the same for the left and right halves
    node.setLeft(arrayToBSTHelper(arr, low, mid));
    node.setRight(arrayToBSTHelper(arr, mid + 1, high));

    return node;
  }

  /** Convert BinaryTree to DLL */
  public static <S extends Comparable<S>> DLL<S> binaryTreeToDLL(BinaryTree<S> t) {
    return null; // replace this with your implementation
  } 

  
}
