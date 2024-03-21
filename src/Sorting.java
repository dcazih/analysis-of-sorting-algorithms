import java.util.Random;

public class Sorting {

    public static void printArray(int[] A){ // For testing
        for (int i : A) System.out.printf(i + " ");
        System.out.println();
    }

    public static void insertionSort(int[] A){
        int i, j, key;
        for (i = 1; i < A.length; i++){
            key = A[i];
            j = i - 1;
            while (j >= 0 && A[j] > key){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j+1] = key;
        }
    }

    public static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;
        if (inputLength < 2) return; // If we have an array of size one or zero, then already sorted

        // Midpoint of array used to split inputArray into left/right halves
        int midIndex = inputLength/2;
        int[] leftHalf = new int[midIndex]; // allocated memory for left/right halves
        int[] rightHalf = new int[inputLength - midIndex];

        // Copy left half of elements in inputArray to leftHalf (inputArray[0:midPoint])
        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = inputArray[i];
        }
        // Copy right half of elements in inputArray to rightHalf (inputArray[midPoint:inputLength])
        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = inputArray[i];
        }

        // Recursively call mergeSort to split left/halves down even further (until inputLength < 2)
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }
    public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0; // "i" is the iterator for leftHalf, "j" for rightHalf, and "k" for the merged array

        // Loops until i and j iterators reach end of left/right arrays
        while (i < leftSize && j < rightSize) {
            // Compares ith element of leftHalf to the jth element of the rightHalf
            if (leftHalf[i] <= rightHalf[j]){ // if ith element less than jth element, add ith element to merged array
                inputArray[k] = leftHalf[i];
                i++;
            } else { // else jth element is less than ith element, so add jth element to merged array
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++; // increment merged array iterator
        }

        // Cleanup: Add the rest of the elements from either left/right half into merged array
        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i++; k++;
        }
        while(j < rightSize){
            inputArray[k] = rightHalf[j];
            j++; k++;
        }
    }

    public static void quicksort(int[] inputArray, int lowIndex, int highIndex){
        if (lowIndex < highIndex) {
            int partitionIndex = randomizedPartition(inputArray, lowIndex, highIndex); // array partitioned, pivot stored in partitionIndex
            quicksort(inputArray, lowIndex, partitionIndex - 1);
            quicksort(inputArray, partitionIndex + 1, highIndex);
        }
    }
    public static int randomizedPartition(int[] inputArray, int lowIndex, int highIndex) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(highIndex - lowIndex + 1) + lowIndex; // generate random index within range

        // Swap random pivot with last element
        int temp = inputArray[randomIndex];
        inputArray[randomIndex] = inputArray[highIndex];
        inputArray[highIndex] = temp;

        int pivot = inputArray[highIndex]; // selecting the pivot element
        int smallerElementIndex = lowIndex - 1; // index to track smaller elements

        for (int currentIndex = lowIndex; currentIndex < highIndex; currentIndex++) {
            if (inputArray[currentIndex] <= pivot) {
                smallerElementIndex++; // moving the index to the next smaller element

                // Swapping the current element with the smaller element
                temp = inputArray[smallerElementIndex];
                inputArray[smallerElementIndex] = inputArray[currentIndex];
                inputArray[currentIndex] = temp;
            }
        }

        // Swap the pivot element to its correct position
        temp = inputArray[smallerElementIndex + 1];
        inputArray[smallerElementIndex + 1] = inputArray[highIndex];
        inputArray[highIndex] = temp;

        return smallerElementIndex + 1;
    }

    public static void calculateTimeCosts(int maxIntSize){
        int[][] unsortedRandomArrays = new int[20][maxIntSize]; // Holds 20 arrays each the size of maxIntSize
        int[][] randomArrays = new int[20][maxIntSize]; // Holds 20 arrays each the size of maxIntSize

        // Creates randomly generated array of size maxIntSize contained elements ranging from -maxIntSize to
        // maxIntSize, and adds each array to randomArrays of size 20
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int [] randomArray = new int[maxIntSize]; // empty array of size maxIntSize
            for (int j = 0; j < randomArray.length; j++){ // fills in empty array
                randomArray[j] = rand.nextInt(-maxIntSize, maxIntSize);
            }
            unsortedRandomArrays[i] = randomArray; // Add randomArray to array of arrays (randomArrays)
        }
        randomArrays = unsortedRandomArrays;

        long start, end; // tracks the start and stop time for each sorting algorithm execution
        long[] insertionExecutionTimes = new long[20];  // arrays storing 20 execution times for each sort
        long[] mergeSortExecutionTimes = new long[20];
        long[] quickSortExecutionTimes = new long[20];

        // Loop adds execution times to respective execution time array for each sort
        for (int i = 0; i < 20; i++){
            // Timer for: Insertion Sort
            start = System.nanoTime();
            insertionSort(randomArrays[i]);
            end = System.nanoTime();
            insertionExecutionTimes[i] = (end - start);

            // Timer for: Merge Sort
            start = System.nanoTime();
            mergeSort(randomArrays[i]);
            end = System.nanoTime();
            mergeSortExecutionTimes[i] = (end - start);
            randomArrays[i] = unsortedRandomArrays[i]; // resets previously sorted array

            // Timer for: Quick Sort
            start = System.nanoTime();
            quicksort(randomArrays[i], 0 , randomArrays[i].length - 1);
            end = System.nanoTime();
            quickSortExecutionTimes[i] = (end - start);
            randomArrays[i] = unsortedRandomArrays[i]; // resets previously sorted array

        }

        // Calculate the mean execution time for each sort
        double meanExecutionTime = 0;
        System.out.printf("Experimental Results (for an array of size %s is): \n\n", maxIntSize);

            // Calculating mean execution: Insertion Sort
        for (int i = 0; i < 20; i++) meanExecutionTime += insertionExecutionTimes[i]; // sum all execution times
        meanExecutionTime = (double) meanExecutionTime / 20; // divide by total num of execution times (20)
        System.out.printf("The average time cost for Insertion Sort: %.2fms\n", meanExecutionTime / 1000000);

            // Calculating mean execution: Merge Sort
        for (int i = 0; i < 20; i++) meanExecutionTime += mergeSortExecutionTimes[i]; // sum all execution times
        meanExecutionTime = (double) meanExecutionTime / 20; // divide by total num of execution times (20)
        System.out.printf("The average time cost for Merge Sort: %.2fms\n", meanExecutionTime / 1000000);

            // Calculating mean execution: Quick Sort
        for (int i = 0; i < 20; i++) meanExecutionTime += quickSortExecutionTimes[i]; // sum all execution times
        meanExecutionTime = (double) meanExecutionTime / 20; // divide by total num of execution times (20)
        System.out.printf("The average time cost for Quick Sort: %.2fms\n", meanExecutionTime / 1000000);
    }
}
