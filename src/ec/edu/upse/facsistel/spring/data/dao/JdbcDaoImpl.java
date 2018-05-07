package ec.edu.upse.facsistel.spring.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ec.edu.upse.facsistel.spring.data.model.Circle;

public class JdbcDaoImpl {
	public Circle getCircle(int circleId)
	{
		//Complex part is the JDBC Code here
		Connection conn = null;

		try {
			String driver = "org.apache.derby.jdbc.ClientDriver";

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
			ps.setInt(1, circleId);

			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
		}catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
