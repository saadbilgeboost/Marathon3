package com.saad.main;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.saad.entity.Answer;
import com.saad.entity.ERole;
import com.saad.entity.Lesson;
import com.saad.entity.Question;
import com.saad.entity.Subject;
import com.saad.entity.SubjectDetail;
import com.saad.entity.User;
import com.saad.utility.HibernateUtils;

public class Implement {
	private static CriteriaBuilder builder;
	private static EntityManager entityManager;
	private static Transaction tt;
	private static Session ss;

	public static void ImplData() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		builder = entityManager.getCriteriaBuilder();
		ss = HibernateUtils.getSessionFactory().openSession();
		tt = ss.beginTransaction();
		User user1 = new User("David", "Mohammad", ERole.USER, new Date(), null, true);
		User user2 = new User("Moses", "Khan", ERole.EDITOR, new Date(), null, true);
		User user3 = new User("Noha", "Fateh", ERole.USER, new Date(), null, true);
		User user4 = new User("Elizabeth", "Howling", ERole.EDITOR, new Date(), null, true);
		User user5 = new User("Tony", "Blair", ERole.EDITOR, new Date(), null, true);

		Lesson lesson1 = new Lesson("Java",
				"Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.",
				new Date(), null, true);
		Lesson lesson2 = new Lesson("C#", "C# is a general-purpose, multi-paradigm programming language.", new Date(),
				null, true);
		ss.save(lesson1);
		ss.save(lesson2);
		ss.save(user3);
		ss.save(user1);

		Subject subject1 = new Subject("OOP", lesson1, new Date(), null, true);
		Subject subject2 = new Subject("React", lesson1, new Date(), null, true);
		Subject subject3 = new Subject("Spring", lesson1, new Date(), null, true);
		Subject subject4 = new Subject("Javascript", lesson1, new Date(), null, true);

		Subject subject5 = new Subject("OOP", lesson2, new Date(), null, true);
		Subject subject6 = new Subject("Functions", lesson2, new Date(), null, true);
		Subject subject7 = new Subject("Inheritance", lesson2, new Date(), null, true);

		SubjectDetail subjectDetail1 = new SubjectDetail(subject1, user2, "Functions", "Arithmetic",
				"Addition, Subraction, Multiplication, and Division Functions.", new Date(), null, true);
		SubjectDetail subjectDetail2 = new SubjectDetail(subject2, user2, "ReactJS",
				"When creating a React component, the component's name MUST start with an upper case letter.",
				"Class Component, Function Component, Rendering a Component, Props, Components in Components, Components in Files",
				new Date(), null, true);
		SubjectDetail subjectDetail3 = new SubjectDetail(subject3, user5, "Spring", "Java Spring Framework",
				"The Spring framework consists of seven modules which are shown in the above Figure. These modules are Spring Core, Spring AOP, Spring Web MVC, Spring DAO, Spring ORM, Spring context, and Spring Web flow.",
				new Date(), null, true);
		SubjectDetail subjectDetail4 = new SubjectDetail(subject4, user4, "Javascript",
				"It is used for Frontend Programming.",
				"JavaScript, often abbreviated JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS.",
				new Date(), null, true);
		SubjectDetail subjectDetail5 = new SubjectDetail(subject5, user5, "OOP", "XDFIHFASIDHIASJDIAJD",
				"sbhjdbaidjuiasghsbfodjfuigahfbjkajdpoidfyuvfhjdbkbmpofjiowhdwehfbjkdnger", new Date(), null, true);
		SubjectDetail subjectDetail6 = new SubjectDetail(subject6, user4, "Functions", "Mathematical Functions",
				"Addition, Subraction, Multiplication, and Division Functions.", new Date(), null, true);
		SubjectDetail subjectDetail7 = new SubjectDetail(subject7, user4, "Inheritance", "What is Inheritance?",
				"Inheritance in Java is a concept that acquires the properties from one class to other classes; for example, the relationship between father and son. Inheritance in Java is a process of acquiring all the behaviours of a parent object.",
				new Date(), null, true);
		ss.save(subjectDetail1);
		ss.save(subjectDetail2);
		ss.save(subjectDetail3);
		ss.save(subjectDetail4);
		ss.save(subjectDetail5);
		ss.save(subjectDetail6);
		ss.save(subjectDetail7);

