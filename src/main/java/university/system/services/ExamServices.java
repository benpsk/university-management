package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.ExamDao;
import university.system.dto.ExamDto;
import university.system.model.Exam;

@Service
@Transactional
public class ExamServices {

	@Autowired
	ExamDao dao;

	public void addExam(ExamDto dto) {
		Exam e = new Exam();
		if (dto != null && dto.getId() != 0) {
			e.setId(dto.getId());
		}
		e.setName(dto.getName());
		dao.addExam(e);
	}

	public List<ExamDto> getExam() {
		return dao.getExam();
	}

	public ExamDto findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void update(ExamDto dto) {
		Exam e = new Exam();
		if (dto != null && dto.getId() != 0) {
			e.setId(dto.getId());
		}
		e.setName(dto.getName());
		dao.update(e);
	}
}
