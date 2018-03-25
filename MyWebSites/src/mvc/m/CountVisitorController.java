package mvc.m;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/count")
public class CountVisitorController {
	
	@Resource 
	private CountVisitorService scvc;
	@RequestMapping("/count.do")
	@ResponseBody
	public DataPass execute() {
		DataPass state=scvc.countuser();
		return state;
}
}
