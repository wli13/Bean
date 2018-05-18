//Bean - Selina Zou, Wenting Li, Stefan Tan
//APCS2 pd01
//HW50 -- Run Run Run
//2018-05-17

/*
Algorithm:
1. if next value < root of maxheap, add to maxheap.
       else add to minheap
2. balance heaps (size difference <2): 
       (remove from larger heap, add to smaller until balanced)
3. at any time, find med by
       a) heap sizes equal: med is a mean of roots
       b) heap sized !equal: med is root of larger heap
 */

import java.util.NoSuchElementException;

public class RunMed{

    private ALHeapMin lilVals;
    private ALHeapMax bigVals;

    //default constructor
    public RunMed(){
	lilVals = new ALHeapMin();
	bigVals = new ALHeapMax();
    }

    public int getMedian(){
	if (lilVals.isEmpty() && bigVals.isEmpty())
	    throw new NoSuchElementException();
	if (lilVals.size() == bigVals.size())
	    return (lilVals.peekMin() + bigVals.peekMax())/2;
	else{
	    return bigVals.peekMax();
	}
    }//end getMedian()

    public void add (Integer newVal){
	if (bigVals.size() == 0)
	    bigVals.add(newVal);
	if (lilVals.size() == 0)
	    lilVals.add(newVal);
	if (newVal < bigVals.peekMax())
	    bigVals.add(newVal);
	else{
	    lilVals.add(newVal);
	}
	while (bigVals.size() - lilVals.size() > 1){
	    int balance = bigVals.removeMax();
	    lilVals.add(balance);
	}
	while (lilVals.size() - bigVals.size() > 1){
	    int balance = lilVals.removeMin();
	    bigVals.add(balance);
	}   
    }//end add

}//end class
