package com.dep.bestwallpaperapp.Databases;

public class Model_Gallery {

    String title_img,author_name;
    String img_gallery,img_author,img_download_url,img_belong_to;
    String no_downloads , img_dimension ,img_size ;

    public Model_Gallery(String title_img, String author_name, String img_gallery, String img_author, String img_download_url, String img_belong_to, String no_downloads, String img_dimension, String img_size) {
        this.title_img = title_img;
        this.author_name = author_name;
        this.img_gallery = img_gallery;
        this.img_author = img_author;
        this.img_download_url = img_download_url;
        this.img_belong_to = img_belong_to;
        this.no_downloads = no_downloads;
        this.img_dimension = img_dimension;
        this.img_size = img_size;
    }

    public Model_Gallery() {
    }

    private boolean isSelected = false;

    public String getImg_belong_to() {
        return img_belong_to;
    }

    public void setImg_belong_to(String img_belong_to) {
        this.img_belong_to = img_belong_to;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Model_Gallery(String title_img, String author_name, String img_gallery, String img_author, String img_download_url) {
        this.title_img = title_img;
        this.author_name = author_name;
        this.img_gallery = img_gallery;
        this.img_author = img_author;
        this.img_download_url = img_download_url;
    }

    public String getImg_download_url() {
        return img_download_url;
    }

    public void setImg_download_url(String img_download_url) {
        this.img_download_url = img_download_url;
    }

    public String getImg_author() {
        return img_author;
    }

    public void setImg_author(String img_author) {
        this.img_author = img_author;
    }


    public String getTitle_img() {
        return title_img;
    }

    public void setTitle_img(String title_img) {
        this.title_img = title_img;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getImg_gallery() {
        return img_gallery;
    }

    public void setImg_gallery(String img_gallery) {
        this.img_gallery = img_gallery;
    }


}
