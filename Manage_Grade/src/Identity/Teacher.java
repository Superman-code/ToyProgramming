package Identity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Interface.Main_Page;
import Sql_Server.DBHelper;

public class Teacher {

	private String tid;

	// ��ʦҳ��
	public void Hello() throws Exception {
		Scanner input = new Scanner(System.in);
		int menue = 0;
		do {
			System.out.println("1.�鿴�Լ��Ļ�����Ϣ");
			System.out.println("2.�鿴����ѧ����Ϣ");
			System.out.println("3.�鿴����ѧ���ĳɼ���Ϣ");
			System.out.println("4.�޸�ѧ���ɼ�");
			System.out.println("5.ɾ��ĳ��ѧ����������Ϣ");
			System.out.println("6.�޸��Լ��Ļ�����Ϣ");
			System.out.println("7.�޸ĵ�¼����");
			System.out.println("8.����µ�ѧ����Ϣ");
			System.out.println("0.�˳���¼");
			System.out.println("����������������������Ĳ�����");
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

	// �鿴�Լ�����Ϣ
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
			System.out.println("��ְ���ţ�" + tid);
			System.out.println("������" + rs.getString("tname"));
			System.out.println("�Ա�" + rs.getString("tsex"));
			System.out.println("�������ڣ�" + rs.getString("tbirthday"));
			System.out.println("ְ�ƣ�" + rs.getString("title"));
			System.out.println("нˮ��" + rs.getString("salary"));
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

	// �鿴����ѧ������Ϣ
	public void getAllStudent() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select * from student";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("ѧ�ţ�" + rs.getString("sid"));
			System.out.println("������" + rs.getString("sname"));
			System.out.println("�Ա�" + rs.getString("ssex"));
			System.out.println("�������ڣ�" + rs.getString("sbirthday"));
			System.out.println("��ַ��" + rs.getString("address"));
			System.out.println("��ţ�" + rs.getString("classid"));
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

	// �鿴����ѧ���ĳɼ���Ϣ
	public void getAllScore() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		con = DBHelper.getConnection();
		String sql = "select student.sid,sname,course.cid,cname,score from student,sc,course where student.sid=sc.sid and sc.cid=course.cid";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("ѧ�ţ�" + rs.getString("sid"));
			System.out.println("������" + rs.getString("sname"));
			System.out.println("�γ̺ţ�" + rs.getString("cid"));
			System.out.println("�γ�����" + rs.getString("cname"));
			System.out.println("������" + rs.getString("score"));
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

	// �޸�ѧ���ɼ�
	public void setScore() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Scanner input = new Scanner(System.in);
			String sid = null;
			String cid = null;
			String score = null;
			System.out.print("��������޸ĳɼ�ѧ����ѧ�ţ�");
			sid = input.next();
			System.out.print("��������޸ĳɼ�ѧ���Ŀγ̺ţ�");
			cid = input.next();
			System.out.print("������Ҫ�޸ĵĳɼ���");
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
		System.out.println("�ɼ����³ɹ���");
		Main_Page.enter();
		Main_Page.clean();
	}

	// ɾ��ĳ��ѧ����������Ϣ
	public void delStudent() throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Scanner input = new Scanner(System.in);
			String sid = null;
			System.out.print("�������ɾ��ѧ����ѧ�ţ�");
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
		System.out.println("ɾ���ɹ���");
		Main_Page.enter();
		Main_Page.clean();
	}

	// �޸��Լ��Ļ�����Ϣ
	public void setMessage() throws Exception {
		String name = null;
		String sex = null;
		String birthday = null;
		String title = null;
		String salary = null;
		Scanner input = new Scanner(System.in);
		System.out.print("���������������");
		name = input.next();
		System.out.print("����������Ա�");
		sex = input.next();
		System.out.print("��������ĳ������ڣ���ʽ��1999-01-01����");
		birthday = input.next();
		System.out.print("���������ְ�ƣ�");
		title = input.next();
		System.out.print("���������нˮ��");
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
		System.out.println("������³ɹ���");
		Main_Page.enter();
		Main_Page.clean();
	}
	
	//����µ�ѧ����Ϣ
	public void addStudent() throws Exception {
		String sid = null;
		String name = null;
		String sex = null;
		String birthday = null;
		String address = null;
		String classid = null;
		Scanner input = new Scanner(System.in);
		System.out.print("���������ѧ�ţ�");
		sid = input.next();
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
		System.out.println("���ѧ���ɹ���");
		Main_Page.enter();
		Main_Page.clean();
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

}
