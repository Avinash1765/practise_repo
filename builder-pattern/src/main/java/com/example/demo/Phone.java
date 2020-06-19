package com.example.demo;

public class Phone {
	
	private String os;
	private String company;
	private String size;
	private String camQuality;
	private String ram;
	
	public static class Builder{
		private String os;
		private String company;
		private String size;
		private String camQuality;
		private String ram;
		
		public Builder os(String os) {
			this.os= os;
			return this;
		}
		
		public Builder company(String company) {
			this.company= company;
			return this;
		}
		
		public Builder size(String size) {
			this.size= size;
			return this;
		}
		
		public Builder camQuality(String camQuality) {
			this.camQuality= camQuality;
			return this;
		}
		
		public Builder ram(String ram) {
			this.ram= ram;
			return this;
		}
		
		public Phone build() {
			return new Phone(this);
		}
	}

	private Phone(Builder builder) {
		this.os= builder.os;
		this.ram= builder.ram;
		this.camQuality= builder.camQuality;
		this.size= builder.size;
		this.company= builder.company;
	}

	public String getOs() {
		return os;
	}

	public String getCompany() {
		return company;
	}

	public String getSize() {
		return size;
	}

	public String getCamQuality() {
		return camQuality;
	}

	public String getRam() {
		return ram;
	}

}



// helps in creating immutable objects (no setters as well in class)
// helps in creating multiple constructors with different combinations
