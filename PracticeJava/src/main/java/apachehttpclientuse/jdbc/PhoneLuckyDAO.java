package apachehttpclientuse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PhoneLuckyDAO {

	static Connection conn = null;

	static {
		try {
			conn = getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertPhoneAndLuckyInfo(PhoneBean pb) throws Exception {

		String sql = "insert into PhoneAndLucky (phoneNumber,numberValue,lastTwoNumberValue,lastFourNumberValue) values(?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, pb.getPhoneNumber());
		preparedStatement.setInt(2, pb.getNumberValue());
		Integer lastTwoNumberValue = pb.getLastTwoNumberValue();
		if(lastTwoNumberValue != null) {
			preparedStatement.setInt(3, lastTwoNumberValue);
		} else {
			preparedStatement.setInt(3, 0);
		}
		Integer lastFourNumberValue = pb.getLastFourNumberValue();
		if(lastFourNumberValue != null) {
			preparedStatement.setInt(4, lastFourNumberValue);
		} else {
			preparedStatement.setInt(4, 0);
		}
		int rowAffectedNumber = preparedStatement.executeUpdate();
		// conn.commit();
		return rowAffectedNumber;
	}

	public static Connection getConnection() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Properties connectionProps = new Properties();
		connectionProps.put("user", "sa");
		connectionProps.put("password", "12QWaszx0215");
		Connection conn = DriverManager.getConnection(
				"jdbc:sqlserver://10.0.0.106:1433;DatabaseName=PhoneDB",
				connectionProps);
		return conn;
	}
}
