package com.seu.LexianSystem.vo;

import com.seu.LexianSystem.util.PageHelper;

public class StoreVo extends PageHelper<StoreVo> {
	/**
	 * 门店编号
	 */
	private String store_no;
	/**
	 * 门店id
	 */
	private Long id;
	/**
	 * 城市id
	 */
	private Long citysId;

	/**
	 * 门店名称
	 */
	private String storeName;
	/**
	 * 门店地址
	 */
	private String storeAddress;
	
	/**
	 * 店铺介绍
	 */
	private String introduce;
	
	/**
	 * �?始营业时�?
	 */
	private String starttime;
	/**
	 * 停止营业时间
	 */
	private String closetime;
	/**
	 * �?关门状�??
	 */
	private Integer status;
	/**
	 * �?大纬�?
	 */
	private Double maxlatitude;
	/**
	 * �?小纬�?
	 */
	private Double minlatitude;
	/**
	 * �?大经�?
	 */
	private Double maxlongitude;
	/**
	 * �?小经�?
	 */
	private Double minlongitude;
	/**
	 * 省id
	 */
	private Long provinceId;
	/**
	 * 县id
	 */
	private Long countyId;

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public Double getMaxlatitude() {
		return maxlatitude;
	}

	public void setMaxlatitude(Double maxlatitude) {
		this.maxlatitude = maxlatitude;
	}

	public Double getMinlatitude() {
		return minlatitude;
	}

	public void setMinlatitude(Double minlatitude) {
		this.minlatitude = minlatitude;
	}

	public Double getMaxlongitude() {
		return maxlongitude;
	}

	public void setMaxlongitude(Double maxlongitude) {
		this.maxlongitude = maxlongitude;
	}

	public Double getMinlongitude() {
		return minlongitude;
	}

	public void setMinlongitude(Double minlongitude) {
		this.minlongitude = minlongitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCitysId(Long citysId) {
		this.citysId = citysId;
	}

	public Long getCitysId() {
		return citysId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStarttime() {
		return starttime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStore_no() {
		return store_no;
	}

	public void setStore_no(String store_no) {
		this.store_no = store_no;
	}

}
