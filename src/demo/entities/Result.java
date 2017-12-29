package demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "result", catalog = "onlinequiz")
public class Result implements java.io.Serializable {

    private Integer id;
    private AccountExam accountexam;
    private Answer answer;
    private Question question;

    public Result() {
    }

    public Result(AccountExam accountexam, Answer answer, Question question) {
        this.accountexam = accountexam;
        this.answer = answer;
        this.question = question;
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
    @JoinColumn(name = "accExamid", nullable = false)
    public AccountExam getAccountexam() {
        return this.accountexam;
    }

    public void setAccountexam(AccountExam accountexam) {
        this.accountexam = accountexam;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answerid", nullable = false)
    public Answer getAnswer() {
        return this.answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionid", nullable = false)
    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
