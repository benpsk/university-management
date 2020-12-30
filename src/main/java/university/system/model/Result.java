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
	
	@ManyToOne
	@JoinColumn(name = "std_id")
	private Student std = new Student();

	@ManyToOne
	@JoinColumn(name = "etype_id")
	private ExamType extype = new ExamType();

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question = new Question();

	@ManyToOne
	@JoinColumn(name = "answer_id")
	private Answers answers = new Answers();

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answers getAnswers() {
		return answers;
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
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
