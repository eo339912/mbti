package co.yedam.app.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.yedam.app.common.ConnectionManager;
import co.yedam.app.test.model.TestVO;



public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public void memberInsert(MemberVO member) {
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into member (id, pwd, name, gender, birth)"
					+ " values (?, ?, ?, ?, TO_DATE(?, 'yyyymmdd'))";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getBirth());

			// 4. 결과처리
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
	}

	// 다건조회_join
	public ArrayList<TestVO> getResultList(String id) {
		ArrayList<TestVO> list = new ArrayList<TestVO>();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select member.id, mbti.* from member join mbti on(member.id = mbti.id) where member.id=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				TestVO vo = new TestVO();
				vo.setRegdt(rs.getString("regdt"));
				vo.setResult(rs.getString("result"));
				list.add(vo);
			}
			// 4. 결과저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}

		return list;

	}
	// 한건조회_join result받아옴
	public MemberVO getMemberOne(String id) {
		MemberVO vo = new MemberVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select member.*, mbti.result from member join mbti on(member.id = mbti.id)"
						+ " where member.id=? and seq = (select seq from (select * from mbti order by rownum desc) WHERE rownum = 1)";
			
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setGender(rs.getString("gender"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setBirth(rs.getString("birth"));
				vo.setResult(rs.getString("result"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}
		return vo;
	}

	// 한건조회_join /로그인시사용
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from member where id=?";

			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setGender(rs.getString("gender"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setBirth(rs.getString("birth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}
		return vo;
	}
	// 수정
	public void memberUpdate(MemberVO member) {

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update member set pwd=?, name=?, gender=?, birth=to_date(?, 'yyyymmdd')"
					+ " where id=?";
			

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getGender());
			psmt.setString(4, member.getBirth());
			psmt.setString(5, member.getId());

			int r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r +"수정됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}

	// 전체조회
	public ArrayList<MemberVO> getMemberList(int start, int end, String name) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			
			String strWhere = " where 1 = 1";//무조건 true
			if(name != null && ! name.isEmpty()) {
				strWhere += " and name like '%' || ? || '%' ";				
			}
			
			// 2. 쿼리준비
			String sql = "select B.* from( select A.*, rownum RN from("
					+ "select * from member "+ strWhere+ " order by id"
					+ " ) A ) B where RN between ? and ?";
			psmt = conn.prepareStatement(sql);
			int post = 1;
			if(name != null && ! name.isEmpty()) {
				psmt.setString(post++, name);				
			}
			psmt.setInt(post++, start);
			psmt.setInt(post++, end);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setGender(rs.getString("gender"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));

				list.add(vo);
			}
			// 4. 결과저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}

		return list;
	}
	//페이징 전체 건수
	public int getCount(String name) {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			
			String strWhere = " where 1 = 1";//무조건 true
			if(name != null && ! name.isEmpty()) {
				strWhere += " and first_name like '%' || ? || '%' ";				
			}
			
			
			String sql ="select count(*) from member" + strWhere;
			psmt = conn.prepareStatement(sql);
			
			int post = 1;
			if(name != null && ! name.isEmpty()) {
				psmt.setString(post++, name);				
			}
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, psmt, conn);
		}
		return cnt;
	}

	// 삭제
	public int memberDelete(MemberVO member) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "delete from member where id= ? ";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());

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
