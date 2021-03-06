package demo.entities;


import java.util.*;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "questiontype", catalog = "onlinequiz")
public class Questiontype implements java.io.Serializable {

    private Integer id;
    private String name;
    private List<Question> questions = new ArrayList<Question>(0);

    public Questiontype() {
    }

    public Questiontype(String name) {
        this.name = name;
    }

    public Questiontype(String name, List<Question> questions) {
        this.name = name;
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

    @Column(name = "name", nullable = false, length = 250)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questiontype")
    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
