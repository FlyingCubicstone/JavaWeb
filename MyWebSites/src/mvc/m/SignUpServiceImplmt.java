package mvc.m;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mvc.dao.SqlMapper;
@Service
public class SignUpServiceImplmt implements SignUpService {
	@Resource
	private SqlMapper smp;
	public ResultState checkSignUp(String name ,String password) {
		
		ResultState state=new ResultState();
		User user=smp.findByName(name);
		if(user!=null) {
			state.setStatus(0);
			state.setMsg("账户占用");
			return state;
		}else {
			User save_user=new User();
			save_user.setUsername(name);
			save_user.setPassword(password);
			smp.save(save_user);
			state.setStatus(1);
			state.setMsg("账户可用");
			return state;
		}
		
	}
}
