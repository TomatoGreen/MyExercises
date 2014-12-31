package my.concurrent;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class TestConcurrentNavigableMap {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			ConcurrentNavigableMap<String, String> map = new ConcurrentSkipListMap<String, String>();
			map.put("1", "one");
			map.put("2", "two");
			map.put("3", "three");
			
			ConcurrentNavigableMap<String, String> headMap = map.headMap("2");
			headMap.put("0", "zero");
			Iterator<Entry<String, String>> headMapIterator = headMap.entrySet().iterator();
			while(headMapIterator.hasNext()){
				System.out.println("headMap: " + headMapIterator.next());
			}//0=zero,1=one
			
			Iterator<Entry<String, String>> mapIterator = map.entrySet().iterator();
			while(mapIterator.hasNext()){
				System.out.println("map: " + mapIterator.next());
			}//0=zero,1=one,2=two,3=three
			
			//headMap.put("4", "four");//java.lang.IllegalArgumentException: key out of range
			headMap.remove("0");
			
			ConcurrentNavigableMap<String, String> tailMap = map.tailMap("2");
			
			map.put("4", "four");
			
			Iterator<Entry<String, String>> tailMapIterator = tailMap.entrySet().iterator();
			while(tailMapIterator.hasNext()){
				System.out.println("tailMap: " + tailMapIterator.next());
			}//2=two,3=three, 4=four
			
			mapIterator = map.entrySet().iterator();
			while(mapIterator.hasNext()){
				System.out.println("map again: " + mapIterator.next());
			}//1=one, 2=two,3=three, 4=four
			
			//tailMap.put("0", "zero");//java.lang.IllegalArgumentException: key out of range
			tailMap.put("2", "twoSecond");//the key is existing, update value only
			tailMap.put("5", "five");//allow to put greater key-value entry
			
			ConcurrentNavigableMap<String, String> subMap = map.subMap("1", "3");
			Iterator<Entry<String, String>> subMapIterator = subMap.entrySet().iterator();
			while(subMapIterator.hasNext()){
				System.out.println("subMap: " + subMapIterator.next());
			}//1=one, 2=twoSecond
			
			//subMap.put("6","six");//java.lang.IllegalArgumentException: key out of range
			//subMap.put("3", "threeThird");//java.lang.IllegalArgumentException: key out of range
			//subMap.put("0", "zero");//java.lang.IllegalArgumentException: key out of range
			subMap.put("1", "oneFirst");
			mapIterator = map.entrySet().iterator();
			while(mapIterator.hasNext()){
				System.out.println("map third time: " + mapIterator.next());
			}//1=oneFirst, 2=twoSecond,3=three, 4=four, 5=five
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
