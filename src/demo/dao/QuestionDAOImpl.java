package demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.Answer;
import demo.entities.Category;
import demo.entities.Exam;
import demo.entities.Question;
@SuppressWarnings("unchecked")
@Repository("questionDAO")
public class QuestionDAOImpl implements QuestionDAO{
	@Autowired
	private SessionFactory sessionFactory;

	
	public Question findById(int questionId) {
	    Question result = null;
	    Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Question q where q.id = :id");
            query.setParameter("id", questionId);
            result = (Question) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
	    return result;
	}

	@Override
    public boolean updateQuestion(Question question) {
	    boolean result = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            int id = question.getId();
            session.saveOrUpdate(question);
            List<Answer> answers = question.getAnswers();
            if(answers != null && answers.size() != 0){
                for (int i =0; i < answers.size();i++) {
                    answers.get(i).setQuestion(question);
                    session.saveOrUpdate(answers.get(i));
                }
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }



    @Override
	public boolean createQuestion(Question question) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			int questionId = (int) session.save(question);
			question.setId(questionId);
			List<Answer> answers = question.getAnswers();
			if(answers != null && answers.size() != 0){
				for (int i =0; i < answers.size();i++) {
					answers.get(i).setQuestion(question);
					session.save(answers.get(i));
				}
			}
			transaction.commit();
			result = true;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}



	@Override
	public List<Question> findByExam(int examId) {
		// TODO Auto-generated method stub
		List<Question> questions = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Exam e where e.id = :id");
			query.setParameter("id", examId);
			questions = (List<Question>) query.list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return questions;
	}

	
}
