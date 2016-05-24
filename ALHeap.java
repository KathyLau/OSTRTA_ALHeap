/*
Team One System To Rule Them All -- Kathy Lau, Calvin Vuong, Ruochong Wu
APCS2 PD10
HW43 -- Heap of Trouble
2016-05-23
*/

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() {
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() {
	String retStr = "";
	for ( Integer i : _heap )
	    retStr += i + " ";
	return retStr;
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() {
	return _heap.isEmpty();
} //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() {
    if (_heap.size() < 1) return null;
    else return _heap.get(0); // first element of the array is root, aka min
    } //O(1)



    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) {
	int index = _heap.size();
	_heap.add(addVal); // put new element at the end
	// swap element with parent if parent > addval
	while ( ((index-1) / 2) >= 0 && ( _heap.get((index-1) / 2) > addVal ) ) {
	    swap( index, (index-1) / 2 );
	    index = (index-1) / 2;
	}
} //O(logn)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() {
        if (_heap.size()==0)
          return null;

      	Integer ret = peekMin(); //root
        Integer end = _heap.get(_heap.size() - 1); //rightmost bottom node
        swap( 0, _heap.size() - 1 ); //place rightmost bottom node at root
        _heap.remove( _heap.size() - 1); //remove node easily

        int pos = 0;
        int minPos; //holder for minChildPos

        while (pos < _heap.size()) {
          minPos = minChildPos(pos);
          if (minPos == -1) break;
          else if (end.compareTo(_heap.get(minPos))<= 0) break;
          else {
            swap(pos, minPos);
            pos = minPos;
          }
        }
      	return ret;

    }//O(logN)

    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) {
      int leftChild = 2*pos + 1;
      int rightChild = 2*pos +2;

      //out of bounds
      if (pos < 0 || pos >= _heap.size() || leftChild>= _heap.size())
        return -1;

        //if no right child
      else if ((rightChild >= _heap.size()) || (_heap.get(leftChild).compareTo(_heap.get(rightChild))<0 ) )
        return leftChild;
      else
        return rightChild;

}//O(1)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {



	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	/*--V--------------MOVE ME DOWN------------------V---
	  ==|============================================|===*/

    }//end main()

}//end class ALHeap
