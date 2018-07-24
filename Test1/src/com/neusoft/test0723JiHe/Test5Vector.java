package com.neusoft.test0723JiHe;

import java.util.Enumeration;
import java.util.Vector;

import com.sun.jmx.snmp.Enumerated;

public class Test5Vector {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		
		v.addElement("bbb");
		v.addElement("aaa");
		v.addElement("ccc");
		
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()){
			String s = e.nextElement();
			System.out.println(s);
		}
		
		
	}
}
