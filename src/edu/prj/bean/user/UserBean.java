package edu.prj.bean.user;

/**
 * <p>Title: UserBean</p>
 * <p>Description: 使用者bean类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月28日
 */
public class UserBean {
	/** 使用者ID */
	private Long id;
	/** 账号 */
	private String loginName;
	/** 密码 */
	private String loginPass;
	/** 昵称 */
	private String nickname;
	/** 是否禁用 */
	private Integer isDisabled;
	/** 图片路径 */
	private String urlPicture;
	
	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getLoginPass() {
		return loginPass;
	}
	
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * <p>Description: 获得当前对象禁用情况</p>
	 * <p>Title: getIsDisabled</p>
	 * @return
	 */
	public Integer getIsDisabled() {
		return isDisabled;
	}
	
	/**
	 * <p>Description: 设置当前对象禁用情况</p>
	 * <p>Title: setIsDisabled</p>
	 * @param isDisabled
	 */
	public void setIsDisabled(Integer isDisabled) {
		this.isDisabled = isDisabled;
	}

	/**
	 * <p>Description: 获得图片路径</p>
	 * <p>Title: getUrlPicture</p>
	 * @return
	 */
	public String getUrlPicture() {
		return urlPicture;
	}

	/**
	 * <p>Description: 设置图片路径</p>
	 * <p>Title: setUrlPicture</p>
	 * @param urlPicture
	 */
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}

}
