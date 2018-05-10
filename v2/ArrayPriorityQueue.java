//Wenting Li
//APCS2 pd1
//HW #46: Arrr, There Be Priorities Here Matey
//2018-05-10 R
import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

  private ArrayList<String> _queue;

  public ArrayPriorityQueue(){
    _queue = new ArrayList<String>();
  }


  //O(1) - amortized constant time
  //utilizes the .add() method of arraylist
  public void add(String s){
    _queue.add(s);
  }


  //O(1)
  //true if empty, false if not
  public boolean isEmpty(){
    return _queue.isEmpty();
  }


  //O(n)
  //Peek into smallest item in _queue
  public String peekMin(){
    String firstElement = _queue.get(0);
    for (String bean : _queue) {
      if (bean.compareTo(firstElement) < 0)
        firstElement = bean;
    }
    return firstElement;
  }


  //O(n)
  //peekMin() and then removes the min from _queue
  public String removeMin(){
    return _queue.remove( _queue.indexOf( peekMin() ) );
  }

  public String toString(){
    return _queue.toString();
  }

  public static void main(String[] args){

    ArrayPriorityQueue test = new ArrayPriorityQueue();
    test.add("I");
    test.add("still");
    test.add("hate");
    test.add("pigeons");

    System.out.println("Priority Queue: " + test);
    System.out.println("Min: "  + test.peekMin());
    test.removeMin();
    System.out.println("Priority Queue: " + test); //[moo]



  }

} //end class
