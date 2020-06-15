package co.yedam.app.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.yedam.app.common.ConnectionManager;
import co.yedam.app.member.model.MemberVO;


public class TestDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public void testInsert(TestVO test) {
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql_seq = "select seq_mbti.nextval result from dual";
			String sql = "insert into mbti (id, result, seq, regdt)"
					+ " values ( ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);
			PreparedStatement psmt2 = conn.prepareStatement(sql_seq);
			ResultSet rs = psmt2.executeQuery();
			String seq = null;
			if(rs.next()) {
				seq = rs.getString(1);
			}
			test.setSeq(seq);
			// 3. 실행
			psmt.setString(1, test.getId());
			psmt.setString(2, test.getResult());
			psmt.setString(3, seq);
			
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}
	
	// 한건조회
	public TestVO getTest(String seq) {
		TestVO vo = new TestVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from mbti where seq=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, seq);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setResult(rs.getString("result"));
			}
			// 4. 결과저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}

		return vo;
	}


}
