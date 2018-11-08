package com.xkj.homework;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TestFCFS {

	public static void main(String[] args) {
		Comparator<Pcb> comparator = new Comparator<Pcb>() {

			@Override
			public int compare(Pcb o1, Pcb o2) {
				
				 /* 如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值， 
				 * 假如返回值为正，调换顺序 
				 * 假如返回值为负，什么也不做
				 * 这样颠倒一下，就可以实现降序排序了,反之即可自定义升序排序了
				 */
				return Double.compare(o1.getArrivalTime(), o2.getArrivalTime());
			}
		};
		TreeSet<Pcb> treeSet = new TreeSet(comparator);
		System.out.println("请输入作业(进程)个数：");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Pcb[] p = new Pcb[n];
		System.out.println("请分别输入每个进程的到达时间：");
		for(int i=0;i<n;i++) {
			double timeTemp = input.nextDouble();
			p[i] = new Pcb();
			p[i].setArrivalTime(timeTemp);
		}
		System.out.println("请分别输入每个进程的服务时间：");
		for(int i=0;i<n;i++) {
			double timeTemp = input.nextDouble();
			p[i].setServiceTime(timeTemp);
		}
		for(int i=0;i<n;i++) {
			treeSet.add(p[i]);
		}
		FCFS fcfs = new FCFS();
		fcfs.setTreeSet(treeSet);
		fcfs.fcfs();
		fcfs.show();
		fcfs.displayResult();
	}

}
