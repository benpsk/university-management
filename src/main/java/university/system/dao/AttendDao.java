package university.system.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import university.system.dto.AttListDto;
import university.system.model.Attendance;

@Repository
public class AttendDao {

	@Autowired
	SessionFactory sesionFactory;

	public Session getSession() {
		return sesionFactory.getCurrentSession();
	}

	public void save(Attendance att) {
		getSession().save(att);
	}

	@SuppressWarnings("unchecked")
	public List<AttListDto> findAll() {
		Criteria cr = getSession().createCriteria(Attendance.class);
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("date"), "date").add(Projections.property("status"), "status")
				.add(Projections.property("s.name"), "studentname").add(Projections.property("s.rollno"), "rollno"));
		cr.setResultTransformer(Transformers.aliasToBean(AttListDto.class));
		return (List<AttListDto>) cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<AttListDto> findByDate(Date date) {
		Criteria cr = getSession().createCriteria(Attendance.class);
		cr.createAlias("std", "s", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("date", date));
		cr.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
				.add(Projections.property("date"), "date").add(Projections.property("status"), "status")
				.add(Projections.property("s.name"), "studentname").add(Projections.property("s.rollno"), "rollno"));
		cr.setResultTransformer(Transformers.aliasToBean(AttListDto.class));
		return (List<AttListDto>) cr.list();
	}

}
