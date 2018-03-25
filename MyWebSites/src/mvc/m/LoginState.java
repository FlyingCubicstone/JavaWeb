package mvc.m;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 每1小时对用户进行一次注销操作
 */
@Controller
@RequestMapping("/m")
public class LoginState{
	
	@Resource
	private countLoginService cls;
	@Resource
	private LogoutService ls;
	private String c_name;
	
	@RequestMapping("/LoginState.do")
	public void execute(String name) {
		if(name!="anonymity"||name!=null) {
		this.c_name=name;
		Timer time =new Timer();
		time.schedule(new TimerTask() {
			public void run() {
				ls.dodeltoken(c_name);
				c_name="anonymity";
			}
		}, 3600000);
		
		}
		cls.saveLoginUser(name);
	}
	@RequestMapping("/askforname.do")
	@ResponseBody
	public DataPass_1 execute() {
		DataPass_1 dp=new DataPass_1();
		dp.setMsg(c_name);
		
		return dp;
	}
	@RequestMapping("/unbindname.do")

	public void execute(int i) {
		c_name="anonymity";
	}
	
}
