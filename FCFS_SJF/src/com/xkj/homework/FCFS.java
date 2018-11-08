package com.xkj.homework;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.TreeSet;

public class FCFS {
	TreeSet<Pcb> treeSet;

	public FCFS() {
		super();
	}

	public void setTreeSet(TreeSet<Pcb> treeSet) {
		this.treeSet = treeSet;
	}

	// 核心算法FCFS
	public void fcfs() {
		double timeTemp = 0;
		Iterator<Pcb> iterator = treeSet.iterator();

		while (iterator.hasNext()) {
			Pcb p = iterator.next();
			// 设置完成时间
			timeTemp += p.getServiceTime();
			p.setFinishTime(timeTemp);
			// 设置周转时间
			p.setTurnOverTime(p.getFinishTime() - p.getArrivalTime());
			// 设置带权周转时间
			p.setWeightedTurnOverTime(p.getTurnOverTime() / p.getServiceTime());
		}
	}

	// 显示用户输入数据
	public void show() {
		System.out.println("*************************************************");
		System.out.println("用户输入的进程个数：" + treeSet.size());
		System.out.println("用户输入的到达时间分别为：");
		Iterator<Pcb> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Pcb p = iterator.next();
			System.out.print(p.getArrivalTime()+"\t");
		}
		System.out.println();
		System.out.println("用户输入的服务时间分别为：");
		iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Pcb p = iterator.next();
			System.out.print(p.getServiceTime()+"\t");
		}
		System.out.println();
		System.out.println("*************************************************");
	}

	// 演示FCFS算法的结果
	public void displayResult() {
		System.out.println("*************************************************");
		System.out.println("进程相关信息如下所示：");
		System.out.println("进程名(ID)\t"
				+ "\t到达时间\t"
				+ "\t服务时间\t"
				+ "\t完成时间\t"
				+ "\t周转时间\t"
				+ "\t带权周转时间");
		double i = 1;
		Iterator<Pcb> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Pcb p = iterator.next();
			System.out.println(String.format("%9.2f", i) + "\t" 
					+ String.format("%15.2f", p.getArrivalTime()) + "\t"
					+ String.format("%15.2f", p.getServiceTime()) + "\t" 
					+ String.format("%15.2f", p.getFinishTime()) + "\t"
					+ String.format("%15.2f", p.getTurnOverTime()) + "\t" 
					+ String.format("%15.2f", p.getWeightedTurnOverTime()));
			i++;
		}
		
		System.out.println("*************************************************");
	}
}
