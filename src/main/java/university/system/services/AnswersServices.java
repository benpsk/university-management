package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.AnswersDao;
import university.system.dto.AnswersDto;
import university.system.model.Answers;

@Service
@Transactional
public class AnswersServices {

	@Autowired
	AnswersDao dao;

	public void save(AnswersDto dto) {
		Answers ans1 = new Answers();
		Answers ans2 = new Answers();
		Answers ans3 = new Answers();
		Answers ans4 = new Answers();

		if (dto != null && dto.getId() != 0) {
			ans1.setId(dto.getId());
		}
		ans1.setAns(dto.getAns1());
		ans1.setStatus(dto.getStatus1());
		ans1.getQuestion().setId(dto.getQuestionid());
		dao.save(ans1);

		ans2.setId(dto.getId());
		ans2.setAns(dto.getAns2());
		ans2.setStatus(dto.getStatus2());
		ans2.getQuestion().setId(dto.getQuestionid());
		dao.save(ans2);

		ans3.setId(dto.getId());
		ans3.setAns(dto.getAns3());
		ans3.setStatus(dto.getStatus3());
		ans3.getQuestion().setId(dto.getQuestionid());
		dao.save(ans3);

		ans4.setId(dto.getId());
		ans4.setAns(dto.getAns4());
		ans4.setStatus(dto.getStatus4());
		ans4.getQuestion().setId(dto.getQuestionid());
		dao.save(ans4);
	}

	public void update(AnswersDto dto) {
		Answers ans1 = new Answers();
		Answers ans2 = new Answers();
		Answers ans3 = new Answers();
		Answers ans4 = new Answers();

		if (dto != null && dto.getId() != 0) {
			ans1.setId(dto.getId());
		}
		ans1.setAns(dto.getAns1());
		ans1.setStatus(dto.getStatus1());
		ans1.getQuestion().setId(dto.getQuestionid());
		dao.update(ans1);

		ans2.setId(dto.getId());
		ans2.setAns(dto.getAns2());
		ans2.setStatus(dto.getStatus2());
		ans2.getQuestion().setId(dto.getQuestionid());
		dao.update(ans2);

		ans3.setId(dto.getId());
		ans3.setAns(dto.getAns3());
		ans3.setStatus(dto.getStatus3());
		ans3.getQuestion().setId(dto.getQuestionid());
		dao.update(ans3);

		ans4.setId(dto.getId());
		ans4.setAns(dto.getAns4());
		ans4.setStatus(dto.getStatus4());
		ans4.getQuestion().setId(dto.getQuestionid());
		dao.update(ans4);
	}

	public List<AnswersDto> findByQid(int id) {
		return dao.findByQid(id);
	}
	
	public List<AnswersDto> correctAns(int id) {
		return dao.correctAns(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void deletebyQid(int id) {
		dao.deletebyQid(id);
	}
}
