package com.xdcr.framework.core.login.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Table(name = "sys_user")
@Entity
public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id            ;
	private String usercode      ;
	private String username      ;
	private String pwd           ;
	private String comcode       ;
	private String state         ;
	private String lockstate     ;
	private String validstartdate;
	private String validenddate  ;
	private String sex           ;
	private String age           ;
	private String mobile        ;
	private String email         ;
	private String creatdate     ;
	private String creattime     ;
	private String creater       ;
	private String modifydate    ;
	private String modifytime    ;
	private String modifier      ;
	public SysUser(){
		
	};
	public SysUser(String id, String usercode, String username, String pwd,
			String comcode, String state, String lockstate,
			String validstartdate, String validenddate, String sex, String age,
			String mobile, String email, String creatdate, String creattime,
			String creater, String modifydate, String modifytime,
			String modifier) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.pwd = pwd;
		this.comcode = comcode;
		this.state = state;
		this.lockstate = lockstate;
		this.validstartdate = validstartdate;
		this.validenddate = validenddate;
		this.sex = sex;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.creatdate = creatdate;
		this.creattime = creattime;
		this.creater = creater;
		this.modifydate = modifydate;
		this.modifytime = modifytime;
		this.modifier = modifier;
	}
	
	@Id
    @GeneratedValue(generator = "sys-uuid")
    @GenericGenerator(name = "sys-uuid", strategy = "uuid")
    @Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "usercode")
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "pwd")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "comcode")
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "lockstate")
	public String getLockstate() {
		return lockstate;
	}
	public void setLockstate(String lockstate) {
		this.lockstate = lockstate;
	}

	@Column(name = "validstartdate")
	public String getValidstartdate() {
		return validstartdate;
	}
	public void setValidstartdate(String validstartdate) {
		this.validstartdate = validstartdate;
	}

	@Column(name = "validenddate")
	public String getValidenddate() {
		return validenddate;
	}
	public void setValidenddate(String validenddate) {
		this.validenddate = validenddate;
	}

	@Column(name = "sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "age")
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "creatdate")
	public String getCreatdate() {
		return creatdate;
	}
	public void setCreatdate(String creatdate) {
		this.creatdate = creatdate;
	}

	@Column(name = "creattime")
	public String getCreattime() {
		return creattime;
	}
	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}

	@Column(name = "creater")
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Column(name = "modifydate")
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}

	@Column(name = "modifytime")
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	@Column(name = "modifier")
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
