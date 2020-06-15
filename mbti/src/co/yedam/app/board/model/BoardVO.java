package co.yedam.app.board.model;

public class BoardVO {
	private String id;
	private String title;
	private String contents;
	private String regdt;
	private String seq;
	private String star;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", contents=" + contents + ", regdt=" + regdt + ", seq=" + seq
				+ ", star=" + star + "]";
	}

	
	
	
}