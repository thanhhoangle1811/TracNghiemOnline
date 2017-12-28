package demo.dao;

import java.util.List;

import demo.entities.*;

public interface ResultDAO {
    public int storeResult(Result result);
    
    public List<Result> findAll();
}
