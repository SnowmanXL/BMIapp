import java.sql.*;

public class NewUser {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String USER = "root";
	static final String PASS = "root";
	static Connection conn = null;
	static Statement stmt = null;
	static int Uid;

	public NewUser(String NewUser, String NewPW) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT MAX(U_ID) u_id FROM users;";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			if (rs.next()) {
				Uid = rs.getInt("u_id");
				Uid++;
			}
			System.out.println(Uid);

			rs.close();
			stmt.close();

			stmt = conn.createStatement();
			String sql1;
			sql1 = "INSERT INTO users (U_ID,U_NAME,U_WW) VALUES (" + Uid + ",\"" + NewUser + "\",\"" + NewPW + "\")";
			System.out.println(sql1);
			stmt.executeUpdate(sql1);
			stmt.close();
			conn.close();
			System.out.println("User has been created");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
