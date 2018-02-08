package com.xakj.model.dto;
/**
 * 權限
 * @author 袁文彪
 *
 * 消防
 */
public class Right {
	private String updateDate;//更新日期：yyyy-mm-dd HH:mm:ss

    private String rightId;//权限ID

    private String rightType;//权限类型：1菜单、2操作

    private String createDate;//创建日期：yyyy-mm-dd HH:mm:ss

    private String applyId;//应用ID

    private String parentId;//父ID
    
    private String biaoSi;//标识
    
    private String menuUrl;//菜单URL

    private String meunIcon;//菜单图标

    private String menuName;//菜单名称

    private String meunDescribe;//菜单描述

    private Integer menuSort;//菜单排序
    
    private String operateName;//功能名称

    private String operateType;//操作类型：01添加、02修改、03删除、04查看、05导入、06导出

    private String operateUrl;//功能URL

    private String operateDescribe;//功能描述
    
    public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getRightId() {
		return rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

	public String getRightType() {
		return rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getBiaoSi() {
		return biaoSi;
	}

	public void setBiaoSi(String biaoSi) {
		this.biaoSi = biaoSi;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMeunIcon() {
		return meunIcon;
	}

	public void setMeunIcon(String meunIcon) {
		this.meunIcon = meunIcon;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMeunDescribe() {
		return meunDescribe;
	}

	public void setMeunDescribe(String meunDescribe) {
		this.meunDescribe = meunDescribe;
	}

	public Integer getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperateUrl() {
		return operateUrl;
	}

	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}

	public String getOperateDescribe() {
		return operateDescribe;
	}

	public void setOperateDescribe(String operateDescribe) {
		this.operateDescribe = operateDescribe;
	}
}
