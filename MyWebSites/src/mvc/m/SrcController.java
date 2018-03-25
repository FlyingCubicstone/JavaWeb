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
			state.setMsg("���¼��鿴");
			return state;
		}
		if(name=="lizhiqiang") {
			state.setStatus(1);
			state.setMsg("����Ա��¼");
			return state;
		}else
		{
			state.setStatus(2);
			state.setMsg("�ѵ�¼");
			return state;
		}
		
	}
	
}
