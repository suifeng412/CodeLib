package hibernate2;

public class UserInfo {
	private int id;

	

	private String name;
 
 	private int uid;
 	
 	private String workPhone;
 	
	private String wechat;

	private int company;

	private int department;

	private int creatorUid;

	private int updatorUid;

	private String remark;
/*
	private String createdTime;
	
	private String updatedTime;
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

 
 	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid){
		this.uid = uid;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
 
	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	
	

	public int getCompany() {
		return this.company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public int getDepartment() {
		return this.department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getCreatorUid() {
		return this.creatorUid;
	}

	public void setCreatorUid(int creatorUid) {
		this.creatorUid = creatorUid;
	}

	public int getUpdatorUid() {
		return this.updatorUid;
	}

	public void setUpdatorUid(int updatorUid) {
		this.creatorUid = updatorUid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
/*
	public String getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	public String getUpdatedTime() {
		return this.updatedTime;
	}
	
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
*/
}
