package university.system.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Double mark;
	private String remark;
	private int qno;
	private int correctno;

	@ManyToOne
	@JoinColumn(name = "std_id")
	private Student std = new Student();

	@ManyToOne
	@JoinColumn(name = "etype_id")
	private ExamType extype = new ExamType();

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

	public Result() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public ExamType getExtype() {
		return extype;
	}

	public void setExtype(ExamType extype) {
		this.extype = extype;
	}

}
