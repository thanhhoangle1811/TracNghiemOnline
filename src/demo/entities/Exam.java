package demo.entities;
// Generated Dec 10, 2017 12:25:33 PM by Hibernate Tools 5.2.0.Beta1

import demo.entities.*;
import java.util.Date;
import java.util.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Exam generated by hbm2java
 */
@Entity
@Table(name = "exam", catalog = "onlinequiz")
public class Exam implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String name;
	private Date time;
	private List<Result> results = new ArrayList<Result>();
	private List<Question> questions = new ArrayList<Question>();

	public Exam() {
	}

	public Exam(Category category, String name, Date time) {
		this.category = category;
		this.name = name;
		this.time = time;
	}

	public Exam(Category category, String name, Date time, List<Result> results, List<Question> questions) {
		this.category = category;
		this.name = name;
		this.time = time;
		this.results = results;
		this.questions = questions;
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
	@JoinColumn(name = "categoryid", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "time", nullable = false, length = 0)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exam")
	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "examquestion", catalog = "onlinequiz", joinColumns = {
			@JoinColumn(name = "examid", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "questionid",
					nullable = false, updatable = false) })
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
