package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.ResultDao;
import university.system.dto.ResultDto;
import university.system.model.Result;

@Service
@Transactional
public class ResultServices {

	@Autowired
	ResultDao resultDao;

	public void save(ResultDto dto) {
		Result result = new Result();

		if (dto != null) {
			result.setId(dto.getId());
		}
		result.getStd().setId(dto.getStudentid());
		result.getExtype().setId(dto.getExamtypeid());
		result.setMark(dto.getMark());
		result.getQuestion().setId(dto.getQuestionid());
		result.getAnswers().setId(dto.getAnswerid());
		resultDao.save(result);
	}

	public List<ResultDto> findAll() {
		return resultDao.findAll();
	}

	public List<ResultDto> findByEtypeId(Integer eid, Integer gid) {
		return resultDao.findByEtypeId(eid, gid);
	}

	public ResultDto findByStdid(int id) {
		return resultDao.findByStdid(id);
	}

	public List<ResultDto> findStd(int id) {
		return resultDao.findStd(id);
	}

}
