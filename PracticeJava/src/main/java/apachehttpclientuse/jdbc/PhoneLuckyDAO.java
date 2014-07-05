package apachehttpclientuse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

	public List<PhoneBean> get100ValuePhoneNumber() throws Exception {
		List<PhoneBean> phoneBeans = new ArrayList<PhoneBean>();
		String sql = "select phoneNumber,numberValue,lastTwoNumberValue,lastFourNumberValue from PhoneAndLucky where numberValue=100";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while( rs.next()) {
			String phoneNumber = rs.getString(1);
			int numberValue = rs.getInt(2);
			PhoneBean pb = new PhoneBean();
			pb.setNumberValue(numberValue);
			pb.setPhoneNumber(phoneNumber);
			phoneBeans.add(pb);
		}
		return phoneBeans;
	}
	
	public List<PhoneBean> get95ValuePhoneNumber() throws Exception {
		List<PhoneBean> phoneBeans = new ArrayList<PhoneBean>();
		String sql = "select phoneNumber,numberValue,lastTwoNumberValue,lastFourNumberValue from PhoneAndLucky where numberValue=95";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while( rs.next()) {
			String phoneNumber = rs.getString(1);
			int numberValue = rs.getInt(2);
			PhoneBean pb = new PhoneBean();
			pb.setNumberValue(numberValue);
			pb.setPhoneNumber(phoneNumber);
			phoneBeans.add(pb);
		}
		return phoneBeans;
	}
	
	public void update100ValuePhoneNumber(PhoneBean pb) throws Exception {
		String sql = "update PhoneAndLucky set lastTwoNumberValue=?,lastFourNumberValue=? where phoneNumber=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, pb.getLastTwoNumberValue());
		preparedStatement.setInt(2, pb.getLastFourNumberValue());
		preparedStatement.setString(3, pb.getPhoneNumber());
		preparedStatement.execute();
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
