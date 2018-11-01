package Interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_Page {
	
	static void Hello() throws Exception {
		System.out.println("欢迎使用学生成绩管理系统");
		Scanner input = new Scanner(System.in);
		int menue = 0;
		do{
			System.out.println("1.已有身份，请登录:");
			System.out.println("2.还没有身份，请注册:");
			System.out.println("0.退出系统");
			System.out.println("请输入编号来进行你接下来的操作：");
			menue = input.nextInt();
			switch(menue)
			{
			case 1:Login.Hello();break;
			case 2:Register.Hello();break;
			case 0:System.out.println("谢谢使用！");break;			
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
		System.out.println("按回车继续......");  
        new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
}
