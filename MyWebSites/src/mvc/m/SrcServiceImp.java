package mvc.m;

import org.springframework.stereotype.Service;

@Service
public class SrcServiceImp implements SrcService{
	public ResultState checkUname(String name) {
		ResultState state=new ResultState();
		if(name=="anonymity") {
			state.setStatus(0);
			state.setMsg("δ��¼");
			return state;
		}
		if(name=="lizhiqiang") {
			state.setStatus(1);
			state.setMsg("����Ա��¼");
			return state;
		}
		else
			state.setStatus(2);
			state.setMsg("�ѵ�¼");
		return state;
	}
}
