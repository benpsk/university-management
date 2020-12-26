package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.ExamTypeDao;
import university.system.dto.ExamTypeDto;
import university.system.model.ExamType;

@Service
@Transactional
public class ExamTypeServices {

	@Autowired
	ExamTypeDao dao;

	public void save(ExamTypeDto dto) {
		ExamType etype = new ExamType();
		if (dto != null) {
			etype.setId(dto.getId());
		}
		etype.setType(dto.getType());
		etype.getExam().setId(dto.getExamid());
		dao.save(etype);
	}

	public List<ExamTypeDto> findAll() {
		return dao.findAll();
	}

	public ExamTypeDto findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void update(ExamTypeDto dto) {
		ExamType etype = new ExamType();
		if (dto != null) {
			etype.setId(dto.getId());
		}
		etype.setType(dto.getType());
		etype.getExam().setId(dto.getExamid());
		dao.update(etype);
	}

}
