package com.internousdev.mimosa.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mimosa.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{

		private String familyName;
		private String firstName;
		private String familyNameKana;
		private String firstNameKana;
		private String sex;
		private List<String> sexList = new ArrayList<String>();
		private String email;
		private String loginId;
		private String password;
		private static final String MALE = "男性";
		private static final String FEMALE = "女性";
		private String defaultSexValue = MALE;
		private Map<String, Object> session;

		public String execute() {

			String result = ERROR;
			CommonUtility commonUtility = new CommonUtility();
			if(!commonUtility.checkSession(session)) {
				return "sessionTimeOut";
			}

			session.remove("loginIdErrorMessageList");
			session.remove("familyNameErrorMessageList");
			session.remove("firstNameErrorMessageList");
			session.remove("familyNameKanaErrorMessageList");
			session.remove("firstNameKanaErrorMessageList");
			session.remove("emailErrorMessageList");
			session.remove("userIdErrorMessageList");
			session.remove("passwordErrorMessageList");
			session.remove("isExistsErrorMessageList");

			session.put("familyName", familyName);
			session.put("firstName", firstName);
			session.put("familyNameKana", familyNameKana);
			session.put("firstNameKana", firstNameKana);
			if(sex==null) {
				session.put("sex", MALE);
			}else {
			session.put("sex", String.valueOf(session.get("sex")));
			}
			sexList.add(MALE);
			sexList.add(FEMALE);
			session.put("sexList", sexList);
			session.put("email", email);
			session.put("loginId", loginId);
			session.put("password", password);
			result = SUCCESS;
			return result;
		}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}