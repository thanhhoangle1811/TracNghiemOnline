package demo.entities;


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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "accountexam", catalog = "onlinequiz")
public class AccountExam implements java.io.Serializable {

    private Integer id;
    private Account account;
    private Exam exam;
    private Date doingDate;
    private float grade;
    private List<Result> results = new ArrayList<Result>();

    public AccountExam() {
    }

    public AccountExam(Account account, Exam exam, Date doingDate, float grade) {
        this.account = account;
        this.exam = exam;
        this.doingDate = doingDate;
        this.grade = grade;
    }

    public AccountExam(Account account, Exam exam, Date doingDate, float grade, List<Result> results) {
        this.account = account;
        this.exam = exam;
        this.doingDate = doingDate;
        this.grade = grade;
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
    @JoinColumn(name = "accountid", nullable = false)
    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examid", nullable = false)
    public Exam getExam() {
        return this.exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "doingDate", nullable = false, length = 0)
    public Date getDoingDate() {
        return this.doingDate;
    }

    public void setDoingDate(Date doingDate) {
        this.doingDate = doingDate;
    }

    @Column(name = "grade", nullable = false, precision = 12, scale = 0)
    public float getGrade() {
        return this.grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountexam")
    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
