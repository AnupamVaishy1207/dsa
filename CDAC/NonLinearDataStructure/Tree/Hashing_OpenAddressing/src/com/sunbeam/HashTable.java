package com.sunbeam;

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
	
	private Entry arr[];
	private final int SIZE;
	public HashTable(int size) {
		SIZE = size;
		arr = new Entry[SIZE];
	}
	
	public int h(int k) {
		return k % SIZE;
	}
	
	public int h(int k, int i) {
		return h(k) + i; 
	}
	
	public void put(int k, String v) {
		//1. find slot for given key
		int slot = h(k);
		int i = 1;
		
		//2. find free slot if collision will occur
		while(arr[slot] != null) {
			//2.1 check if key already exist
			if(arr[slot].key == k) {
				//2.2 update value of slot
				arr[slot].value = v;
				return;
			}
			slot = h(k, i++);
		}
		
		//3. create an entry of key and value
		Entry e = new Entry(k, v);
		//4. add entry into hash table
		arr[slot] = e;
	}
	
	public String get(int k) {
		//1. find slot corresponding to given key
		int slot = h(k);
		int i = 1;
		
		//2. check if slot is not empty
		while(arr[slot] != null) {
			// 2.1 check for key
			if(arr[slot].key == k) {
				return arr[slot].value;
			}
			//2.2 find next free slot (probing)
			slot = h(k, i++);
		}
		//3. if key is not found
		return null;
	}
	
}














