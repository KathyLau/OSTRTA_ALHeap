/*
Team One System To Rule Them All -- Kathy Lau, Calvin Vuong, Ruochong Wu
APCS2 PD10
HW44 -- Sort of Like Magic
2016-05-24
*/

/*~~~~~~~~~~~~~~~~~~~~Algorithm~~~~~~~~~~~~~~~~~~~~~~~~
HeapSort:
1. Convert ArrayList into Heap.
2. Traverse through the Array, with elements already traversed making up the sorted area and the remaining elements making up the heap. 
   The element currently being traversed is the root.
3. For each iteration: Continuosly swap the minChild of the root with minChild's left neighbor until it is next to the root.
4. Continue iteration, with minChild as the new root.

Heapify:
1. Traverse through the array, starting with the second element.
2. For each element: Compare element with the element's "parent" ((index-1)/2), if element is smaller than parent, swap with parent.
   Continue comparing element to parent and swap until either element becomes root or element is greater than parent.
3. Traverse to next element, repeat until end of AL list reached.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
import java.util.ArrayList;

public class HeapSort{
    
    // sorts ArrayList arr using heapsort
    public static void sort( ArrayList<Integer> arr ) {
	heapify( arr );
	for ( int i = 0; i < arr.size(); i++ ) {
	    int childPos = minChildPos( arr, i );
	    
	    if ( childPos == -1 )
		return; // done with sorting
	    
	    while ( childPos-1 >= 0 && arr.get(childPos-1) > arr.get(childPos) ) {
		swap( arr, childPos, childPos-1 );
		childPos -= 1;
	    }
	}
    }


    // takes an ArrayList of Integers and re-arranges elements so that the array represents a heap
    private static void heapify( ArrayList<Integer> a ) {
	for( int i=1; i< a.size(); i++ ) {
	    int valPos = i;
	    while( valPos > 0 ) {
		int parentPos = (valPos-1) / 2;
		if ( a.get(valPos) < a.get(parentPos) ) {
    		    swap( a, valPos, parentPos );
    		    valPos = parentPos;}
    		else break;
    	    }
        }
    }
    

    // precond: ArrayList a represents a heap
    // returns index of smallest child of the element in position pos of ArrayList a
    private static int minChildPos( ArrayList<Integer> a, int pos ) {
	int leftChild = 2*pos + 1;
	int rightChild = 2*pos +2;
	
	//out of bounds
	if (pos < 0 || pos >= a.size() || leftChild>= a.size())
	    return -1;
	
        //if no right child
	else if ((rightChild >= a.size()) || (a.get(leftChild).compareTo(a.get(rightChild))<0 ) )
	    return leftChild;
	else
	    return rightChild;
    }//O(1)


    // swaps elements in positions 1 and 2, in ArrayList a
    private static void swap( ArrayList a, int pos1, int pos2 ) {
	a.set( pos1, a.set( pos2, a.get(pos1) ) );
    }
    

    public static void main(String[] args) {
	// test 1
	ArrayList<Integer> simple = new ArrayList();
	simple.add(3);
	simple.add(6);
	simple.add(7);
	simple.add(4);
	simple.add(2);
	simple.add(9);
	
	System.out.println("simple: ");
	System.out.println(simple);
	
	System.out.println("Heapified simple: ");
	HeapSort.heapify(simple);
	System.out.println(simple);
	
	System.out.println("Sorted simple: ");
	HeapSort.sort(simple);
	System.out.println(simple);
	System.out.println();

	// test 2
	ArrayList<Integer> complex = new ArrayList();
	complex.add(3);
	complex.add(9);
	complex.add(0);
	complex.add(-1);
	complex.add(23);
	complex.add(5);
	complex.add(7);
	complex.add(2);
	complex.add(1);
	complex.add(8);
	complex.add(4);

	System.out.println("complex: ");
	System.out.println(complex);
	
	System.out.println("Heapified complex: ");
	HeapSort.heapify(complex);
	System.out.println(complex);
	
	System.out.println("Sorted complex: ");
	HeapSort.sort(complex);
	System.out.println(complex);
    }

}
