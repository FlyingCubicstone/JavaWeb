package mvc.m;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mvc.dao.SqlMapper;

@Service
public class CountVisitorServiceImp implements CountVisitorService {
	
	
	@Resource
	private SqlMapper sql;
	
	public DataPass countuser() {
		DataPass dp=new DataPass();
		Integer count=sql.countall();
		dp.setMsg(count);
		return dp;
	}
}
