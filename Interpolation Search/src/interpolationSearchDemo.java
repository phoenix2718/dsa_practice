
public class interpolationSearchDemo {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ArrayForInterpolationSearch arr = new ArrayForInterpolationSearch();
	int target;

	arr.printArray();

	for (int i = 0; i < 10; ++i) {
	    System.out.println("====================");
	    
	    target = i * 5;
	    System.out.println("Target: " + target);
	    
	    arr.binarySearch(target);
	    arr.printComparisions();

	    arr.interpolationSearch(target);
	    arr.printComparisions();
	}
    }
}
