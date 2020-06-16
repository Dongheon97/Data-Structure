
public class QuickSort<E extends Comparable<E>> extends Sort<E> {

	//Constructor
	public QuickSort() {
		
	}
	
	//private method
	private int pivot(E[] aList, int left, int right) {
		return left;
	}
	
	private int partition(E[] aList, int left, int right) {
		int pivot = this.pivot(aList, left, right);
		int toRight = left;
		int toLeft = right + 1;
		do {
			do {
				toRight ++;
			}while(aList[toRight].compareTo(aList[pivot])<0);
		
			do {
				toLeft --;
			}while(aList[toLeft].compareTo(aList[pivot])>0);
			
			if(toRight < toLeft) {
				this.swap(aList, toRight, toLeft);
			}
		}while(toRight<toLeft);
		
		this.swap(aList, pivot, toLeft);
		//pivot과 toLeft의 위치의 원소를 맞바꾼다.
		
		return toLeft;
		//파티션 후의 pivot위치
	}
	
	private void quickSortRecursively(E[]aList, int left, int right) {
		if(left < right) {
			//partition
			//pivot의 왼쪽에는 pivot의 key값 보다 작은 원소들이 오게 한다.
			//pivot의 오른쪽에는  pivot의 key값 보다 큰 원소들이 오게 한다.
			
			int mid = this.partition(aList, left, right);
			
			this.quickSortRecursively(aList, left, mid-1);
			this.quickSortRecursively(aList, mid+1, right);
		}
	}

	@Override
	public boolean sort(E[] aList, int aSize) {
		if( (aSize<1) || (aSize>aList.length)) {
			return false;
		}
		int maxLoc = 0;
		for(int i=1; i<aSize; i++) {
			if(aList[i].compareTo(aList[maxLoc])>0) {
				maxLoc = i;
			}
		}
		this.swap(aList, maxLoc, aSize-1);
		
		this.quickSortRecursively(aList, 0, aSize-2);
		return true;
	}
}//End of Sort
