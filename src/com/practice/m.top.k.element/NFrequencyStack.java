package com.practice.m.top.k.element;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
	
	class Element{
		int number;
		int frequency;
		int sequence;
		
		public Element(int number, int frequency, int sequence){  // constructor
			this.number = number;
			this.frequency = frequency;
			this.sequence = sequence;
		}
	}
	
	class ElementComparator implements Comparator<Element>{
		
		public int compare(Element o1, Element o2) {  // Add compare method

			if(o1.frequency != o2.frequency) {
				return o2.frequency - o1.frequency; // return number with greater frequency
			}
			return o2.sequence - o1.sequence; //if frequency is same return number with greater sequence as its the latest
		}
		
	}
	
	public class NFrequencyStack {
		
		// HashMap will keep the frequency count of everynumber when we do push operation
		// when we pop we will dcrement the frequency when we pop
		// we will keep three things with every number that we push to the heap:
		// i/p number, frequency and sequence number
		
		int sequenceNum = 0;
		//implement stack using priority Queue
		PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		
	public void Push(int num) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);  // keep track of freq of each num in freqMap
			maxHeap.add(new Element(num, freqMap.get(num), +1));
		}
		
	public int pop() {
		int num  = maxHeap.poll().number; // extract the number
		
		if(freqMap.get(num) > 1) {  //  if freq of num is greater than 1
			freqMap.put(num, freqMap.get(num) - 1); // decrease the freq by 1 and add to the Map
		}else {
			freqMap.remove(num);  // if the freq of num is <= 1 remove the element from freqMap
		}
		return num;
	}
	

	public static void main(String[] args) {

		NFrequencyStack freqStack = new NFrequencyStack();
		
		freqStack.Push(1);
		freqStack.Push(2);
		freqStack.Push(3);
		freqStack.Push(2);
		freqStack.Push(1);
		freqStack.Push(2);
		freqStack.Push(5);
		freqStack.Push(8);
		freqStack.Push(7);

		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
	}

}
