package mvc.m;

public class Visitor {
	private String username;
	private String ip=" ";
	private String logintime;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	@Override
	public String toString() {
		return "Visitor [username=" + username + ", ip=" + ip + ", logintime=" + logintime + "]";
	}
	
}
