package mvc.dao;

import java.util.List;

import mvc.m.User;
import mvc.m.Visitor;

public interface SqlMapper {
	public List<User> findAll();
	public User findByName(String name);
	public void save(User user);
	public void createtoken(User user);
	public void countvisitor(Visitor visitor);
	public void deltoken(String name);
	public Integer countall();
}
