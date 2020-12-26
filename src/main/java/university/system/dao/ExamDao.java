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

import university.system.dto.ExamDto;
import university.system.model.Exam;

@Repository
public class ExamDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addExam(Exam e) {
		getSession().saveOrUpdate(e);
	}

	@SuppressWarnings("unchecked")
	public List<ExamDto> getExam() {
		Criteria cr = getSession().createCriteria(Exam.class);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		cr.setResultTransformer(Transformers.aliasToBean(ExamDto.class));
		return (List<ExamDto>) cr.list();
	}

	public ExamDto findById(int id) {
		Criteria cr = getSession().createCriteria(Exam.class);
		cr.add(Restrictions.eq("id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		cr.setResultTransformer(Transformers.aliasToBean(ExamDto.class));
		return (ExamDto) cr.uniqueResult();
	}

	public void delete(int id) {
		Exam e = getSession().load(Exam.class, id);
		if (e != null) {
			getSession().delete(e);
		}
	}

	public void update(Exam e) {
		getSession().update(e);
	}
}
