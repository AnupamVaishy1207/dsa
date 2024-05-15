package com.sunbeam;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
	public static class Entry{
		private int key;
		private String value;
		public Entry() {
			key = 0;
			value = "";
		}
		public Entry(int k, String v) {
			key = k;
			value = v;
		}
	}
	
	private List<Entry> arr[];
	private final int SIZE;
	
	public HashTable(int size) {
		SIZE = size;
		arr = new List [SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			arr[i] = new LinkedList<HashTable.Entry>();
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public void put(int k, String v) {
		//1. find slot for given key
		int slot = h(k);
		
		//2. if key is already exist then update its value
		if(!arr[slot].isEmpty()) {
			for(Entry e : arr[slot]) {
				if(e.key == k) {
					e.value = v;
					return;
				}
			}
		}
		
		//3. create an entry for given key and value
		Entry e = new Entry(k, v);
		//4. add entry into ln=inked list of slot
		arr[slot].add(e);
	}
	
	public String get(int k) {
		//1. find slot for given key
		int slot = h(k);
		
		//2. if key is already exist then update its value
		if(!arr[slot].isEmpty()) {
			for(Entry e : arr[slot]) {
				if(e.key == k) {
					return e.value;
				}
			}
		}
		//3. key is not found
		return null;
	}
	
	
	
}







