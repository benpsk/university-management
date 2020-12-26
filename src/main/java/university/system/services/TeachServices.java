package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.system.dao.TeachDao;
import university.system.dto.TeachDto;
import university.system.model.Teacher;

@Service
@Transactional
public class TeachServices {

	@Autowired
	TeachDao dao;

	public TeachDto teachByID(int id) {
		return dao.teachByID(id);
	}

	public void addTeach(TeachDto dto) {
		Teacher teach = new Teacher();
		if (dto.getId() != 0) {
			teach.setId(dto.getId());
		}
		teach.setName(dto.getName());
		teach.getDept().setId(dto.getDeptid());
		dao.addTeach(teach);
	}

	public void upTeach(TeachDto dto) {
		Teacher teach = new Teacher();
		if (dto != null && dto.getName() != null) {
			teach.setId(dto.getId());
		}
		teach.setName(dto.getName());
		teach.getDept().setId(dto.getDeptid());

		dao.upTeach(teach);
	}

	public void delTeach(int id) {
		dao.delTeach(id);
	}

	public List<TeachDto> getTeach() {
		return dao.getTeach();
	}
	
	public List<TeachDto> findByDeptId(int id) {
		return dao.findByDeptId(id);
	}
}
