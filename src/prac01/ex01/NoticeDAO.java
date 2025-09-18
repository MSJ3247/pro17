package prac01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeDAO {
	private DataSource dataFactory; 
	private Connection  conn;
	
	private PreparedStatement pstmt;
	
	public NoticeDAO(){
		try {
			Context ctxContext = new InitialContext();
			Context envContext = (Context) ctxContext.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<NoticeVO> listNotices() {
		List<NoticeVO> noticesList = new ArrayList<NoticeVO>();
		try {
			conn = dataFactory.getConnection();
			String query = "select * from t_notice order by notice_post_date asc";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String no = rs.getString("notice_no");
				String title = rs.getString("notice_title");
				Date postDate = rs.getDate("notice_post_date");
				NoticeVO noticevo = new NoticeVO(no, title, postDate);
				noticesList.add(noticevo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return noticesList;
	}
	
	public void addNotice(NoticeVO m)
	{
		try {
			conn = dataFactory.getConnection();
			String no = m.getNo();
			String title = m.getTitle();
			String query = "INSERT INTO t_notice(notice_no, notice_title)" + "VALUES(?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, no);
			pstmt.setString(2, title);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
