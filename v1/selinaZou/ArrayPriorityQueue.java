//Boss Zou
//APCS2 pd01
//HW46
//2018-05-09

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{
    
    private ArrayList<String> bigBoy = new ArrayList<String>();
    
    public boolean isEmpty() {
	return bigBoy.size() == 0;
    }
    
    public void add(String newItem) {
	bigBoy.add(newItem);
    }
    
    public String removeMin() {
	int index = 0;
	int place = 0;
	String firstElement = bigBoy.get(0);
	for(String bean : bigBoy)//haha String bean
	    {
		if(bean.compareTo(firstElement) < 0) {
		    firstElement = bean;
		    index = place;
		}
		place++;
	    }
	
	return bigBoy.remove(index);
    }
    
    public String peekMin() {
	String firstElement = bigBoy.get(0);
	for(String bean : bigBoy) {
	    if(bean.compareTo(firstElement) < 0) {
		firstElement = bean;
	    }
	}
	return firstElement;
    }
    
    //main for testering 
    public static void main(String[] args){
	PriorityQueue test = new ArrayPriorityQueue();
	
	//testering isEmpty
	System.out.println("Is empty? " + test.isEmpty()); //true
	
	//testering add
	test.add("foo");
	test.add("goo");
	test.add("boo");
	test.add("hoo");
	test.add("doo");
	
	//testering isEmpty
	System.out.println("Is empty? " + test.isEmpty()); //false
	System.out.println(test.peekMin()); //boo
	System.out.println(test.removeMin());
	System.out.println(test.peekMin()); //doo
	System.out.println(test.removeMin());
    }	
}
	    
