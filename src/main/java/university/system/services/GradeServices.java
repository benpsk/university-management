package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.GradeDao;
import university.system.dto.GradeDto;
import university.system.model.Grade;

@Service
@Transactional
public class GradeServices {

	@Autowired
	GradeDao dao;

	public void addGrad(GradeDto dto) {
		Grade grade = new Grade();
		if (dto != null && dto.getName() != null) {
			grade.setId(dto.getId());
		}
		grade.setName(dto.getName());
		dao.addGrade(grade);
	}

	public void upGrade(GradeDto dto) {
		Grade grade = new Grade();
		if (dto != null && dto.getId() != 0) {
			grade.setId(dto.getId());
		}
		grade.setName(dto.getName());
		dao.upGrade(grade);
	}

	public void delGrade(int id) {
		dao.delGrade(id);
	}

	public GradeDto getGradeByID(int id) {
		return dao.getGradeByID(id);
	}

	public List<GradeDto> getGrade() {
		return dao.getGrade();
	}
}
