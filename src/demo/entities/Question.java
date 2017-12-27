package demo.entities;

import java.util.*;
import java.util.Set;
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


@Entity
@Table(name = "question", catalog = "onlinequiz")
public class Question implements java.io.Serializable {

    private Integer id;
    private Questiontype questiontype;
    private String content;
    private float grade;
    private List<Answer> answers = new ArrayList<Answer>(0);
    private List<Result> results = new ArrayList<Result>(0);
    private List<Exam> exams = new ArrayList<Exam>(0);

    public Question() {
    }

    public Question(Questiontype questiontype, String content, float grade) {
        this.questiontype = questiontype;
        this.content = content;
        this.grade = grade;
    }

    public Question(Questiontype questiontype, String content, float grade, List<Answer> answers, List<Result> results,
            List<Exam> exams) {
        this.questiontype = questiontype;
        this.content = content;
        this.grade = grade;
        this.answers = answers;
        this.results = results;
        this.exams = exams;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "examquestion", catalog = "onlinequiz", joinColumns = {
            @JoinColumn(name = "questionid", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "examid", nullable = false, updatable = false) })
    public List<Exam> getExams() {
        return this.exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

}
