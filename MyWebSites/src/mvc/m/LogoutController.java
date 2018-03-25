package mvc.m;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Logout")
public class LogoutController {
	@Resource
	private LogoutService lsvc;
	@RequestMapping("/Logout.do")
	@ResponseBody
	private DataPass_1 execute(String name) {
		DataPass_1 dp1=lsvc.dodeltoken(name);
		return dp1;
		
				
	}
}
