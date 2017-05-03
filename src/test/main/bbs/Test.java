package bbs;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.util.Assert;

public class Test {
	private int id;
	
	private String name;
	
	public Test(){
		System.out.println(getClass().getGenericSuperclass());
	}

	
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


	public static void main(String[] args) {

		String str = "";
		Assert.hasText(str,"error");
	}

}
