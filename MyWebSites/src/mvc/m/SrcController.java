package mvc.m;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Src")
public class SrcController {
	
	@RequestMapping("/getSrc.do")
	@ResponseBody
	public ResultState execute(String name) {
		ResultState state=checkUname(name);
		return state;
	}
	public ResultState checkUname(String name) {
		ResultState state=new ResultState();
		if(name=="anonymity"||name==null) {
			state.setStatus(0);
			state.setMsg("请登录后查看");
			return state;
		}
		if(name=="lizhiqiang") {
			state.setStatus(1);
			state.setMsg("管理员登录");
			return state;
		}else
		{
			state.setStatus(2);
			state.setMsg("已登录");
			return state;
		}
		
	}
	
}
