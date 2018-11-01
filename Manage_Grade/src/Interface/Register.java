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
		System.out.println("��ӭ����ע��ҳ�棡��ѡ�������ݣ�");
		System.out.println("1.ѧ��");
		System.out.println("2.��ʦ");
		System.out.println("0.�˳�ע��");
		Scanner input = new Scanner(System.in);
		int identity = input.nextInt();
		switch(identity)
		{
		case 1:student_Register();break;
		case 2:teacher_Register();break;
		case 0:break;
		}
	}
	
	//ѧ��ע��ҳ��
	public static void student_Register() throws SQLException, Exception {
		System.out.print("���������ѧ��(���ô���9���ַ�)��");
		Scanner input = new Scanner(System.in);
		String sid = input.next();
		System.out.print("�������������(���ô���20���ַ�)��");
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
		System.out.println("ע��ɹ���");
		Main_Page.enter();  
		Main_Page.clean();
	}
	
	
	//��ʦע��ҳ��
	public static void teacher_Register() throws SQLException, Exception {
		System.out.print("���������ְ����(���ô���9���ַ�)��");
		Scanner input = new Scanner(System.in);
		String tid = input.next();
		System.out.print("�������������(���ô���20���ַ�)��");
		String passwd = input.next();
		System.out.println("��������Ľ�ְ�����");
		int secret_order = input.nextInt();
		if(secret_order != 970922) {
			System.out.println("�������");
			System.out.println("���س�����......");  
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
			System.out.println("ע��ɹ���");
			Main_Page.enter();
			Main_Page.clean();
		}
	}
}
