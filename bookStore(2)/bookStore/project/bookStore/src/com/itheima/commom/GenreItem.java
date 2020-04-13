package com.itheima.commom;

public class GenreItem {

	private String genreName;
	private Long number;
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "GenreItem [genreName=" + genreName + ", number=" + number + "]";
	}

}
