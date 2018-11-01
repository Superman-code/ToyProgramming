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

	// ѧ��ҳ��
	public void Hello() throws Exception {
		Scanner input = new Scanner(System.in);
		int menue = 0;
		do {
			System.out.println("1.�鿴�Լ��Ļ�����Ϣ");
			System.out.println("2.�鿴�γ���Ϣ");
			System.out.println("3.�鿴�Լ���ѡ�޿γ̳ɼ�");
			System.out.println("4.�޸��Լ��Ļ�����Ϣ");
			System.out.println("5.�޸ĵ�¼����");
			System.out.println("0.�˳���¼");
			System.out.println("����������������������Ĳ�����");
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

	// �鿴�Լ�����Ϣ
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
			System.out.println("ѧ�ţ�" + sid);
			System.out.println("������" + rs.getString("sname"));
			System.out.println("�Ա�" + rs.getString("ssex"));
			System.out.println("�������ڣ�" + rs.getString("sbirthday"));
			System.out.println("��ַ��" + rs.getString("address"));
			System.out.println("��ţ�" + rs.getString("classid"));
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

	// �鿴�γ���Ϣ
	public void getCourse() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select * from course";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("�γ̺ţ�" + rs.getString("cid"));
			System.out.println("�γ�����" + rs.getString("cname"));
			System.out.println("�γ����ͣ�" + rs.getString("type"));
			System.out.println("ѧ�֣�" + rs.getString("credit"));
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

	// �鿴�Լ�ѡ�޿γ̵ĳɼ�
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
			System.out.println("�γ̺ţ�" + rs.getString("cid"));
			System.out.println("�γ�����" + rs.getString("cname"));
			System.out.println("�ɼ���" + rs.getString("score"));
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

	// �޸��Լ��Ļ�����Ϣ
	public void setMessage() throws Exception {
		String name = null;
		String sex = null;
		String birthday = null;
		String address = null;
		String classid = null;
		Scanner input = new Scanner(System.in);
		System.out.print("���������������");
		name = input.next();
		System.out.print("����������Ա�");
		sex = input.next();
		System.out.print("��������ĳ������ڣ���ʽ��1999-01-01����");
		birthday = input.next();
		System.out.print("��������ĵ�ַ��");
		address = input.next();
		System.out.print("��������İ�ţ�");
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
		System.out.println("��Ϣ���³ɹ���");
		Main_Page.enter();
		Main_Page.clean();
	}
	
	//�޸ĵ�¼����
		public void setPasswd() throws Exception {
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				Scanner input = new Scanner(System.in);
				String passwd = null;
				System.out.print("�������µ����룺");
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
			System.out.println("������³ɹ���");
			Main_Page.enter();
			Main_Page.clean();
		}

	public void setSid(String sid) {
		this.sid = sid;
	}

}
