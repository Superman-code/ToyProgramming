package Interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Identity.Student;
import Identity.Teacher;
import Sql_Server.DBHelper;

public class Login {
	
	//主登录页面
	public static void Hello() throws Exception	 {
		Main_Page.clean();
		System.out.println("欢迎来到登录页面！请选择你的身份：");
		System.out.println("1.学生");
		System.out.println("2.老师");
		System.out.println("0.退出登录");
		Scanner input = new Scanner(System.in);
		int identity = input.nextInt();
		switch(identity)
		{
		case 1:student_login();break;
		case 2:teacher_login();break;
		case 0:break;
		}
	}
	
	//学生登录页面
	public static void student_login() throws Exception {
		System.out.print("请输入你的学号：");
		Scanner input = new Scanner(System.in);
		String sid = input.next();
		System.out.print("请输入你的密码：");
		String passwd = input.next();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = DBHelper.getConnection();
			String sql = "select * from users";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				if(sid.equals(rs.getString("userid")) && passwd.equals(rs.getString("passwd"))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		}finally {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(rs != null) {
				rs.close();
				rs = null;
			}
		}
		if(flag) {
			Student st = new Student();
			st.setSid(sid);
			System.out.println("登录成功！");
			Main_Page.enter();
	        Main_Page.clean();
			st.Hello();
		}
		else
		{
			System.out.println("登录失败，用户不存在！");
			Main_Page.enter();
	        Main_Page.clean();
		}
	}
	
	//老师登录页面
	public static void teacher_login() throws Exception {
		System.out.print("请输入你的职工号：");
		Scanner input = new Scanner(System.in);
		String tid = input.next();
		System.out.print("请输入你的密码：");
		String passwd = input.next();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = DBHelper.getConnection();
			String sql = "select * from users";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				if(tid.equals(rs.getString("userid")) && passwd.equals(rs.getString("passwd"))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		}finally {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(rs != null) {
				rs.close();
				rs = null;
			}
		}
		if(flag) {
			Teacher tea = new Teacher();
			tea.setTid(tid);
			System.out.println("登录成功！");
			Main_Page.enter();
	        Main_Page.clean();
	        tea.Hello();
		}
		else
		{
			System.out.println("登录失败，用户不存在！");
			Main_Page.enter();
	        Main_Page.clean();
		}
	}
}
