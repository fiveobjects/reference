package org.openapex.samples.misc.assorted;

public class BinarySearchRecursive {
    public static void main(String[] args) throws Exception{
        int[] array ={5, 4};
        System.out.println(binarySearch(array, 4));
    }

    private static int binarySearch(int[] array, int target) throws Exception {
        return binarySearch(array, target, 0, array.length - 1);
        //return binarySearchTraditional(array, 0, array.length - 1, target);
    }

    private static int binarySearch(int[] array, int target, int lower, int upper) throws Exception {
        int center, range;

        range = upper - lower;

        if (range < 0 || (range == 0 && array[lower] != target)) {
            throw new Exception("Element not in array");
        }

        if (array[lower] > array[upper]) {
            throw new Exception("Array not sorted");
        }
        center = ((range) / 2) + lower;
        if (target == array[center]) {
            return center;
        } else if (target < array[center]) {
            return binarySearch(array, target, lower, center - 1);
        } else {
            return binarySearch(array, target, center + 1, upper);
        }
    }

    public static int binarySearchTraditional(int arr[], int first, int last, int key){
        if (last>=first){
            int mid = first + (last - first)/2;
            if (arr[mid] == key){
                return mid;
            }
            if (arr[mid] > key){
                return binarySearchTraditional(arr, first, mid-1, key);//search in left subarray
            }else{
                return binarySearchTraditional(arr, mid+1, last, key);//search in right subarray
            }
        }
        return -1;
    }
}
