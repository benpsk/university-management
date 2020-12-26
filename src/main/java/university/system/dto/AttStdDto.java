package university.system.dto;

import java.io.Serializable;

public class AttStdDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int studentid;
	private String studentname;
	private String rollno;
	private Boolean status;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

}
