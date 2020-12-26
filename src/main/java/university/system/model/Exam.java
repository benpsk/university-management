package university.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@OneToMany(mappedBy = "exam", targetEntity = ExamType.class, cascade = CascadeType.ALL)
	private List<ExamType> etype = new ArrayList<ExamType>();

	public Exam() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExamType> getEtype() {
		return etype;
	}

	public void setEtype(List<ExamType> etype) {
		this.etype = etype;
	}

}
