package com.itsthatjun.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

public class ProductPictures implements Serializable {
    private Integer id;

    private Integer productAlbumId;

    private String filename;

    private Date createdAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductAlbumId() {
        return productAlbumId;
    }

    public void setProductAlbumId(Integer productAlbumId) {
        this.productAlbumId = productAlbumId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}