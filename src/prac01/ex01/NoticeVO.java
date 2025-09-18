package prac01.ex01;

import java.sql.Date;

public class NoticeVO {
	private Date postDate;
	private String title;
	private String no;

	public NoticeVO() {
		System.out.println("NoticeVO 생성자 호출");
	}

	public NoticeVO(String no, String title, Date postDate) {
		this.no = no;
		this.title = title;
		this.postDate = postDate;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date joinDate) {
		this.postDate = joinDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
}
