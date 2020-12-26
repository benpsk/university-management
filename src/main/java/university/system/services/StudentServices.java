package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.StudentDao;
import university.system.dto.StudentDto;
import university.system.model.Student;

@Service
@Transactional
public class StudentServices {

	@Autowired
	StudentDao dao;

	public void addStd(StudentDto dto) {
		Student std = new Student();
		if (dto != null && dto.getName() != null) {
			std.setId(dto.getId());
		}
		std.setName(dto.getName());
		std.setRollno(dto.getRollno());
		std.getGrade().setId(dto.getGradeid());
		dao.addStd(std);
	}

	public void upStd(StudentDto dto) {
		Student std = new Student();
		if (dto != null && dto.getId() != 0) {
			std.setId(dto.getId());
		}
		std.setName(dto.getName());
		std.setRollno(dto.getRollno());
		std.getGrade().setId(dto.getGradeid());
		dao.upStd(std);
	}

	public void delStd(int id) {
		dao.delStd(id);
	}

	public StudentDto getStdByID(int id) {
		return dao.getStdByID(id);
	}

	public List<StudentDto> getStd() {
		return dao.getStd();
	}

	public List<StudentDto> filterGrade(int id) {
		return dao.filterGrade(id);
	}

	public List<StudentDto> getByGradeId(int gid) {
		return dao.getByGradeId(gid);
	}
}
