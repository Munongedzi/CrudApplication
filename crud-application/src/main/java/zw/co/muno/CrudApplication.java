package zw.co.muno;

import java.sql.*;
import java.util.Scanner;
import java.util.*;

public class CrudApplication {

	public static void main(String[] args) throws SQLException, Exception {
		String url = "jdbc:mysql://localhost:3306/crud_application";
		String userName = "root";
		String psw = "Muno@123";
		String query = "SELECT * FROM user";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, psw);
		Statement st = con.createStatement();
		st.executeQuery(query);
while(true) {
		do {
			System.out.println("Select options from the menu below:");
			System.out.println("Select\n1 to read\n2 to create\n3 to update\n4 to delete");
			Scanner sc = new Scanner(System.in);
			int DataInput = sc.nextInt();
			switch (DataInput) {
			case 1:
				ResultSet resultSet = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection(url, userName, psw);
					Statement statement = connection.createStatement();

					String selectSql = "SELECT * from user";
					resultSet = statement.executeQuery(selectSql);

					while (resultSet.next())
						System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " "
								+ resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5)
								+ " " + resultSet.getString(6) + " " + resultSet.getString(7) + " "
								+ resultSet.getString(8));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:

				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection(url, userName, psw);
					Statement statement = connection.createStatement();
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Enter Username: ");
					String Username = sc2.nextLine();
					System.out.println();
					System.out.println("Enter Firstname: ");
					String Firstname = sc2.nextLine();
					System.out.println("Enter Surname: ");
					String Surname = sc2.nextLine();
					System.out.println("Enter Email: ");
					String Email = sc2.nextLine();
					System.out.println("Enter Date of Birth: ");
					String DOB = sc2.nextLine();
					System.out.println("Enter Phone Number: ");
					String phone_number = sc2.nextLine();
					System.out.println("Enter Address: ");
					String Address = sc2.nextLine();
					System.out.println("Enter Password: ");
					String Password = sc2.nextLine();

					query = "INSERT INTO user(Username,Firstname,Surname,Email,dateOfBirth,PhoneNumber,Address,Password)"
							+ "VALUES(?,?,?,?,?,?,?,?)";

					PreparedStatement stmt = con.prepareStatement(query);
					stmt.setString(1, Username);
					stmt.setString(2, Firstname);
					stmt.setString(3, Surname);
					stmt.setString(4, Email);
					stmt.setString(5, DOB);
					stmt.setString(6, phone_number);
					stmt.setString(7, Address);
					stmt.setString(8, Password);
					stmt.execute();

					System.out.println("Data Entered Successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:

				try {
					Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection(url, userName, psw);
					Statement statement = connection.createStatement();
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter username ");
					String Username = sc3.nextLine();
					System.out.println("Enter phoneNumber ");
					String phoneNumber = sc3.nextLine();
					String UPDATE_USERS_SQL = "update user SET PhoneNumber=? WHERE Username = ? ";
					PreparedStatement stmt = con.prepareStatement(UPDATE_USERS_SQL);
					stmt.setString(1, phoneNumber);
					stmt.setString(2, Username);
					stmt.execute();

					System.out.println("Data updated successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:

				try

				{
					Class.forName("com.mysql.jdbc.Driver");

					Connection connection = DriverManager.getConnection(url, userName, psw);
					Statement statement = connection.createStatement();
					Scanner sc3 = new Scanner(System.in);
					System.out.println("Enter Username you want to delete");
					String Username = sc3.nextLine();
					String sql = ("delete from user where Username= ?");
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, Username);
					stmt.execute();

					System.out.println("Data deleted successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			}
		} while (false);
		{
		}

	}
}
}