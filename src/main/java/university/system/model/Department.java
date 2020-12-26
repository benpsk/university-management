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
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	public Department() {
		
	}
	
	@OneToMany(mappedBy = "dept", targetEntity = Teacher.class, cascade = CascadeType.ALL)
	private List<Teacher> teach = new ArrayList<Teacher>();
	
		
	public List<Teacher> getTeach() {
		return teach;
	}
	public void setTeach(List<Teacher> teach) {
		this.teach = teach;
	}
	public List<Teacher> getTeacher() {
		return teach;
	}
	public void setTeacher(List<Teacher> teacher) {
		this.teach = teacher;
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
}
