package com.sunbeam;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable tbl = new HashTable(10);
		
		tbl.put(8, "v1");
		tbl.put(3, "v2");
		tbl.put(10, "v3");
		tbl.put(4, "v4");
		tbl.put(6, "v5");
		tbl.put(13, "v6");
		tbl.put(6, "updated");
		
		String value = tbl.get(13);
		if(value == null)
			System.out.println("key is not found");
		else
			System.out.println("key is found value = " + value);
	}

}
