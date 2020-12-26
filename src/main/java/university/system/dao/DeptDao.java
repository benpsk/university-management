package university.system.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.system.dto.DeptDto;
import university.system.model.Department;

@Repository
public class DeptDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public DeptDto deptByID(int id) {
		Criteria cr = getSession().createCriteria(Department.class);
		cr.add(Restrictions.eq("id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		cr.setResultTransformer(Transformers.aliasToBean(DeptDto.class));
		return (DeptDto) cr.uniqueResult();
	}

	public void addDept(Department dept) {
		getSession().saveOrUpdate(dept);
	}

	public void upDept(Department dept) {
		getSession().update(dept);
	}

	public void delDept(int id) {
		Department dept = getSession().load(Department.class, id);
		if (dept != null) {
			getSession().delete(dept);
		}
	}

	@SuppressWarnings("unchecked")
	public List<DeptDto> getDept() {
		Criteria cr = getSession().createCriteria(Department.class);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		cr.setResultTransformer(Transformers.aliasToBean(DeptDto.class));
		return (List<DeptDto>) cr.list();
	}
}


//@SuppressWarnings("unchecked")
//public List<DeptDto> getDept() {
//	Criteria cr = getSession().createCriteria(DeptDto.class);
//	return (List<DeptDto>) cr.list();
//}

//@SuppressWarnings("deprecation")
//public void delDept(int id) {
//	Serializable ide = new Integer(id);
//	Object obj = getSession().load(DeptDto.class, ide);
//	if (obj != null) {
//		getSession().delete(obj);
//	}
//}

//public DeptDto deptByID(int id) {
//Criteria cr = getSession().createCriteria(DeptDto.class);
//cr.add(Restrictions.eq("id", id));
//return (DeptDto) cr.uniqueResult();
//}