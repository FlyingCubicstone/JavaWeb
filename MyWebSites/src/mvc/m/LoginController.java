package mvc.m;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.m.LoginService;
import mvc.m.ResultState;
@Controller
@RequestMapping("/m")
public class LoginController {
	@Resource
	
	private LoginService lgsvc;
	@RequestMapping("/login.do")
	@ResponseBody
	public ResultState execute(String name,String pwd) {
		ResultState state=lgsvc.loginCheck(name, pwd);
		
		return state;
	}
	
}
