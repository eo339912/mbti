package co.yedam.app.board.model;

public class CommendVO {
	String star;
	String cdate;
	String id;
	String seq;
	String b_seq;
	String avgStar;
	
	
	
	public String getAvgStar() {
		return avgStar;
	}
	public void setAvgStar(String avgStar) {
		this.avgStar = avgStar;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getB_seq() {
		return b_seq;
	}
	public void setB_seq(String b_seq) {
		this.b_seq = b_seq;
	}
	
	
	
}
