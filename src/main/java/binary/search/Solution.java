package binary.search;

class Solution {
    public static void main(String[] args) {
        int[] array = {0,0,1,1,1};
        System.out.println(sqrt(20));
    }


    // sqrt(9) = 3, sqrt(10) -> 3 return the closest floored integer
    // sqrt(0) = 0
    // sqrt(1) = 1
    // sqrt(4) = 2
    // sqrt(9) = 3
    // sqrt(16) = 4
    // sqrt(25) = 5
    //sqrt(26) = 5
    // lo = 0, hi = 13, mid = 7
    // lo = 0, hi = 6, mid = 3
    // lo = 3, hi = 6, mid = 5
    // lo = 5, hi = 6, mid = 6
    // lo 5, hi = 5
    static int sqrt(int x){
        int lo = 0, hi = x / 2;
        while(lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if ( mid*mid > x )
                hi = mid - 1;
            else
                lo = mid;
        }
        return lo;
    }

// return startIdx, and endIdx of that slice
    /** The maximum total of the min subarray
     n = 3 people
     bar = [1, 2, 3,\ 3, 2,\ 4, 4]

     1. Range of the answer lo , hi
     lo = min (bar), 0
     hi = sum (bar), 19 / 3 = 6

     2. validate the mid

     int mid = (lo + hi + 1) / 2; //mid is the suspected amount that I might get

     mid = 3
     Question: is 3 achievable for me?? Yes.
     prefix sum
     sum(1,.., bar.length) = 3 or not

     lo = 3, hi = 6, mid = 4
     lo = 4, hi = 6, mid = 5

     Time complexity: O(n*log(sum(array))), n: len of array
     if sum(array) is within java integer bounds
     log(max integer)

     static int candyCutting(int[] array, int headcount){
     int lo = 0, hi = sum(array) / 3;
     while(lo < hi) {
     int mid = lo + (hi - lo + 1) / 2;
     if (isMidAchievable(headcount, array)) // O(n)
     hi = mid - 1;
     else
     lo = mid; // this line determines the mid expression
     }
     return lo;
     }
     */






    static int binarySearchFirstOne(int[] array){
        int lo = 0, hi = array.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == 1)
                hi = mid; // this line determines the mid expression
            else
                lo = mid+1;
        }
        return lo;
    }

    // 0,0,0,0,0,1,1,1   find the last 0
    //0, 1
    // BS: should test with small amount of element (1,2,3)
    static int binarySearch(int[] array){
        int lo = 0, hi = array.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (array[mid] == 1)
                hi = mid - 1;
            else
                lo = mid; // this line determines the mid expression
        }
        return lo;
    }
}

