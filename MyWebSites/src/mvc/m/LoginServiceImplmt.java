package mvc.m;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import mvc.dao.SqlMapper;

@Service
public class LoginServiceImplmt implements LoginService{
	@Resource
	private SqlMapper sqm;
	public ResultState loginCheck(String name,String pwd) {
		ResultState state=new ResultState();
		User user=sqm.findByName(name);
		if(user==null) {
			state.setStatus(0);
			state.setMsg("账号不存在");
			return state;
		}
		if(!user.getPassword().equals(pwd)) {
			state.setMsg("密码不正确");
			state.setStatus(1);
			return state;
		}
		if(user.getToken()!=null) {
			state.setStatus(3);
			state.setMsg("重复登录");
			return state;
		}
		Integer token=(int) (Math.random()*999999+100000);
		user.setToken(token);
		sqm.createtoken(user);
		state.setStatus(2);
		state.setMsg("用户名和密码匹配");
		state.setData(token);
		
		return state;
	}
	
}
