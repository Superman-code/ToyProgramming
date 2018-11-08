package com.xkj.homework;

public class TestProgramming {
	public static void main(String[] args) {
		Pcb p = new Pcb();
		p.setM();
		p.setN();
		p.setMax();
		p.setAllocation();
		p.setAvailable();
		p.setNeed();
		Police police = new Police(p);
		if (police.safe() != null) {
			System.out.println("系统是安全的");
			System.out.println("安全序列:");
			for (int i = 0; i < police.safe().length; i++) {
				if (i != police.safe().length - 1) {
					System.out.print(police.safe()[i] + "-->");
				} else {
					System.out.println(police.safe()[i]);
				}
			}
			System.out.println();
		} else {
			System.out.println("系统是不安全的");
			System.out.println();
		}
		showData(p);
		Banker banker = new Banker(p);
		banker.bank();
	}

	public static void showData(Pcb p) {
		System.out.println("-------------------------------------------------------------");
		System.out.print("系统可用的资源数为：\t");
		for (int i = 0; i < p.getAvailable().length; i++) {
			if (i != p.getAvailable().length - 1) {
				System.out.print(p.getAvailable()[i] + "  ");
			} else {
				System.out.println(p.getAvailable()[i]);
			}
		}
		System.out.println("各进程还需要的资源数量：");
		for (int i = 0; i < p.getNeed().length; i++) {
			System.out.print("\t进程" + i + ":");
			for (int j = 0; j < p.getNeed()[i].length; j++) {
				if (j != p.getNeed()[i].length - 1) {
					System.out.print(String.format("%8d", p.getNeed()[i][j]));
				} else {
					System.out.println(String.format("%8d", p.getNeed()[i][j]));
				}
			}
		}
		System.out.println("各进程已经得到的资源量：");
		for (int i = 0; i < p.getAllocation().length; i++) {
			System.out.print("\t进程" + i + ":");
			for (int j = 0; j < p.getAllocation()[i].length; j++) {
				if (j != p.getAllocation()[i].length - 1) {
					System.out.print(String.format("%8d", p.getAllocation()[i][j]));
				} else {
					System.out.println(String.format("%8d", p.getAllocation()[i][j]));
				}
			}
		}
	}
}
