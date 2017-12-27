package demo.entities;


import java.util.*;
import java.util.ArrayList;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "exam", catalog = "onlinequiz")
public class Exam implements java.io.Serializable {

    private Integer id;
    private Category category;
    private String name;
    private Date time;
    private List<Question> questions = new ArrayList<Question>(0);
    private List<AccountExam> accountexams = new ArrayList<AccountExam>(0);

    public Exam() {
    }

    public Exam(Category category, String name, Date time) {
        this.category = category;
        this.name = name;
        this.time = time;
    }

    public Exam(Category category, String name, Date time, List<Question> questions, List<AccountExam> accountexams) {
        this.category = category;
        this.name = name;
        this.time = time;
        this.questions = questions;
        this.accountexams = accountexams;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "examquestion", catalog = "onlinequiz", joinColumns = {
            @JoinColumn(name = "examid", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "questionid", nullable = false, updatable = false) })
    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exam")
    public List<AccountExam> getAccountexams() {
        return this.accountexams;
    }

    public void setAccountexams(List<AccountExam> accountexams) {
        this.accountexams = accountexams;
    }

}
