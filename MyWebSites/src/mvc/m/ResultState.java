package mvc.m;

public class ResultState {
	private int status;
	private String msg;
	private int data;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
