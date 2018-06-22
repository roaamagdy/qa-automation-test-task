package com.billie.api.model;

import java.util.Objects;

/**
 * @author ROMA1
 * */

public class CommentModel {

	private int postId;
	private int id;
	private String name;
	private String email;
	private String body;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o)
	        return true;
	    if (o == null)
	        return false;
	    if (getClass() != o.getClass())
	        return false;
	    CommentModel comment = (CommentModel) o;
	    // fields comparison
	    return Objects.equals(id, comment.getId())
	            && Objects.equals(postId, comment.getPostId());
	}
}
