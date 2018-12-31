package ACM;

public class Question {
	private String status = "";
	private String qNo = "";
	private int totalTime = 0;
	
	public Question(int time, String qNo, String status){
		setStatus(status);
		setQ(qNo);
		setTotalTime(time);
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public void setQ(String q){
		this.qNo = q;
	}
	
	public void setTotalTime(int time){
		this.totalTime += time;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public String getQ(){
		return this.qNo;
	}
	
	public int getTotalTime(){
		return this.totalTime;
	}
}
