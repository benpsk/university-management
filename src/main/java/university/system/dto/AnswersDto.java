package university.system.dto;

import java.io.Serializable;

public class AnswersDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private boolean status1;
	private boolean status2;
	private boolean status3;
	private boolean status4;
	private int questionid;
	private String questionname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public boolean getStatus1() {
		return status1;
	}

	public void setStatus1(boolean status1) {
		this.status1 = status1;
	}

	public boolean getStatus2() {
		return status2;
	}

	public void setStatus2(boolean status2) {
		this.status2 = status2;
	}

	public boolean getStatus3() {
		return status3;
	}

	public void setStatus3(boolean status3) {
		this.status3 = status3;
	}

	public boolean getStatus4() {
		return status4;
	}

	public void setStatus4(boolean status4) {
		this.status4 = status4;
	}

}
