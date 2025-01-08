public class binarySearch {

    public boolean runSearch(int[] ints, int target) {
        int l = 0;
        int right = ints.length - 1;

        while (l <= right) {
            // needs to be l + (r - l)/2 because it can cause errors due to error overflow
            // when you just try to do (r + l)/2 when the arrays get huge
            // this way, you add lef to the distance/2 -> move left to the mid basically
            int mid = l + (right - l) / 2;

            if (ints[mid] == target) {
                return true; // sure u found it
            }

            else if (target < ints[mid]) {
                right = mid - 1;
            } else if (target > ints[mid]) {
                l = mid + 1;
            }
        }
        return false;
    }

    // Generalized template
    public int search(int[] array) {
        // know your search space here, n = length of the array
        int left = 0; // beginning of search space
        int right = array.length - 1; // ending of search space

        while (left < right) {
            // calculate midpoint
            int mid = left + (right - left) / 2;

            // when we FIND the target, we close in from the right.
            // ptrs will eventually collapse on the same point
            if (condition(array[mid])) {
                right = mid;
            } else {
                left = mid + 1;
            }

            /**
             * 
             * while(left <= right){
             * //calculate midpoint
             * int mid = left + (right - left) / 2;
             * if(condition(array[mid])){
             * right = mid - 1;
             * } else {
             * left = mid + 1;
             * }
             */
        }
        // which is returned OR return false
        return left;
    }

    private boolean condition(int value) {
        // implement condition based on problem
        // return value == target
        return false;
    }
}

/**
 * Notes:
 * l < r WHEN finding boundary or returning left as an answer
 * l <= r WHEN looking for exact value, return -1 or false as answer
 */