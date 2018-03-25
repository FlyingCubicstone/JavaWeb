package mvc.m;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mvc.dao.SqlMapper;
@Service
public class countLoginServiceImp implements countLoginService{
	@Resource
	private SqlMapper sql;
	public void saveLoginUser(String name) {
		//将访问者的用户名、ip和登录时间封装成Visitor对象，存入count_user数据库中
				
				if(name!=null) {
					
					String LoginTime=getCurrentDate();	
					
					Visitor visitor =new Visitor();
					
					visitor.setLogintime(LoginTime);
					visitor.setUsername(name);
					sql.countvisitor(visitor);
					
		
	}}
	
	//获取登录日期及时间
		public String getCurrentDate() {
			Date date=new Date();
			String dateformat="yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf=new SimpleDateFormat(dateformat);
			String str=sdf.format(date);
			return str;
		}
}
