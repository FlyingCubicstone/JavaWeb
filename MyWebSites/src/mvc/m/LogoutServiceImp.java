package mvc.m;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mvc.dao.SqlMapper;

@Service
public class LogoutServiceImp implements LogoutService {
	@Resource 
	private SqlMapper smp;
	public DataPass_1 dodeltoken(String name){
		smp.deltoken(name);
		DataPass_1 dp1=new DataPass_1();
        dp1.setMsg("×¢Ïú³É¹¦");
		
		return dp1;
	}
	
}
