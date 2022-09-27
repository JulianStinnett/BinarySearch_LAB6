import java.security.SecureRandom;
import java.sql.Array;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        SecureRandom oRand = new SecureRandom();
        int iNumTotal = 100;
        int[] aiNumbers = new int[iNumTotal];
        int iTargetNum;
        int iTargetNumIndex;
        int iIndexReturned;
        long lTimeStarted;
        long lTImeEnded;

        // Fill array with random numbers.
        for (int x = 0; x < aiNumbers.length; x++) {
            aiNumbers[x] = oRand.nextInt();
        }
        //sort the array to enable binary search
        Arrays.sort(aiNumbers);

        // Get a target number to pass to our search algo.
        iTargetNumIndex = oRand.nextInt(aiNumbers.length);
        iTargetNum = aiNumbers[iTargetNumIndex];
        System.out.println("Target number's index is: " + iTargetNumIndex);

        BinarySearch oBinarySearch = new BinarySearch();

        //Begin binary search test.
        lTimeStarted = System.nanoTime();
        iIndexReturned = oBinarySearch.findNumberBinarySearch(aiNumbers, iTargetNum, aiNumbers.length - 1, 0);
        lTImeEnded = System.nanoTime();
        System.out.println("Binary search elapsed time: " + (lTImeEnded - lTimeStarted));
        System.out.println("Binary search returned: " + iIndexReturned);

        //Begin Linear search test.
        lTimeStarted = System.nanoTime();
        iIndexReturned = oBinarySearch.findNumberLinearSearch(aiNumbers, iTargetNum);
        lTImeEnded = System.nanoTime();
        System.out.println("Linear search elapsed time: " + (lTImeEnded - lTimeStarted));
        System.out.println("Linear search returned: " + iIndexReturned);
    }
    /**
     * Find index of target num using binary search via recursion.
     */
    private int findNumberBinarySearch(int[] aiNumbers, int iTargetNum,int iHighIndex,int iLowIndex){

        // Get middle Index.
        int iMiddleIndex = (iHighIndex + iLowIndex) /2;

        // Check if target number is at middle index.
        if(aiNumbers[iMiddleIndex]== iTargetNum){
            return iMiddleIndex;

        }

        // check if target num is greater than the num at middle index.
        else if (iTargetNum > aiNumbers[iMiddleIndex]) {
            return findNumberBinarySearch(aiNumbers, iTargetNum, iHighIndex, iMiddleIndex + 1);
        }
        //Check if target num is Lower than num at middle index.
        else {
            return findNumberBinarySearch(aiNumbers, iTargetNum, iMiddleIndex - 1, iLowIndex);

        }
    }
    /**
     * find index of target num using linear search
     */
    private int findNumberLinearSearch(int[] aiNums, int iTargetNum) {

        for (int x = 0; x < aiNums.length; x++){
            if(aiNums[x] == iTargetNum){
                return x;
            }
        }
        return -1;
    }
}
