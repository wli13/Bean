//Team Bean - Selina Zou, Wenting Li, Stefan Tan
//APCS2 pd1
//HW49 -- Sink || Swim
//2018-05-15

/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

    //instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    {
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString() 
    {
	String retStr = "";
	for (Integer i : _heap)
	    retStr += i + " ";
	return retStr; 
    }//O(n)
    

    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return (_heap.size() == 0);
    }//O(1)
    

    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()
    {
	return _heap.get(0); 
    }//O(1)


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     Algorithm:
     1. Add new element at the end of the ArrayList.
     2. Compare the element with the parent. If parent is greater then swap.
     3. Repeat step 2 until parent is less than the element or the element 
     becomes the root.
    *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal);
	int n = _heap.size() - 1;
	int parent = n / 2;
	while (parent != n && _heap.get(n) < _heap.get(parent)){
	    swap(n, parent);
	    n = parent;
	    parent = n/2;
	}
    }//O(1) amortized


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     Algorithm:
     1. Delete the element.
     2. Replace the deleted element with the last element in the ArrayList.
     3. If the replacement is greater than the smallest child then swap.
     4. Repeat step 3 until replacement is less than the smallest child or it
     becomes a leaf. 
    *****************************************************/
    public Integer removeMin()
    {
	if (isEmpty())
	    return null;
	if (_heap.size() == 1){
	    int min = _heap.remove(0);
	    return min;
	}
	int min = peekMin();
	_heap.set(0, _heap.get(_heap.size() - 1));
	_heap.remove(_heap.size() - 1);
	int pos = 0;
	while (minChildPos(pos) != -1 && _heap.get(pos) > _heap.get(minChildPos(pos))){
	    swap(pos, minChildPos(pos));
	    pos = minChildPos(pos);
	}
	return min;
    }//O(log n)


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    {
	if (pos >= _heap.size() || 2*pos + 1 >= _heap.size()  || 2*pos + 2 >= _heap.size())
	    return -1;
	return minOf(_heap.get(2*pos + 1), _heap.get(2*pos + 2));
    }//O(1)
  

    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {
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
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeap
