package demo.services;

import java.util.List;

import demo.entities.*;

public interface ExamService {
    public Exam findById(int id);
    public List<Exam> findAll();
    public List<Question> findQuestionsById(int id);
}
