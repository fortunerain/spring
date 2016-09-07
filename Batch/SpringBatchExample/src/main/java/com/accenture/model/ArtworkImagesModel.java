package com.accenture.model;

public class ArtworkImagesModel {
	private int updateTime;
	private int id;
	private int artworkId;
	private String imageFileUrl;
	private int resolution;
	
	public int getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtworkId() {
		return artworkId;
	}
	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}
	public String getImageFileUrl() {
		return imageFileUrl;
	}
	public void setImageFileUrl(String imageFileUrl) {
		this.imageFileUrl = imageFileUrl;
	}
	public int getResolution() {
		return resolution;
	}
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
}
