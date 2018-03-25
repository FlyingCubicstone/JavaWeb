package mvc.m;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/m")
public class SignUpController {
	@Resource
	
	private SignUpService signupservice;
	@RequestMapping("/signup.do")
	@ResponseBody
	public ResultState execute(String name,String pwd) {
		ResultState state=signupservice.checkSignUp(name,pwd);
		return state;
	}
}
