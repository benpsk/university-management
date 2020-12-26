package university.system.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import university.system.dao.AttendDao;
import university.system.dto.AttListDto;
import university.system.model.Attendance;

@Service
@Transactional
public class AttendServices {

	@Autowired
	AttendDao attDao;

	public void save(AttListDto dto) {
		dto.getAttList().stream().forEach(a -> {
			Attendance att = new Attendance();
			att.getStd().setId(a.getStudentid());
			att.setStatus(a.getStatus());
			att.setDate(dto.getDate());
			attDao.save(att);
		});
	}

	public List<AttListDto> findAll() {
		return attDao.findAll();
	}

	public List<AttListDto> findByDate(Date date) {
		return attDao.findByDate(date);
	}

}
