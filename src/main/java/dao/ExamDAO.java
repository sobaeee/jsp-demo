package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.ExamVO;
import util.DbUtil;

public class ExamDAO extends DbUtil{

	/**
	 * C : create() 등록하는 메소드 public : 접근지정자 param : 등록될 값 return : 없음..
	 */

	public void create(ExamVO vo) {

		StringBuffer sql = new StringBuffer();
		sql.append("\n INSERT INTO quiz ");
		sql.append("\n (num, qs, an) ");
		sql.append("\n VALUES (null, ?, ?) ");

		Connection conn = null;
		PreparedStatement stmt = null;
		
		int idx =0;

		try {
			conn = dbCoon();

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(++idx, vo.getQs());
			stmt.setString(++idx, vo.getAn());
			
			int res = stmt.executeUpdate(); // <이것이 있어야 실행이 된다.
			// 결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// ClassNotFoundException -> Exception으로 수정
			e.printStackTrace();
		} finally {
			//DbUtil.dbClose(conn, stmt, null); //null이 있어서 if를 안붙여두 된다.
			dbClose(conn, stmt, null); //DbUtil을 상속 받았을때 쓴다.
		}
		// 닫기
	}

	/**
	 * R : read() 조회하는 메소드 public : 접근지정자 param : 조회할 값 return : List
	 */

	
	public List<ExamVO> read(String q){

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM quiz WHERE qs LIKE ?" );
		
		ExamVO examVo = null;
		List<ExamVO> list = new ArrayList<ExamVO>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		ResultSet rs = null;

		try {
			conn = dbCoon();
			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setString(1, "%"+q+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				examVo = new ExamVO(
					rs.getInt("num"),
					rs.getString("qs"),
					rs.getString("an")

					);
				list.add(examVo);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, rs);
		}
		return list;
	}
}
