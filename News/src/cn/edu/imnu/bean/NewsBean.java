package cn.edu.imnu.bean;

public class NewsBean {
	private String n_title,n_thing,n_time,n_image;
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_thing() {
		return n_thing;
	}
	public void setN_thing(String n_thing) {
		this.n_thing = n_thing;
	}
	public String getN_time() {
		return n_time;
	}
	public void setN_time(String n_time) {
		this.n_time = n_time;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	public String getN_image() {
		return n_image;
	}
	public void setN_image(String n_image) {
		this.n_image = n_image;
	}
	private int u_id,n_id;
}
