package university.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.system.dao.DeptDao;
import university.system.dto.DeptDto;
import university.system.model.Department;

@Service
@Transactional
public class DepartServices {

	@Autowired
	DeptDao deptDao;

	public DeptDto deptByID(int id) {
		return deptDao.deptByID(id);
	}

	public void addDept(DeptDto dep) {
		Department dept = new Department();
		if (dep != null && dep.getName() != null) {
			dept.setId(dep.getId());
		}
		dept.setName(dep.getName());
		deptDao.addDept(dept);
	}

	public void upDept(DeptDto deptDto) {
		Department dept = new Department();
		if (deptDto != null && deptDto.getName() != null) {
			dept.setId(deptDto.getId());
		}
		dept.setName(deptDto.getName());
		deptDao.upDept(dept);
	}

	public void delDept(int id) {
		deptDao.delDept(id);
	}

	public List<DeptDto> getDept() {
		return deptDao.getDept();
	}
}
