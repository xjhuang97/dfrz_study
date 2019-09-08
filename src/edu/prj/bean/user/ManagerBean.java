package edu.prj.bean.user;

/**
 * <p>Title: ManagerBean</p>
 * <p>Description: 管理员bean类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月28日
 */
public class ManagerBean extends UserBean{
	/**
	 * <p>Description: 获得管理员ID</p>
	 * <p>Title: getManagerID</p>
	 * @return
	 */
	public Long getManagerID() {
		return this.getID();
	}
	
	/**
	 * <p>Description: 设置管理员ID</p>
	 * <p>Title: setManagerID</p>
	 * @param managerID
	 */
	public void setManagerID(Long managerID) {
		this.setID(managerID);
	}
	
	/**
	 * <p>Description: 介绍</p>
	 * <p>Title: introduce</p>
	 */
	public void introduce() {
		System.out.println("【管理员】"+this.getNickname());
	}
}
