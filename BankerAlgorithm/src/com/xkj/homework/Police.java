package com.xkj.homework;

public class Police {
	private Pcb p;
	// private boolean safe = false;

	public Police(Pcb p) {
		super();
		this.p = p;
	}

	public int[] safe() {
		boolean found;
		int[] Work = new int[p.getN()];
		boolean[] Finish = new boolean[p.getM()];
		int[][] Need = new int[p.getM()][p.getN()];
		Need = p.getNeed();
		int[][] Allocation = new int[p.getM()][p.getN()];
		Allocation = p.getAllocation();
		int[] safe = new int[p.getM()];
		int l = 0;
		// 初始化Work向量，Finish向量
		for (int i = 0; i < p.getM(); i++) {
			Finish[i] = false;
		}
		for (int i = 0; i < p.getN(); i++) {
			Work[i] = p.getAvailable()[i];
		}
		while (true) {
			found = false;
			for (int i = 0; i < p.getM(); i++) {
				boolean flag = false;
				for (int j = 0; j < p.getN(); j++) {
					if (Need[i][j] <= Work[j]) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}
				if (flag && Finish[i] == false) {
					for (int j = 0; j < p.getN(); j++) {
						Work[j] = Work[j] + Allocation[i][j];
						Finish[i] = true;
						found = true;
						safe[l] = i;
					}
					l++;
				}
			}
			if (!found) {
				break;
			}
		}
		boolean flag1 = false;
		for (int i = 0; i < Finish.length; i++) {
			if (Finish[i] == true) {
				flag1 = true;
			}else {
				flag1 = false;
				break;
			}
		}
		if(flag1) {
			return safe;
		}else {
			safe = null;
			return safe;
		}
	}
}
