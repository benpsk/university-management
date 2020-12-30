package university.system.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String qname;
	private Double mark;
	private int etypeid;
	private String etypename;

	private List<AnswersDto> ans = new ArrayList<AnswersDto>();

	private List<AnswersDto> correctAns = new ArrayList<AnswersDto>();

	public List<AnswersDto> getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(List<AnswersDto> correctAns) {
		this.correctAns = correctAns;
	}

	public List<AnswersDto> getAns() {
		return ans;
	}

	public void setAns(List<AnswersDto> ans) {
		this.ans = ans;
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

	public int getEtypeid() {
		return etypeid;
	}

	public void setEtypeid(int etypeid) {
		this.etypeid = etypeid;
	}

	public String getEtypename() {
		return etypename;
	}

	public void setEtypename(String etypename) {
		this.etypename = etypename;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

}
