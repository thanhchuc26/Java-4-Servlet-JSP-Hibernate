/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.onlineshop.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author June
 */
@Entity
@Table(name = "shop")
@NamedQueries({
    @NamedQuery(name = "ShopEntity.findAll", query = "SELECT s FROM ShopEntity s"),
    @NamedQuery(name = "ShopEntity.findByProductId", query = "SELECT s FROM ShopEntity s WHERE s.productId = :productId"),
    @NamedQuery(name = "ShopEntity.findByName", query = "SELECT s FROM ShopEntity s WHERE s.name = :name"),
    @NamedQuery(name = "ShopEntity.findByQuantity", query = "SELECT s FROM ShopEntity s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "ShopEntity.findByUnitprice", query = "SELECT s FROM ShopEntity s WHERE s.unitprice = :unitprice"),
    @NamedQuery(name = "ShopEntity.findByManufacturer", query = "SELECT s FROM ShopEntity s WHERE s.manufacturer = :manufacturer")})
public class ShopEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productId")
    private Integer productId;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unitprice")
    private Double unitprice;
    @Size(max = 50)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;

    public ShopEntity() {
    }

    public ShopEntity(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopEntity)) {
            return false;
        }
        ShopEntity other = (ShopEntity) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softech.onlineshop.entities.ShopEntity[ productId=" + productId + " ]";
    }
    
}
