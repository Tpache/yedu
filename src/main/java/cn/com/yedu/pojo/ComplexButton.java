package cn.com.yedu.pojo;

import java.util.List;

public class ComplexButton extends Button{
	
	private List<ViewButton> sub_button;

	public List<ViewButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<ViewButton> sub_button) {
		this.sub_button = sub_button;
	}

	
}
