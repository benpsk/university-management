package university.system.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttListDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Date date;
	private List<AttStdDto> attList = new ArrayList<AttStdDto>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<AttStdDto> getAttList() {
		return attList;
	}

	public void setAttList(List<AttStdDto> attList) {
		this.attList = attList;
	}
}
