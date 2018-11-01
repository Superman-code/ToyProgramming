package Identity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Interface.Main_Page;
import Sql_Server.DBHelper;

public class Student {

	private String sid;

	// 学生页面
	public void Hello() throws Exception {
		Scanner input = new Scanner(System.in);
		int menue = 0;
		do {
			System.out.println("1.查看自己的基本信息");
			System.out.println("2.查看课程信息");
			System.out.println("3.查看自己的选修课程成绩");
			System.out.println("4.修改自己的基本信息");
			System.out.println("5.修改登录密码");
			System.out.println("0.退出登录");
			System.out.println("请输入编号来进行你接下来的操作：");
			menue = input.nextInt();
			switch (menue) {
			case 1:
				getMessage();
				break;
			case 2:
				getCourse();
				break;
			case 3:
				getScore();
				break;
			case 4:
				setMessage();
				break;
			case 5:
				setPasswd();
				break;
			case 0:
				break;
			}
		} while (menue != 0);
	}

	// 查看自己的信息
	public void getMessage() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select * from student where sid=?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, sid);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("学号：" + sid);
			System.out.println("姓名：" + rs.getString("sname"));
			System.out.println("性别：" + rs.getString("ssex"));
			System.out.println("出生日期：" + rs.getString("sbirthday"));
			System.out.println("地址：" + rs.getString("address"));
			System.out.println("班号：" + rs.getString("classid"));
		}

		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}
		Main_Page.enter();
		Main_Page.clean();
	}

	// 查看课程信息
	public void getCourse() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select * from course";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("课程号：" + rs.getString("cid"));
			System.out.println("课程名：" + rs.getString("cname"));
			System.out.println("课程类型：" + rs.getString("type"));
			System.out.println("学分：" + rs.getString("credit"));
			System.out.println("\n\n");
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}
		Main_Page.enter();
		Main_Page.clean();
	}

	// 查看自己选修课程的成绩
	public void getScore() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select course.cid,cname,score from sc,course where sc.sid=? and sc.cid=course.cid";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, sid);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("课程号：" + rs.getString("cid"));
			System.out.println("课程名：" + rs.getString("cname"));
			System.out.println("成绩：" + rs.getString("score"));
			System.out.println("\n\n");
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}
		Main_Page.enter();
		Main_Page.clean();
	}

	// 修改自己的基本信息
	public void setMessage() throws Exception {
		String name = null;
		String sex = null;
		String birthday = null;
		String address = null;
		String classid = null;
		Scanner input = new Scanner(System.in);
		System.out.print("请输入你的姓名：");
		name = input.next();
		System.out.print("请输入你的性别：");
		sex = input.next();
		System.out.print("请输入你的出生日期（格式如1999-01-01）：");
		birthday = input.next();
		System.out.print("请输入你的地址：");
		address = input.next();
		System.out.print("请输入你的班号：");
		classid = input.next();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBHelper.getConnection();
			String sql = "update student set sname=?,ssex=?,sbirthday=?,address=?,classid=? where sid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, sex);
			stmt.setString(3, birthday);
			stmt.setString(4, address);
			stmt.setString(5, classid);
			stmt.setString(6, sid);
			rs = stmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (rs != null) {
				rs.close();
				rs = null;
			}
		}
		System.out.println("信息更新成功！");
		Main_Page.enter();
		Main_Page.clean();
	}
	
	//修改登录密码
		public void setPasswd() throws Exception {
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				Scanner input = new Scanner(System.in);
				String passwd = null;
				System.out.print("请输入新的密码：");
				passwd = input.next();
				con = DBHelper.getConnection();
				String sql = "update users set passwd=? where userid=?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, passwd);
				stmt.setString(2, sid);
				rs = stmt.executeQuery();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (rs != null) {
					rs.close();
					rs = null;
				}
			}
			System.out.println("密码更新成功！");
			Main_Page.enter();
			Main_Page.clean();
		}

	public void setSid(String sid) {
		this.sid = sid;
	}

}
