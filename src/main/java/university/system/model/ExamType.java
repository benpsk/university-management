package university.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ExamType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam = new Exam();

	@OneToMany(mappedBy = "etype", targetEntity = Question.class, cascade = CascadeType.ALL)
	private List<Question> ques = new ArrayList<Question>();

	@OneToMany(mappedBy = "extype", targetEntity = Result.class, cascade = CascadeType.ALL)
	private List<Result> result = new ArrayList<Result>();

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public ExamType() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<Question> getQues() {
		return ques;
	}

	public void setQues(List<Question> ques) {
		this.ques = ques;
	}

}
