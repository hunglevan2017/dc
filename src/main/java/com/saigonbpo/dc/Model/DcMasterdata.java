package com.saigonbpo.dc.Model;

public class DcMasterdata {
    private Long id;

    private String category;

    private String code;

    private String codeUtf8;

    private Boolean published;

    private Integer orderBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeUtf8() {
        return codeUtf8;
    }

    public void setCodeUtf8(String codeUtf8) {
        this.codeUtf8 = codeUtf8;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }
}