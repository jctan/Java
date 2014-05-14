public class Sorting{
    
    private int size = 10000;
    private int [] data = new int[size];
    
    //create random numbers.
    public void generateRandomNum(){
        for(int i = 0; i < size; i++){
            data[i] = (int)(Math.random() * 100);
        }
    }
    
    //generate random numbers in an array
    private static int[] generateRandomNumbers(int [] array){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * 100);
        }
        return array;
    }
    
    //***************** INSERTION SORT **********************//
    public void insertionSort(){
        
        System.out.println("Before sorting: ");
        for(int i = 0; i < size; i++){
            System.out.print(" " + data[i] + " ");
        }
        long startTime_Insertion = System.currentTimeMillis();
        System.out.println("\nStart Time: " + startTime_Insertion);
        
        int temp_last;
        int i;
        int j;
        for(i = 0; i < size; i++){
            for(j = i; j > 0; j--){
                if(data[j] < data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
   
        
        System.out.println();
        
        System.out.println("After sorting: ");
        for(i = 0; i < size; i++){
            System.out.print(" " + data[i] + " ");
        }
        long endTime_Insertion = System.currentTimeMillis();
        System.out.println("\nEnd Time: " + endTime_Insertion);
        long finaTime_Insertion = endTime_Insertion - startTime_Insertion;
        System.out.println("------------------------------");
		System.out.println("Time it took to complete INSERTION SORT: " +finaTime_Insertion+ " Milliseconds");
        
        System.out.println();
    }//END INSRTION SORT
    
    //***************** BUBBLE SORT **********************//
    public void bubbleSort(){
        System.out.println("Before sorting: ");
        for(int i = 0; i < size; i++){
            System.out.print(" " + data[i] + " ");
        }
        long startTime_Bubble = System.currentTimeMillis();
        System.out.println("\nStart Time: " + startTime_Bubble);

        
        for(int i = size-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        System.out.println();
        
        System.out.println("After sorting: ");
        for(int i = 0; i < size; i++){
            System.out.print(" " + data[i] + " ");
        }
        long endTime_Bubble = System.currentTimeMillis();
        System.out.println("\nEnd Time: " + endTime_Bubble);
        long finaTime_Bubble = endTime_Bubble - startTime_Bubble;
        System.out.println("------------------------------");
		System.out.println("Time it took to complete BUBBLE SORT: " +finaTime_Bubble+ " Milliseconds");

        
        System.out.println();
        
    }//END BUBBLE SORT
    
    //***************** MERGE SORT **********************//
    
    //prints the array for merge sort
    public static void showMergeSort(int [] arraySize){
        for(int i = 0; i < arraySize.length; i++){
            System.out.print(" " + arraySize[i] + " ");
        }
    }
    
    //divide the array in halfs until a single element
    public static int[] mergeSort(int [] arraySize){
        if(arraySize.length <= 1){
            return arraySize;
        }
        
        int midpoint = arraySize.length/2;
        
        int [] left = new int[midpoint];
        int [] right;
        //even number to midpoint, else odd number
        if(arraySize.length % 2 == 0){
            right = new int [midpoint];
        }
        else{
            right = new int[midpoint+1];
        }
        
        int [] result = new int[arraySize.length];
        
        //populate original array from 0 to midpoint on left
        for(int i = 0; i < midpoint; i++){
            left[i] = arraySize[i];
        }
        
        //start 0 to midpoint on right
        int x = 0;
        for(int j = midpoint; j < arraySize.length; j++){
            if(x < right.length){
            right[x] = arraySize[j];
            x++;
            }
        }
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        result = merge(left,right);
        
        //return the sorted array.
        return result;
        
    }
    
    //sort the array from small to greater and merge the right and left array together
    public static int [] merge(int [] left, int [] right){
        int lengthResult = left.length + right.length;
        int [] result = new int[lengthResult];
        int indexLeft = 0;
        int indexRight = 0;
        int indexResult = 0;
        
        while (indexLeft < left.length || indexRight < right.length){
            
            //if there's element on right and left
            if(indexLeft < left.length && indexRight < right.length){
                //if left index is smaller or equal to the right index
                if(left[indexLeft] <= right[indexRight]){
                    result[indexResult] = left[indexLeft]; // put left first
                    indexLeft++;
                    indexResult++;
                }
                else{
                    result[indexResult] = right[indexRight]; // otherwise, put it right side.
                    indexRight++;
                    indexResult++;
                }
            }
            //check the left side if there's element in left and right side is empty.
            else if (indexLeft < left.length){
                result[indexResult] = left[indexLeft];
                indexLeft++;
                indexResult++;
            }
            //else check right side if there's element in right and left side is empty.
            else if (indexRight < right.length){
                result[indexResult] = right[indexRight];
                indexRight++;
                indexResult++;
            }
        }
        return result;
    } //END MERGE SORT
    
    //***************** QUICK SORT **********************//
    //All items are compared with the pivot - left pointer the compare with the pivot if its less, right pointer compare if it's greater. once the right and left pointer meet, that index became the "split point". It will sort recursively on the left and right of the split point.
    public static int partition(int array[], int left, int right){
        int L = left;
        int R = right;
        int pivot = array[(left + right) / 2];
        
        while(L <= R){
            while(array[L] < pivot){
                L++;
            }
            while(array[R] > pivot){
                R--;
            }
        
        if( L <= R){
            int temp = array[L];
            array[L] = array[R];
            array[R] = temp;
            L++;
            R--;
        }
    }
    return L;
    
    }
    
    //sort recursively with the left and right sublist of the splitpoint (index).
    public static void quickSort(int array[], int left, int right){
        int index = partition(array,left,right);
        if (left < index - 1){
            quickSort(array, left, index - 1);
        }
        if(index < right){
            quickSort(array, index, right);
        }
    }
    
    //prints the array for quicksort
    public static void showQuickSort(int [] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(" " + array[i] + " ");
        }
    }
    //END QUICK SORT

    //SELECTION SORT - start with the first index and compare with the smallest value throughout the entire list, then it gets swapped with the index it was checking against.
    
    public static void selectionSort(int [] array){
        int i;
        int j;
        
        for(i = 0; i < array.length-1; i++){
            j = findSmallestIndex(array,i);
            swap(array,i,j);
        }
    }
    
    //return the index with the minimum element.
    public static int findSmallestIndex(int [] array, int start){
        int smallestIndex = start;
        
        for(int i = start + 1; i < array.length; i++){
            if(array[i] < array[smallestIndex]){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    //swap element i and j
    public static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    //prints the array for selection sort
    public static void showSelectionSort(int [] array){
        for(int i = 0; i < array.length-1; i++){
            System.out.print(" " + array[i] + " ");
        }
    }//END SELECTION SORT
    
    
    public static void main(String [] args){
        
        //instance of a class for invoking non-static methods.
        Sorting sortArray = new Sorting();
        
        //output insertion sort
        System.out.println("INSERTION SORT");
        sortArray.generateRandomNum();
        sortArray.insertionSort();
		
        System.out.println();
        
        //output bubble sort
        System.out.println("BUBBLE SORT");
        sortArray.generateRandomNum();
        sortArray.bubbleSort();
        
        System.out.println();
        
        //output selection sort
        int selectionData [] = new int[10000];
        generateRandomNumbers(selectionData);
        System.out.println("SELECTION SORT");
        System.out.println("Before sorting: ");
        showSelectionSort(selectionData);
        long startTime_Selection = System.currentTimeMillis();
        System.out.println("\nStart Time: " + startTime_Selection);
        
        selectionSort(selectionData);
        
        System.out.println();
        System.out.println("After Sorting: ");
        showSelectionSort(selectionData);
        long endTime_Selection = System.currentTimeMillis();
        System.out.println("\nEnd Time: " + endTime_Selection);
        long finaTime_Selection = endTime_Selection - startTime_Selection;
        System.out.println("------------------------------");
		System.out.println("Time it took to complete SELECTION SORT: " +finaTime_Selection + " Milliseconds");
        
        System.out.println();
        System.out.println();
        
        //output merge sort
        int mergeData [] = new int [10000];
        generateRandomNumbers(mergeData);
        System.out.println("MERGE SORT");
        System.out.println("Before sorting: ");
        showMergeSort(mergeData);
        long startTime_Merge = System.currentTimeMillis();
        System.out.println("\nStart Time: " + startTime_Merge);
        
        mergeData = mergeSort(mergeData);
        
        System.out.println();
        System.out.println("After Sorting: ");
        showMergeSort(mergeData);
        long endTime_Merge = System.currentTimeMillis();
        System.out.println("\nEnd Time: " + endTime_Selection);
        long finaTime_Merge = endTime_Merge - startTime_Merge;
        System.out.println("------------------------------");
		System.out.println("Time it took to complete MERGE SORT: " +finaTime_Merge + " Milliseconds");

        
        System.out.println();
        System.out.println();
        
        //output quick sort
        int quickData [] = new int[10000];
        generateRandomNumbers(quickData);
        System.out.println("QUICK SORT");
        System.out.println("Before sorting: ");
        showQuickSort(quickData);
        long startTime_Quick = System.currentTimeMillis();
        System.out.println("\nStart Time: " + startTime_Quick);
        
        quickSort(quickData, 0, quickData.length - 1);
        System.out.println();
        System.out.println("After Sorting: ");
        showQuickSort(quickData);
        long endTime_Quick = System.currentTimeMillis();
        System.out.println("\nEnd Time: " + endTime_Quick);
        long finaTime_Quick = endTime_Quick - startTime_Quick;
        System.out.println("------------------------------");
		System.out.println("Time it took to complete QUICK SORT: " +finaTime_Quick + " Milliseconds");
        
        System.out.println();

    }
}