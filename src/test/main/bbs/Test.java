package bbs;

import org.apache.commons.lang.builder.ToStringBuilder;

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
		// TODO Auto-generated method stub

		Test test = new Test();
		test.setId(1);
		test.setName("hello");
		System.out.println(ToStringBuilder.reflectionToString(test));
		System.out.println(2/3);
	}

}
