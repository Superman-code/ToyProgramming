package Interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_Page {
	
	static void Hello() throws Exception {
		System.out.println("��ӭʹ��ѧ���ɼ�����ϵͳ");
		Scanner input = new Scanner(System.in);
		int menue = 0;
		do{
			System.out.println("1.������ݣ����¼:");
			System.out.println("2.��û����ݣ���ע��:");
			System.out.println("0.�˳�ϵͳ");
			System.out.println("����������������������Ĳ�����");
			menue = input.nextInt();
			switch(menue)
			{
			case 1:Login.Hello();break;
			case 2:Register.Hello();break;
			case 0:System.out.println("ллʹ�ã�");break;			
			}
		}while(menue != 0);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Hello();
	}
	public static void clean() {
		System.out.println("\n\n\n\n\n");
		System.out.println("\n\n\n\n\n");
		System.out.println("\n\n\n\n\n");
	}
	
	public static void enter() throws Exception {
		System.out.println("���س�����......");  
        new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
}
