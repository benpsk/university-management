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

import university.system.dto.StudentDto;
import university.system.model.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addStd(Student std) {
		getSession().saveOrUpdate(std);
	}

	public void upStd(Student std) {
		getSession().update(std);
	}

	public void delStd(int id) {
		Object obj = getSession().load(Student.class, id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	public StudentDto getStdByID(int id) {
		Criteria cr = getSession().createCriteria(Student.class);
		cr.createAlias("grade", "g", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name").add(Projections.property("rollno"), "rollno")
				.add(Projections.property("g.id"), "gradeid").add(Projections.property("g.name"), "gradename"));
		cr.setResultTransformer(Transformers.aliasToBean(StudentDto.class));
		return (StudentDto) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<StudentDto> getStd() {
		Criteria cr = getSession().createCriteria(Student.class);
		cr.createAlias("grade", "g", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name").add(Projections.property("rollno"), "rollno")
				.add(Projections.property("g.id"), "gradeid").add(Projections.property("g.name"), "gradename"));
		cr.setResultTransformer(Transformers.aliasToBean(StudentDto.class));
		return (List<StudentDto>) cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<StudentDto> filterGrade(int id) {
		Criteria cr = getSession().createCriteria(Student.class);
		cr.createAlias("grade", "g", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("g.id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name").add(Projections.property("rollno"), "rollno")
				.add(Projections.property("g.id"), "gradeid").add(Projections.property("g.name"), "gradename"));
		cr.setResultTransformer(Transformers.aliasToBean(StudentDto.class));
		return (List<StudentDto>) cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<StudentDto> getByGradeId(int gid) {
		Criteria cr = getSession().createCriteria(Student.class);
		cr.createAlias("grade", "g", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("g.id", gid));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name").add(Projections.property("g.id"), "gradeid")
				.add(Projections.property("g.name"), "gradename").add(Projections.property("rollno"), "rollno"));
		cr.setResultTransformer(Transformers.aliasToBean(StudentDto.class));
		return (List<StudentDto>) cr.list();
	}
}
