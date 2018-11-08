package com.xkj.homework;

import java.util.Scanner;

public class Pcb {
	private int m; // 进程数目
	private int n; // 资源种类
	private int Max[][]; // 最大资源矩阵
	private int Allocation[][]; // 已分配资源矩阵
	private int Available[]; // 系统资源矩阵
	private int Need[][]; // 需求矩阵
	private Scanner input;

	public Pcb() {
		input = new Scanner(System.in);
	}

	public void setM() {
		System.out.print("请输入进程的数目：");
		m = input.nextInt();
	}

	public void setN() {
		System.out.print("请输入资源的种类：");
		n = input.nextInt();
	}

	public void setMax() {
		Max = new int[m][n];
		System.out.println("请输入每个进程最多所需的各资源数，按照" + m + "x" + n + "矩阵输入");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Max[i][j] = input.nextInt();
			}
		}
	}

	public void setAllocation() {
		Allocation = new int[m][n];
		System.out.println("请输入每个进程已分配的各资源数，按照" + m + "x" + n + "矩阵输入");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Allocation[i][j] = input.nextInt();
			}
		}
	}

	public void setAvailable() {
		Available = new int[n];
		System.out.println("请输入各个资源现有的数目");
		for (int i = 0; i < n; i++) {
			Available[i] = input.nextInt();
		}
	}

	public void setNeed() {
		Need = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Need[i][j] = Max[i][j] - Allocation[i][j];
			}
		}
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public int[][] getMax() {
		return Max;
	}

	public int[][] getAllocation() {
		return Allocation;
	}

	public int[] getAvailable() {
		return Available;
	}

	public int[][] getNeed() {
		return Need;
	}

}
