package Identity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Interface.Main_Page;
import Sql_Server.DBHelper;

public class Teacher {

	private String tid;

	// 老师页面
	public void Hello() throws Exception {
		Scanner input = new Scanner(System.in);
		int menue = 0;
		do {
			System.out.println("1.查看自己的基本信息");
			System.out.println("2.查看所有学生信息");
			System.out.println("3.查看所有学生的成绩信息");
			System.out.println("4.修改学生成绩");
			System.out.println("5.删除某个学生的所有信息");
			System.out.println("6.修改自己的基本信息");
			System.out.println("7.修改登录密码");
			System.out.println("8.添加新的学生信息");
			System.out.println("0.退出登录");
			System.out.println("请输入编号来进行你接下来的操作：");
			menue = input.nextInt();
			switch (menue) {
			case 1:
				getMessage();
				break;
			case 2:
				getAllStudent();
				break;
			case 3:
				getAllScore();
				break;
			case 4:
				setScore();
				break;
			case 5:
				delStudent();
				break;
			case 6:
				setMessage();
				break;
			case 7:
				setPasswd();
				break;
			case 8:
				addStudent();
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
		String sql = "select * from teacher where tid=?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, tid);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("教职工号：" + tid);
			System.out.println("姓名：" + rs.getString("tname"));
			System.out.println("性别：" + rs.getString("tsex"));
			System.out.println("出生日期：" + rs.getString("tbirthday"));
			System.out.println("职称：" + rs.getString("title"));
			System.out.println("薪水：" + rs.getString("salary"));
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

	// 查看所有学生的信息
	public void getAllStudent() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select * from student";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("学号：" + rs.getString("sid"));
			System.out.println("姓名：" + rs.getString("sname"));
			System.out.println("性别：" + rs.getString("ssex"));
			System.out.println("出生日期：" + rs.getString("sbirthday"));
			System.out.println("地址：" + rs.getString("address"));
			System.out.println("班号：" + rs.getString("classid"));
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

	// 查看所有学生的成绩信息
	public void getAllScore() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select student.sid,sname,course.cid,cname,score from student,sc,course where student.sid=sc.sid and sc.cid=course.cid";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("学号：" + rs.getString("sid"));
			System.out.println("姓名：" + rs.getString("sname"));
			System.out.println("课程号：" + rs.getString("cid"));
			System.out.println("课程名：" + rs.getString("cname"));
			System.out.println("分数：" + rs.getString("score"));
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

	// 修改学生成绩
	public void setScore() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Scanner input = new Scanner(System.in);
			String sid = null;
			String cid = null;
			String score = null;
			System.out.print("请输入待修改成绩学生的学号：");
			sid = input.next();
			System.out.print("请输入待修改成绩学生的课程号：");
			cid = input.next();
			System.out.print("请输入要修改的成绩：");
			score = input.next();
			con = DBHelper.getConnection();
			String sql = "update sc set score=? where sid=? and cid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, score);
			stmt.setString(2, sid);
			stmt.setString(3, cid);
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
		System.out.println("成绩更新成功！");
		Main_Page.enter();
		Main_Page.clean();
	}

	// 删除某个学生的所有信息
	public void delStudent() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Scanner input = new Scanner(System.in);
			String sid = null;
			System.out.print("请输入待删除学生的学号：");
			sid = input.next();
			con = DBHelper.getConnection();
			String sql = "delete from student where sid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sid);
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
		System.out.println("删除成功！");
		Main_Page.enter();
		Main_Page.clean();
	}

	// 修改自己的基本信息
	public void setMessage() throws Exception {
		String name = null;
		String sex = null;
		String birthday = null;
		String title = null;
		String salary = null;
		Scanner input = new Scanner(System.in);
		System.out.print("请输入你的姓名：");
		name = input.next();
		System.out.print("请输入你的性别：");
		sex = input.next();
		System.out.print("请输入你的出生日期（格式如1999-01-01）：");
		birthday = input.next();
		System.out.print("请输入你的职称：");
		title = input.next();
		System.out.print("请输入你的薪水：");
		salary = input.next();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBHelper.getConnection();
			String sql = "update student set tname=?,tsex=?,tbirthday=?,title=?,salary=? where tid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, sex);
			stmt.setString(3, birthday);
			stmt.setString(4, title);
			stmt.setString(5, salary);
			stmt.setString(6, tid);
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
			stmt.setString(2, tid);
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
	
	//添加新的学生信息
	public void addStudent() throws Exception {
		String sid = null;
		String name = null;
		String sex = null;
		String birthday = null;
		String address = null;
		String classid = null;
		Scanner input = new Scanner(System.in);
		System.out.print("请输入你的学号：");
		sid = input.next();
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
			String sql = "insert into student values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sid);
			stmt.setString(2, name);
			stmt.setString(3, sex);
			stmt.setString(4, birthday);
			stmt.setString(5, address);
			stmt.setString(6, classid);
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
		System.out.println("添加学生成功！");
		Main_Page.enter();
		Main_Page.clean();
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

}
