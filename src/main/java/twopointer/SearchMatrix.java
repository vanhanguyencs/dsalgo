package twopointer;

/*
Find the target element from a 2D array. The array is sorted increasingly row-
wise as well as column-wise.
[[ 1, 4, 9, 10, 20],
[ 2, 7, 11, 12, 23],
[ 5, 8, 13, 14, 25],
[16, 17, 18, 24, 31],
[20, 22, 23, 26, 45],
[26, 27, 28, 29, 50]]
target = 22, output = true
target = 15, output = false
Can you find it in O(n + m) ?

 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 9, 10, 20},
                {2, 7, 11, 12, 23},
                {5, 8, 13, 14, 25},
                {16, 17, 18, 24, 31},
                {20, 22, 23, 26, 45},
                {26, 27, 28, 29, 50}
        };
        System.out.println(findElement(matrix, 22));
        System.out.println(findElement(matrix, 15));
    }

    public static boolean findElement(int[][] array, int target) {
        int rows = array.length;
        int cols = array[0].length;

        // Start from the top-right corner of the array
        int row = 0;
        int col = cols - 1;

        // Traverse the array
        while (row < rows && col >= 0) {
            if (array[row][col] == target) {
                return true; // Element found
            } else if (array[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        return false; // Element not found
    }

}
