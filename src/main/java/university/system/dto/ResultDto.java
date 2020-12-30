package university.system.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int studentid;
	private String rollno;
	private int gradeid;
	private int examtypeid;

	private Double mark;
	private String studentname;
	private String examtypename;
	private int qno;
	private int correctno;
	private int answerid;
	private int questionid;
	private String questionname;
	private String answername;

	private List<AnswersDto> answers = new ArrayList<AnswersDto>();

	private List<AnswersDto> correctAns = new ArrayList<AnswersDto>();

	public List<AnswersDto> getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(List<AnswersDto> correctAns) {
		this.correctAns = correctAns;
	}

	public List<AnswersDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswersDto> answers) {
		this.answers = answers;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public String getAnswername() {
		return answername;
	}

	public void setAnswername(String answername) {
		this.answername = answername;
	}

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public int getGradeid() {
		return gradeid;
	}

	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

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

}
