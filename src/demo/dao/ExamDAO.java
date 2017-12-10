package demo.dao;

import java.util.*;

import demo.entities.*;

public interface ExamDAO {
    public Exam findById(int id);
    public List<Question> findQuestionsById(int id);
    public List<Exam> findAll();
}
