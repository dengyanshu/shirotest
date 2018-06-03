package cn.chouchou.entity;

import java.io.Serializable;


public class Role implements Serializable{
	
	private static final long serialVersionUID = 3937424502254739451L;

	/**
	 * 
	 */

	private Integer roleId;

    private String roleName;

    private String roleDesc;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }
}