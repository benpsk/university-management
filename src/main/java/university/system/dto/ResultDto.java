package university.system.dto;

import java.io.Serializable;

public class ResultDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int studentid;
	private int examtypeid;
	private int questionid;
	private Double mark;
	private String remark;
	private String studentname;
	private String examtypename;
	private int qno;
	private int correctno;

	private String[] qIds;

	public String[] getqIds() {
		return qIds;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public int getCorrectno() {
		return correctno;
	}

	public void setCorrectno(int correctno) {
		this.correctno = correctno;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getExamtypename() {
		return examtypename;
	}

	public void setExamtypename(String examtypename) {
		this.examtypename = examtypename;
	}

	public void setqIds(String[] qIds) {
		this.qIds = qIds;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getExamtypeid() {
		return examtypeid;
	}

	public void setExamtypeid(int examtypeid) {
		this.examtypeid = examtypeid;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