		Question question1 = new Question(subjectDetail2, user3, "React Question", "What is React?", new Date(), null,
				true);
		Question question2 = new Question(subjectDetail2, user1, "React Question 2", "What are components of React?",
				new Date(), null, true);
		Question question3 = new Question(subjectDetail3, user1, "Spring", "What is Spring Framework?", new Date(),
				null, true);
		Question question4 = new Question(subjectDetail5, user3, "OOP", "What is OOP?", new Date(), null, true);
		ss.save(question1);
		ss.save(question2);
		ss.save(question3);
		ss.save(question4);

		Answer answer1 = new Answer(question1, subjectDetail2.getUser(), "React is ABC", new Date(), null, true);
		Answer answer2 = new Answer(question3, subjectDetail3.getUser(), "SpringFramework is ABC", new Date(), null,
				true);
		Answer answer3 = new Answer(question2, subjectDetail2.getUser(), "React components are 1, 2, 3", new Date(),
				null, true);
		Answer answer4 = new Answer(question4, subjectDetail5.getUser(), "OOP is ABC", new Date(), null, true);
		ss.save(answer1);
		ss.save(answer2);
		ss.save(answer3);
		ss.save(answer4);

		tt.commit();
		ss.close();

	}

// It finds the user with most articles. The resulting table would contain columns of user id, user name, user surname and number of articles published 
	public static Object UserWithMostArticles() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		return entityManager.createNativeQuery(
				"select  sd.user_id, u.name, u.surname, count(sd.user_id) as articles_published from tbl_subjectdetail as sd inner join tbl_user as u on sd.user_id = u.id group by u.name, u.surname, sd.user_id order by articles_published desc limit 1")
				.getSingleResult();
	}

//It finds the Lesson in which most of the questions are asked.
	public static Object QuestionsUsuallyAskedInWhichSubject() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		return entityManager.createNativeQuery(
				"select l.name as lesson_name, count(q.user_id) as no_of_questions from tbl_question as q inner join tbl_subjectdetail as sd on q.subjectdetail_id = sd.id inner join tbl_subject as s on sd.subject_id=s.id inner join tbl_lesson as l on s.lesson_id = l.id group by l.name order by no_of_questions desc limit 1")
				.getSingleResult();
	}

//It finds the number of editors that have written articles in more then 1 lesson. 
	public static Object editorWithArticleInMoreThenOneLesson() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		return entityManager.createNativeQuery(
				"select count(*) as editors_with_articles_in_more_then_1_Lesson from (select sd.user_id, count(distinct(lesson_id)) from tbl_subjectdetail as sd inner join tbl_subject as s on sd.subject_id=s.id group by sd.user_id) as tbl_combine where tbl_combine.count>1")
				.getSingleResult();
	}

//It finds the editor who has answered the question in least amount of time. This method does not take the avg it only finds the Editor that has answered any question in least amount of time.
	public static Object fastestEditortoAnswerQuestion() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		return entityManager.createNativeQuery(
				"select EXTRACT(EPOCH FROM (ans.createddate - q.createddate)) AS difference, ans.user_id, u.name, u.surname  from tbl_answer as ans inner join tbl_question as q on ans.question_id = q.id inner join tbl_user as u on u.id = ans.user_id group by ans.user_id, ans.createddate, q.createddate, u.name, u.surname order by difference asc limit 1")
				.getSingleResult();
	}

//It finds the articles where the title does not exist in the text of the article.
	public static List<Object> articlesListWithNoTitleInTheText() {
		entityManager = HibernateUtils.getSessionFactory().createEntityManager();
		return entityManager
				.createNativeQuery(
						"select * from tbl_subjectdetail as sd where sd.article not ilike '%'|| sd.title ||'%'")
				.getResultList();
	}
}