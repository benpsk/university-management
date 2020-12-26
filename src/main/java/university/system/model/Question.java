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
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String qname;
	private Double mark;

	@OneToMany(mappedBy = "question", targetEntity = Answers.class, cascade = CascadeType.ALL)
	private List<Answers> ans = new ArrayList<Answers>();

	@ManyToOne
	@JoinColumn(name = "etype_id")
	private ExamType etype = new ExamType();

	public Question() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public ExamType getEtype() {
		return etype;
	}

	public void setEtype(ExamType etype) {
		this.etype = etype;
	}

	public List<Answers> getAns() {
		return ans;
	}

	public void setAns(List<Answers> ans) {
		this.ans = ans;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

}
