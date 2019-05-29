package com.example.demo;

public enum DemoEnum implements DemoInterface{

	SUNDAY("FIRST_ENTEY"){
		public int getData() {
			return 33;
		}
	};
	
	private String str;
	
	public String getStr() {
		return str;
	}

	@Override
	public int getData() {
		return 12;
	}

	private DemoEnum(String str) {
		this.str = str;
	}
	
}
