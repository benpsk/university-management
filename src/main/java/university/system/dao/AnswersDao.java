package university.system.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.system.dto.AnswersDto;
import university.system.model.Answers;

@Repository
public class AnswersDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Answers ans) {
		getSession().saveOrUpdate(ans);
	}

	@SuppressWarnings("unchecked")
	public List<AnswersDto> findByQid(int id) {
		Criteria cr = getSession().createCriteria(Answers.class);
		cr.createAlias("question", "q", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("q.id", id));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("ans"), "ans1").add(Projections.property("status"), "status1"));
		cr.setResultTransformer(Transformers.aliasToBean(AnswersDto.class));
		return (List<AnswersDto>) cr.list();
	}

	public void update(Answers ans) {
		getSession().update(ans);
	}

	public void delete(int id) {
		Answers ans = getSession().load(Answers.class, id);
		if (ans != null) {
			getSession().delete(ans);
		}
	}

	public void deletebyQid(int id) {
		String sql = "DELETE FROM Answers WHERE question_id=:qid";
		Query q = getSession().createQuery(sql);
		q.setParameter("qid", id);
		q.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<AnswersDto> correctAns(int id) {
		Criteria cr = getSession().createCriteria(Answers.class);
		cr.createAlias("question", "q", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("q.id", id));
		cr.add(Restrictions.eq("status", true));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("ans"), "ans1").add(Projections.property("status"), "status1"));
		cr.setResultTransformer(Transformers.aliasToBean(AnswersDto.class));
		return (List<AnswersDto>) cr.list();
	}
}
