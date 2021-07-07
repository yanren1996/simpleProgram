package cyr.data;

import cyr.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

//import org.springframework.stereotype.Repository;

public class UserDaoImpl  {//implements UserDao

	private DataSource dataSource;

	public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	//@Override
	public User findUser(String account) {
		String sql = "SELECT * FROM users WHERE account = ? ";
		User user = null;
		try (Connection con = this.dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setAccount("測試先省略");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
