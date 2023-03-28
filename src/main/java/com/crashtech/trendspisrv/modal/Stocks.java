package com.crashtech.trendspisrv.modal;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stockdetails")
public class Stocks {

	private String id;
	private String name;
	private int stars;
	private String dateModified;
	private Boolean popular;
	private int likes;
	private Boolean expired;
	private String imageURL;
	private String thumbnailURL;

	public Stocks(String id, String name, int stars, String dateModified, Boolean popular, int likes, Boolean expired,
			String imageURL, String thumbnailURL) {
		super();
		this.id = id;
		this.name = name;
		this.stars = stars;
		this.dateModified = dateModified;
		this.popular = popular;
		this.likes = likes;
		this.expired = expired;
		this.imageURL = imageURL;
		this.thumbnailURL = thumbnailURL;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public Boolean getPopular() {
		return popular;
	}

	public void setPopular(Boolean popular) {
		this.popular = popular;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Boolean getExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

}
