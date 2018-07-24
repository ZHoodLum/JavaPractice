package com.neusoft.test0723JiHe;

import java.util.Iterator;
import java.util.TreeSet;

public class Test7treeset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 无序  输入顺序与输出顺序不同  所以无序  不可重复  输出的时候 顺序已经排列好 
		 * 存放顺序按照红黑数存放的 是一种树状结构
		 * 
		 *  树状结构  
		 */
		
		/**
		 * 红黑树性质：
		 * 节点颜色是红、黑色
		 * 根节点是黑色的
		 * 每个叶节点（NIL节点，空节点）是黑色的
		 * 每个红色节点的两个子节点都是黑色的（从每个叶子到根的所有路径不能有两个连续的红色节点）
		 * 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
		 * 
		 */
		TreeSet t = new TreeSet();
				
		t.add(2);
		t.add(22);
		t.add(23);
		t.add(28);
		t.add(92);
		
		Iterator i = t.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
