/*
Team One System To Rule Them All -- Kathy Lau, Calvin Vuong, Ruochong Wu
APCS2 PD10
HW44 -- Sort of Like Magic
2016-05-24
*/
import java.util.ArrayList;
public class HeapSort{

    // swaps elements in positions 1 and 2, in ArrayList a
    private static void swap( ArrayList a, int pos1, int pos2 ) {
	a.set( pos1, a.set( pos2, a.get(pos1) ) );
    }

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

    public static void main(String[] args){
	ArrayList<Integer> test = new ArrayList();
	test.add(3);
	test.add(6);
	test.add(7);
	test.add(4);
	test.add(2);
	test.add(9);
	heapify(test);
  System.out.println(test);
    }

}
