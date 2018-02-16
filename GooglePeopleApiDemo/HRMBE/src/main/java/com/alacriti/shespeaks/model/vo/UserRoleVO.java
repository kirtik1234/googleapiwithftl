package com.alacriti.shespeaks.model.vo;

public class UserRoleVO {
	private int roleTypeId;
	private String roleName;
	private String roleDesc;
	private boolean isRoleCreate;

	public int getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(int userAcctId) {
		this.roleTypeId = userAcctId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public boolean isRoleCreate() {
		return isRoleCreate;
	}

	public void setRoleCreate(boolean isRoleCreate) {
		this.isRoleCreate = isRoleCreate;
	}

}
