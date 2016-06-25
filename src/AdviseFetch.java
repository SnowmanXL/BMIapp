import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdviseFetch {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net/sql7125334";
	static final String USER = "sql7125334";
	static final String PASS = "UZtplEEUYC";
	
	static Connection conn = null;
	static Statement stmt = null;
	public static String Advise;
	

	public AdviseFetch() {
		AdviseFetch.AdviseFetchSQL();
	}

	public static void main(String[] args) {
		AdviseFetch a = new AdviseFetch();
	}

	public static void AdviseFetchSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "Select advise from advise_matrix where 1=1 and BMI_Min <= " + BMICalculation.BMI + " and BMI_Max >= " + BMICalculation.BMI + " and AGE_Min <= " + ApplicationStructure.Age + " and AGE_Max >= " + ApplicationStructure.Age + " and Risk = '" + BMICalculation.Risk + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Advise = rs.getString("advise");
				System.out.println(Advise);
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
