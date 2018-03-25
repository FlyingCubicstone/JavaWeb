package mvc.m;

import org.springframework.stereotype.Service;

@Service
public class SrcServiceImp implements SrcService{
	public ResultState checkUname(String name) {
		ResultState state=new ResultState();
		if(name=="anonymity") {
			state.setStatus(0);
			state.setMsg("未登录");
			return state;
		}
		if(name=="lizhiqiang") {
			state.setStatus(1);
			state.setMsg("管理员登录");
			return state;
		}
		else
			state.setStatus(2);
			state.setMsg("已登录");
		return state;
	}
}
