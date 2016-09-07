package com.accenture.model;

import java.util.ArrayList;

public class ResponseModel {
	private String galleryLocation;
	private int prodYear;
	private String artistName;
	private String title;
	private ArrayList<ArtworkImagesModel> artworkImages;
	private int assetId;
	private int likesCnt;
	private int viewCount;
	private int shareCount;
	private int id;
	private String country;
	
	public String getGalleryLocation() {
		return galleryLocation;
	}
	public void setGalleryLocation(String galleryLocation) {
		this.galleryLocation = galleryLocation;
	}
	public int getProdYear() {
		return prodYear;
	}
	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<ArtworkImagesModel> getArtworkImages() {
		return artworkImages;
	}
	public void setArtworkImages(ArrayList<ArtworkImagesModel> artworkImages) {
		this.artworkImages = artworkImages;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getLikesCnt() {
		return likesCnt;
	}
	public void setLikesCnt(int likesCnt) {
		this.likesCnt = likesCnt;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getShareCount() {
		return shareCount;
	}
	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
