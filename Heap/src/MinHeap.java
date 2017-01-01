
public class MinHeap {
    private final int DEFAULT_MAX_LENGTH = 100;
    private int[] heapArray;
    private int rootIndex = -1;
    private int endIndex = -1;

    MinHeap() {
	heapArray = new int[DEFAULT_MAX_LENGTH];
    }

    MinHeap(int[] array) {
	heapArray = new int[array.length];
	for (int i = 0; i < array.length; ++i) {
	    insert(array[i]);
	}
	rootIndex = 0;
	endIndex = array.length - 1;
    }

    public boolean isEmpty() {
	if (rootIndex == -1) {
	    return true;
	} else {
	    return false;
	}
    }

    public int size() {
	return (endIndex + 1);
    }

    public int findMin() {
	return heapArray[rootIndex];
    }

    public void insert(int key) {
	if (rootIndex == -1) {
	    // Empty
	    heapArray[0] = key;
	    rootIndex = 0;
	    endIndex = 0;
	} else if (this.size() == heapArray.length) {
	    // Not empty AND full
	    // Do nothing.
	} else {
	    // Not empty AND not full
	    // Insert the key into the end.
	    heapArray[endIndex + 1] = key;
	    ++endIndex;
	    // Find the proper place of `key`.
	    int currentIndex = endIndex;
	    int parentIndex = getParentIndex(currentIndex);;
	    while (true) {
		if (currentIndex == rootIndex) {
		    // The current node is the root node. Then, it doesn't have its parent.
		    break;
		} else if (preserveHeapProperty(currentIndex, parentIndex)) {
		    // The current node is not the root node. Then, it has its parent.
		    // The current node and its parent node preserve the heap property.
		    break;
		} else {
		    // The current node is not the root node. Then, it has its parent.
		    // The current node and its parent node don't preserve the heap property.
		    // Swap the two nodes.
		    swap(currentIndex, parentIndex);
		    currentIndex = parentIndex;
		    parentIndex = getParentIndex(currentIndex);
		}
	    }
	}
    }

    public void deleteMin() {
	// 1. Delete the maximum at the root node.
	// Move the end node to the root node.
	heapArray[rootIndex] = heapArray[endIndex];
	--endIndex;
	int currentIndex = rootIndex;
	int leftChildIndex, rightChildIndex;
	while (true) {
	    leftChildIndex = getLeftChildIndex(currentIndex);
	    rightChildIndex = getRightChildIndex(currentIndex);
	    // 2. Check the child nodes.
	    if (leftChildIndex > endIndex) {
		// The left child doesn't exist.
		// Then, the right child also doesn't exist.
		// The current node preserves the heap property.
		break;
	    } else if (!preserveHeapProperty(leftChildIndex, currentIndex)) {
		// The left child exists.
		// The heap property between the current node and left child node is not preserved. 
		// Then, swap the two nodes!
		swap(currentIndex, leftChildIndex);
		currentIndex = leftChildIndex;
	    } else if (rightChildIndex > endIndex) {
		// The left child exists.
		// The heap property between the current node and left child node is preserved. 
		// The right child doesn't exist.
		// The current node preserves the heap property.
		// Then, end the loop.
		break;
	    } else if (!preserveHeapProperty(rightChildIndex, currentIndex)) {
		// The left child exists.
		// The heap property between the current node and left child node is preserved. 
		// The right child exists.
		// The heap property between the current node and right child node is not preserved. 
		// Then, swap the two nodes!
		swap(currentIndex, rightChildIndex);
		currentIndex = rightChildIndex;
	    } else {
		// The left child exists.
		// The heap property between the current node and left child node is preserved. 
		// The right child exists.
		// The heap property between the current node and right child node is preserved. 
		// Then, end the loop.
		break;
	    }
	}
    }

    // Internal methods ========================================

    private int getLevelOf(int index) {
	int countNodes = 0; // count nodes to a particular level.
	int level = -1; // the particular level
	while (countNodes <= index + 1) {
	    countNodes = countNodes * 2 + 1;
	    ++level;
	}
	return level;
    }

    private int getIndexAtOwnLevel(int globalIndex) {
	// Local index start with 0 to pow(2, level)-1.
	int level = getLevelOf(globalIndex);
	return (globalIndex + 1) - ((int) Math.pow(2, level) - 1) - 1;
    }

    private int getGlobalIndex(int indexAtOwnLevel, int level) {
	return (indexAtOwnLevel + 1) + ((int) Math.pow(2, level) - 1) - 1;
    }

    private int getParentIndex(int index) {
	int level = getLevelOf(index);
	if (level == 0) {
	    return -1; // No parent.
	}
	int indexAtOwnLevel = getIndexAtOwnLevel(index);
	int parentIndexAtOwnLevel = indexAtOwnLevel / 2;
	int parentLevel = level - 1;
	int parentIndex = getGlobalIndex(parentIndexAtOwnLevel, parentLevel);
	return parentIndex;
    }

    private int getLeftChildIndex(int index) {
	int level = getLevelOf(index);
	int indexAtOwnLevel = getIndexAtOwnLevel(index);
	int leftChildIndexAtOwnLevel = 2 * indexAtOwnLevel;
	int leftChildIndex = ((int) Math.pow(2, level + 1) - 1) + leftChildIndexAtOwnLevel;
	return leftChildIndex;
    }

    private int getRightChildIndex(int index) {
	int level = getLevelOf(index);
	int indexAtOwnLevel = getIndexAtOwnLevel(index);
	int rightChildIndexAtOwnLevel = 2 * indexAtOwnLevel + 1;
	int rightChildIndex = ((int) Math.pow(2, level + 1) - 1) + rightChildIndexAtOwnLevel;
	return rightChildIndex;
    }
    
    private void swap(int index1, int index2) {
	int temp = heapArray[index1];
	heapArray[index1] = heapArray[index2];
	heapArray[index2] = temp;
    }
    
    private boolean preserveHeapProperty(int index, int parentIndex) {
	// Max-heap case. <=
	// Min-heap case. >=
	if (heapArray[index] >= heapArray[parentIndex]) {
	    return true;
	} else {
	    return false;
	}
    }
}