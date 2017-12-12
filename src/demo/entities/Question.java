package demo.entities;
// Generated Dec 10, 2017 12:25:33 PM by Hibernate Tools 5.2.0.Beta1

import demo.entities.*;
import java.util.ArrayList;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Question generated by hbm2java
 */
@Entity
@Table(name = "question", catalog = "onlinequiz")
public class Question implements java.io.Serializable {

	private Integer id;
	private Exam exam;
	private Questiontype questiontype;
	private String content;
	private float grade;
	private List<Answer> answers = new ArrayList<Answer>(0);
	private List<Result> results = new ArrayList<Result>(0);

	public Question() {
	}

	public Question(Questiontype questiontype, String content, float grade) {
		this.questiontype = questiontype;
		this.content = content;
		this.grade = grade;
	}

	public Question(Exam exam, Questiontype questiontype, String content, float grade, List<Answer> answers,
			List<Result> results) {
		this.exam = exam;
		this.questiontype = questiontype;
		this.content = content;
		this.grade = grade;
		this.answers = answers;
		this.results = results;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "examid")
	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questiontypeid", nullable = false)
	public Questiontype getQuestiontype() {
		return this.questiontype;
	}

	public void setQuestiontype(Questiontype questiontype) {
		this.questiontype = questiontype;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "grade", nullable = false, precision = 12, scale = 0)
	public float getGrade() {
		return this.grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}