package co.yedam.app.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.yedam.app.common.ConnectionManager;


public class CommendDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public int commendInsert(CommendVO commend) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into commend (id, star, cdate, seq, b_seq)"
					+ " values (?, ?, sysdate, seq_commend.nextval, ?)";
			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, commend.getId());
			psmt.setString(2, commend.getStar());
			psmt.setString(3, commend.getB_seq());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}

	// b-seq에 해당하는 star평균 한건 조회
	public CommendVO getCommendSeq(String bseq) {
		CommendVO vo = new CommendVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select id, b_seq, round(avg(star)) avgstar from commend where b_seq=? group by id, b_seq";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, bseq);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setSeq(rs.getString("b_seq"));
				vo.setAvgStar(rs.getString("avgstar"));
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
	
	//board테이블에 star 평균값 update
	// 수정
	public int boardStarUpdate(BoardVO board) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update board set star=?"
					+ " where seq=?";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, board.getStar());
			psmt.setString(2, board.getSeq());
			
			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 수정됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}
	
		
	



}