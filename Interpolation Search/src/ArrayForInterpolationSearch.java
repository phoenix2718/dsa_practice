
public class ArrayForInterpolationSearch {
    private int SIZE = 10;
    // For this algorithm to work properly,
    // the data collection should be in sorted and equally distributed form.
    private int[] array = new int[SIZE];
    private int comparisions = 0;;

    ArrayForInterpolationSearch() {
	for (int i = 0; i < SIZE; ++i) {
	    array[i] = i * 5;
	}
    }
    
    ArrayForInterpolationSearch(int[] array) {
	for (int i = 0; i < SIZE; ++i) {
	    this.array[i] = array[i];
	}
    }
    
    public int get(int index) {
	return array[index];
    }
    
    public void set(int index, int value) {
	array[index] = value;
    }
    
    public int interpolationSearch(int target) {
	int targetIndex = -1;
	int lowerIndex = 0;
	int upperIndex = SIZE - 1;
	int middleIndex = -1;
	comparisions = 0;

	while (lowerIndex <= upperIndex) {
	    // Different part from binary search
	    middleIndex = lowerIndex + (int) ((double) (upperIndex - lowerIndex)
		    / (array[upperIndex] - array[lowerIndex]) * (target - array[lowerIndex]));

	    ++comparisions;
	    if (array[middleIndex] == target) {
		break;

	    } else if (array[middleIndex] < target) {
		lowerIndex = middleIndex;

	    } else { // array[middleIndex] > target
		upperIndex = middleIndex;

	    }
	}
	return targetIndex; // -1 means the null index. No target in the array.
    }

    public int binarySearch(int target) {
	int targetIndex = -1;
	int lowerIndex = 0;
	int upperIndex = SIZE - 1;
	int middleIndex = -1;
	comparisions = 0;

	while (lowerIndex <= upperIndex) {

	    middleIndex = (upperIndex + lowerIndex) / 2; // Different part from
							 // interpolation search

	    ++comparisions;
	    if (array[middleIndex] == target) { // comparision unit. 
		break;

	    } else if (array[middleIndex] < target) {

		if (lowerIndex != middleIndex) {
		    lowerIndex = middleIndex;
		} else {
		    // lowerIndex == middleIndex
		    // Then, lowerIndex + 1 == upperIndex
		    ++lowerIndex;
		}
	    } else { // array[middleIndex] > target
		upperIndex = middleIndex;
	    }
	}
	return targetIndex; // -1 means the null index. No target in the array.
    }

    public void printArray() {
	String strArray = "{";
	for (int i = 0; i < SIZE - 1; ++i) {
	    strArray = strArray + array[i] + ", ";
	}
	strArray = strArray + array[SIZE - 1] + "}";
	System.out.println(strArray);
    }

    public void printComparisions() {
	System.out.println("Comparisions: " + comparisions);
    }
}
