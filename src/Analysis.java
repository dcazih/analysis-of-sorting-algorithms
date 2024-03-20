public class Analysis {
    public static void main(String[] args){

        // Desired maxInputSize specified through command line arguments or 100000 by default
        int maxInputSize = 100000;
        if(args.length > 1) maxInputSize = Integer.valueOf(args[0]);

        // Test Arrays:
        System.out.println("\n       == Tests For Correctness On Each Algorithm ==");
        System.out.println("(Each array below should be sorted by its sorting algorithm)");

        // Test Cases For Insertion
        int [] bestCaseArray = new int[]{1, 2, 3, 4, 5};
        int [] worstCaseArray = new int[]{120, 98, 55, 32, 31};
        int [] averageCaseArray = new int[]{38, 27, 43, 3, 3, 82, 10};
        System.out.println("\nInsertion Sort:");
        Sorting.insertionSort(bestCaseArray); Sorting.printArray(bestCaseArray);
        Sorting.insertionSort(worstCaseArray); Sorting.printArray(worstCaseArray);
        Sorting.insertionSort(averageCaseArray); Sorting.printArray(averageCaseArray);

        // Test Cases For Merge
        int [] bestCaseArray2 = new int[]{1, 2, 3, 4, 5};
        int [] worstCaseArray2 = new int[]{120, 98, 55, 32, 31};
        int [] averageCaseArray2 = new int[]{38, 27, 43, 3, 3, 82, 10};
        System.out.println("\nMerge Sort:");
        Sorting.mergeSort(bestCaseArray2); Sorting.printArray(bestCaseArray2);
        Sorting.mergeSort(worstCaseArray2); Sorting.printArray(worstCaseArray2);
        Sorting.mergeSort(averageCaseArray2); Sorting.printArray(averageCaseArray2);

        // Test Cases For Merge
        int [] bestCaseArray3 = new int[]{1, 2, 3, 4, 5};
        int [] worstCaseArray3 = new int[]{120, 98, 55, 32, 31};
        int [] averageCaseArray3 = new int[]{38, 27, 43, 3, 3, 82, 10};
        System.out.println("\nQuickSort:");
        Sorting.quicksort(bestCaseArray3, 0, bestCaseArray3.length-1); Sorting.printArray(bestCaseArray3);
        Sorting.quicksort(worstCaseArray3, 0, worstCaseArray3.length-1); Sorting.printArray(worstCaseArray3);
        Sorting.quicksort(averageCaseArray3, 0, averageCaseArray3.length-1); Sorting.printArray(averageCaseArray3);

        // ########################################################################### //

        // Time cost calculation of 20 large size arrays (sizeOfArrays = maxInputSize)
        System.out.println("\nCalculating time costs...");
        Sorting.calculateTimeCosts(maxInputSize);
    }
}
