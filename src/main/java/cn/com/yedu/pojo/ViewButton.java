package cn.com.yedu.pojo;

public class ViewButton extends Button{

	private String menuId;
	private String type;
	private String url;
	private String parentId;
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuid(String menuId) {
		this.menuId = menuId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentid(String parentId) {
		this.parentId = parentId;
	}
}
