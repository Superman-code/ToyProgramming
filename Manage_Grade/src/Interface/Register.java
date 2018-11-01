package Interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Sql_Server.DBHelper;

public class Register {
	
	public static void Hello() throws Exception	{
		Main_Page.clean();
		System.out.println("欢迎来到注册页面！请选择你的身份：");
		System.out.println("1.学生");
		System.out.println("2.老师");
		System.out.println("0.退出注册");
		Scanner input = new Scanner(System.in);
		int identity = input.nextInt();
		switch(identity)
		{
		case 1:student_Register();break;
		case 2:teacher_Register();break;
		case 0:break;
		}
	}
	
	//学生注册页面
	public static void student_Register() throws SQLException, Exception {
		System.out.print("请输入你的学号(不得大于9个字符)：");
		Scanner input = new Scanner(System.in);
		String sid = input.next();
		System.out.print("请输入你的密码(不得大于20个字符)：");
		String passwd = input.next();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Connection con = DBHelper.getConnection();
			String sql = "insert into users values(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sid);
			stmt.setString(2, passwd);
			rs = stmt.executeQuery();
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
		System.out.println("注册成功！");
		Main_Page.enter();  
		Main_Page.clean();
	}
	
	
	//老师注册页面
	public static void teacher_Register() throws SQLException, Exception {
		System.out.print("请输入你的职工号(不得大于9个字符)：");
		Scanner input = new Scanner(System.in);
		String tid = input.next();
		System.out.print("请输入你的密码(不得大于20个字符)：");
		String passwd = input.next();
		System.out.println("请输入你的教职工密令：");
		int secret_order = input.nextInt();
		if(secret_order != 970922) {
			System.out.println("密令错误！");
			System.out.println("按回车继续......");  
	        new BufferedReader(new InputStreamReader(System.in)).readLine();
			Main_Page.clean();
		}
		else {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				Connection con = DBHelper.getConnection();
				String sql = "insert into users values(?,?)";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, tid);
				stmt.setString(2, passwd);
				rs = stmt.executeQuery();
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
			System.out.println("注册成功！");
			Main_Page.enter();
			Main_Page.clean();
		}
	}
}
