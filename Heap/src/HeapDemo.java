
public class HeapDemo {

    public static void main(String[] args) {
	
	// Test: MaxHeap
	System.out.println("========== Test: MaxHeap ==========");
	
	MaxHeap heap = new MaxHeap(new int[]{110, 60, 130, 145, 120});
	
	System.out.println("MaxHeap heap = new MaxHeap(new int[]{110, 60, 130, 145, 120});");
	System.out.println("heap.size(): " + heap.size());
	System.out.println("heap.findMax(): " + heap.findMax());
	
	heap.deleteMax();
	System.out.println("heap.deleteMax();");
	System.out.println("heap.size(): " + heap.size());
	System.out.println("heap.findMax(): " + heap.findMax());
	
	MaxHeap heap2 = new MaxHeap();
	System.out.println("MaxHeap heap2 = new MaxHeap();");
	System.out.println("heap2.size(): " + heap2.size());
	
	heap2.insert(0);
	System.out.println("heap2.insert(0);");
	System.out.println("heap2.size(): " + heap2.size());
	System.out.println("heap2.findMax(): " + heap2.findMax());
	
	heap2.deleteMax();
	System.out.println("heap2.deleteMax();");
	System.out.println("heap2.size(): " + heap2.size());
	
	heap2.insert(0);
	heap2.insert(1);
	heap2.insert(2);
	System.out.println("heap2.insert(0);");
	System.out.println("heap2.insert(1);");
	System.out.println("heap2.insert(2);");
	System.out.println("heap2.size(): " + heap2.size());
	System.out.println("heap2.findMax(): " + heap2.findMax());

	heap2.deleteMax();
	System.out.println("heap2.deleteMax();");
	System.out.println("heap2.size(): " + heap2.size());
	System.out.println("heap2.findMax(): " + heap2.findMax());

	heap2.deleteMax();
	System.out.println("heap2.deleteMax();");
	System.out.println("heap2.size(): " + heap2.size());
	System.out.println("heap2.findMax(): " + heap2.findMax());
	
	heap2.deleteMax();
	System.out.println("heap2.deleteMax();");
	System.out.println("heap2.size(): " + heap2.size());
	
	// Test: MinHeap
	System.out.println("========== Test: MinHeap ==========");
	
	MinHeap heap3 = new MinHeap(new int[]{110, 60, 130, 145, 120});
	
	System.out.println("MinHeap heap3 = new MinHeap(new int[]{110, 60, 130, 145, 120});");
	System.out.println("heap3.size(): " + heap3.size());
	System.out.println("heap3.findMin(): " + heap3.findMin());
	
	heap3.deleteMin();
	System.out.println("heap3.deleteMin();");
	System.out.println("heap3.size(): " + heap3.size());
	System.out.println("heap3.findMin(): " + heap3.findMin());
	
	MinHeap heap4 = new MinHeap();
	System.out.println("MinHeap heap4 = new MinHeap();");
	System.out.println("heap4.size(): " + heap4.size());
	
	heap4.insert(0);
	System.out.println("heap4.insert(0);");
	System.out.println("heap4.size(): " + heap4.size());
	System.out.println("heap4.findMin(): " + heap4.findMin());
	
	heap4.deleteMin();
	System.out.println("heap4.deleteMin();");
	System.out.println("heap2.size(): " + heap2.size());
	
	heap4.insert(0);
	heap4.insert(1);
	heap4.insert(2);
	System.out.println("heap4.insert(0);");
	System.out.println("heap4.insert(1);");
	System.out.println("heap4.insert(2);");
	System.out.println("heap4.size(): " + heap4.size());
	System.out.println("heap4.findMin(): " + heap4.findMin());

	heap4.deleteMin();
	System.out.println("heap4.deleteMin();");
	System.out.println("heap4.size(): " + heap4.size());
	System.out.println("heap4.findMin(): " + heap4.findMin());

	heap4.deleteMin();
	System.out.println("heap4.deleteMin();");
	System.out.println("heap4.size(): " + heap4.size());
	System.out.println("heap4.findMin(): " + heap4.findMin());
	
	heap4.deleteMin();
	System.out.println("heap4.deleteMin();");
	System.out.println("heap4.size(): " + heap4.size());	
    }

}