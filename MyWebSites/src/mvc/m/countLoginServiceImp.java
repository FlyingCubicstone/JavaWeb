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
		//�������ߵ��û�����ip�͵�¼ʱ���װ��Visitor���󣬴���count_user���ݿ���
				
				if(name!=null) {
					
					String LoginTime=getCurrentDate();	
					
					Visitor visitor =new Visitor();
					
					visitor.setLogintime(LoginTime);
					visitor.setUsername(name);
					sql.countvisitor(visitor);
					
		
	}}
	
	//��ȡ��¼���ڼ�ʱ��
		public String getCurrentDate() {
			Date date=new Date();
			String dateformat="yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf=new SimpleDateFormat(dateformat);
			String str=sdf.format(date);
			return str;
		}
}
