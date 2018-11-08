package com.xkj.homework;

import java.util.Scanner;

public class Banker {
	private Pcb p;

	public Banker(Pcb p) {
		this.p = p;
	}

	public void bank() {
		System.out.println("\n\n-------------------------------------------------------------");
		System.out.println("请输入要申请的进程号(注:第一个进程号为0,以此类推)");
		Scanner scanner = new Scanner(System.in);
		int processNumber = scanner.nextInt();
		System.out.println("请输入进程所请求的各资源的数量");
		int[] request = new int[p.getN()];
		for (int i = 0; i < request.length; i++) {
			request[i] = scanner.nextInt();
		}
		boolean flag = false;// 临时判断变量，用作判断request是否小于等于Need
		for (int i = 0; i < p.getN(); i++) {
			if (request[i] <= p.getNeed()[processNumber][i]) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag) {
			boolean flag1 = false;// 判断request是否小于等于Available
			for (int i = 0; i < request.length; i++) {
				if (request[i] <= p.getAvailable()[i]) {
					flag1 = true;
				} else {
					flag1 = false;
					break;
				}
			}
			if (flag1) {
				for (int i = 0; i < request.length; i++) {
					p.getAvailable()[i] -= request[i];
					p.getAllocation()[processNumber][i] += request[i];
					p.getNeed()[processNumber][i] -= request[i];
				}
				Police police = new Police(p);
				if (police.safe() != null) {
					System.out.println("系统是安全的，分配成功！");
					TestProgramming.showData(p);
				} else {
					System.out.println("系统是不安全的");
					System.out.println("您的请求被拒绝！");
				}
			} else {
				System.out.println("进程等待......");
			}
		} else {
			System.out.println("请求资源的数量大于进程需要资源的数量!");
		}
		System.out.println("您还想再次请求分配吗？‘是’请按‘y/Y’，‘否’请按‘n/N’");
		String s = scanner.nextLine();
		String str = scanner.nextLine();
		char c = str.charAt(0);
		if (c == 'y' || c == 'Y') {
			bank();
		} else if (c == 'n' || c == 'N') {
			System.out.println("此程序已结束！");
			return;
		}
	}

}
