package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.QuestionDao;
import university.system.dto.QuestionDto;
import university.system.model.Question;

@Service
@Transactional
public class QuestionServices {

	@Autowired
	QuestionDao dao;

	public void save(QuestionDto dto) {
		Question q = new Question();
		if (dto != null && dto.getId() != 0) {
			q.setId(dto.getId());
		}
		q.setQname(dto.getQname());
		q.setMark(dto.getMark());
		q.getEtype().setId(dto.getEtypeid());
		dao.save(q);
	}

	public QuestionDto findById(int id) {
		return dao.findById(id);
	}

	public List<QuestionDto> findAll() {
		return dao.findAll();
	}

	public void delete(int id) {
		dao.delete(id);
	}
	
	public void update(QuestionDto dto) {
		Question q = new Question();
		if (dto != null && dto.getId() != 0) {
			q.setId(dto.getId());
		}
		q.setQname(dto.getQname());
		q.setMark(dto.getMark());
		q.getEtype().setId(dto.getEtypeid());
		dao.update(q);
	}
	
	public QuestionDto lastQ() {
		return dao.lastQ();
	}

	public List<QuestionDto> findByEid(int eid) {
		return dao.findByEid(eid);
	}
}
