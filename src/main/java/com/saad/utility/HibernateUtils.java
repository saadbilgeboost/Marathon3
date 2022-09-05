
package com.saad.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saad.entity.Answer;
import com.saad.entity.Lesson;
import com.saad.entity.Question;
import com.saad.entity.Subject;
import com.saad.entity.SubjectDetail;
import com.saad.entity.User;

public class HibernateUtils {

	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Answer.class);
			configuration.addAnnotatedClass(Lesson.class);
			configuration.addAnnotatedClass(Question.class);
			configuration.addAnnotatedClass(Subject.class);
			configuration.addAnnotatedClass(SubjectDetail.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
