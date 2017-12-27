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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "answer", catalog = "onlinequiz")
public class Answer implements java.io.Serializable {

    private Integer id;
    private Question question;
    private String content;
    private boolean istrue;
    private String prefix;
    private List<Result> results = new ArrayList<Result>(0);

    public Answer() {
    }

    public Answer(Question question, String content, boolean istrue) {
        this.question = question;
        this.content = content;
        this.istrue = istrue;
    }

    public Answer(Question question, String content, boolean istrue, String prefix, List<Result> results) {
        this.question = question;
        this.content = content;
        this.istrue = istrue;
        this.prefix = prefix;
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
    @JoinColumn(name = "questionid", nullable = false)
    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Column(name = "content", nullable = false, length = 1000)
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "istrue", nullable = false)
    public boolean isIstrue() {
        return this.istrue;
    }

    public void setIstrue(boolean istrue) {
        this.istrue = istrue;
    }

    @Column(name = "prefix", length = 1)
    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "answer")
    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
