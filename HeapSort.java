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

    public static ArrayList<Integer> Heapify(ArrayList<Integer> a){
	for (int count = 0 ; count<a.size(); count++){
	    if (count*2+1 > a.size()-1){
	    }
	    else if (count*2+2 > a.size()-1){
		if (a.get(count*2+1)<a.get(count)){
		    swap(a, count, count*2+1);
		    count=-1;
		}
	    }
	    else if (a.get(count*2+1)<a.get(count*2+2) && a.get(count*2+1) < a.get(count)){
		swap(a, count, count*2+1);
		count=-1;
	    }
	    else if (a.get(count*2+2)<a.get(count*2+1) && a.get(count*2+2) < a.get(count)){
		swap(a, count, count*2+2);
		count=-1;
	    }
	}
	return a;
    }
    public static void main(String[] args){
	ArrayList<Integer> test = new ArrayList();
	test.add(3);
	test.add(6);
	test.add(7);
	test.add(4);
	test.add(2);
	test.add(9);
	System.out.println(Heapify(test));
    }
	
}
