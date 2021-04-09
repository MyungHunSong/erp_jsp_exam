package jsp_exam.dto;

public class Title {
	private int tNo;
	private String tName;
	
	
	public Title(int tNo) {
		this.tNo = tNo;
	}

	public Title(String tName) {
		this.tName = tName;
	}

	public Title(int tNo, String tName) {
		this.tNo = tNo;
		this.tName = tName;
	}


	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public String gettName() {
		return tName;
	}


	public void settName(String tName) {
		this.tName = tName;
	}


	@Override
	public String toString() {
		return String.format("Title [직책번호=%s, 직책이름=%s]", tNo, tName);
	}
	
}
