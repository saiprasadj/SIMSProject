package com.sims.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Product_Master")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "ALIAS_NAME")
	private String aliasName;

	@Column(name = "PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "BUYING_PRICE")
	private Double buyingPrice;

	@Column(name = "SELLING_PRICE")
	private Double sellingPrice;

	@Column(name = "UOM")
	private String uom;

	@Column(name = "RECORDER_LEVEL")
	private String recorderLevel;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAliasNAME() {
		return aliasName;
	}

	public void setAlias(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(Double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getRecorderLevel() {
		return recorderLevel;
	}

	public void setRecorderLevel(String recorderLevel) {
		this.recorderLevel = recorderLevel;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	}
