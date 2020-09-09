package algorithms.implementations;

public class Sort{

	public static void bubbleSort(int[] array) {
		int idxOfLastUnsorted = array.length - 1;
		int counter = 0;
		
		while(idxOfLastUnsorted > 0) {
			while((counter + 1) < array.length) {
				if(array[counter] > array[counter+1]) {
					swap(counter, counter + 1, array);
				}
				
				counter++;
			}
			
			idxOfLastUnsorted--;
			counter = 0;
		}
	}
	
	public static void selectionSort(int[] array) {
		int pointer = 0;
		int counter = pointer + 1;
		
		while(pointer < array.length) {
			int smallestValueIndex = pointer;

			while(counter < array.length) {
				if(array[smallestValueIndex] > array[counter]) {
					smallestValueIndex = counter;
				}
				
				counter++;
			}
			
			if(smallestValueIndex != pointer) {
				swap(smallestValueIndex, pointer, array);
			}
			
			pointer++;
			counter = pointer +1;
		}
	}
	
	public static void insertionSort(int[] array) {
		int pointer = 0;
		int counter = pointer;
		
		while(pointer < array.length) {
			while((counter - 1) >= 0) {
				if(array[counter] < array[counter -1]) {
					swap(counter, counter - 1, array);
				}

				counter--;
			}
			
			pointer++;
			counter = pointer;
		}
	}
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	
	
	private static void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int partition = quickSortPartition(array, low, high);
			
			quickSort(array, low, partition - 1);
			quickSort(array, partition + 1, high);
		}
	}

	private static int quickSortPartition(int[] array, int start, int end) {
		int pointer = start;
		int counter = start + 1;
		int lessThanIdx = start;
		
		while(counter <= end) {
			if(array[counter] < array[pointer]) {
				swap(counter, lessThanIdx + 1, array);
				lessThanIdx++;
			}
			
			counter++;
		}

		swap(pointer, lessThanIdx, array);

		return lessThanIdx;
	}
	
	private static void swap(int i, int j, int[] array) {
		int val_i = array[i];
		int val_j = array[j];

		array[i] = val_j;
		array[j] = val_i;
	}
}
