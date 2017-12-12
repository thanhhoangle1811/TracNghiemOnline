package demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import demo.dao.QuestionTypeDAO;
import demo.entities.*;
@Service("questionTypeService")
@Transactional
public class QuestionTypeServiceImpl implements QuestionTypeService{

	@Autowired
	private QuestionTypeDAO questionTypeDAO;

	@Override
	public List<Questiontype> findAll() {
		return questionTypeDAO.findAll();
	}
	
}
