import java.sql.*;

public class PwValidator {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String USER = "root";
	static final String PASS = "root";
	static Connection conn = null;
	static Statement stmt = null;
	public static boolean SQLresponse;
	public static int resptruecount = 0;

	public PwValidator() {
		PwValidator.pwvalidation(MyBodyAPK.uname, MyBodyAPK.password);
	}

	public static void main(String[] args) {
		PwValidator a = new PwValidator();
	}

	public static void pwvalidation(String unamein, String pwin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT U_NAME, U_WW FROM users where U_NAME = \"" + unamein + "\" and U_WW = \"" + pwin + "\"";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String uname = rs.getString("U_NAME");
				String ww = rs.getString("U_WW");
				System.out.println(uname + "\t" + ww);
				System.out.println(unamein + "\t" + pwin);
				if (unamein.equals(uname) && pwin.equals(ww)) {
					SQLresponse = true;
					resptruecount++;
				} else {
					System.out.println("No luck!");
				}
			}
			rs.close();
			stmt.close();
			conn.close();
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
}
