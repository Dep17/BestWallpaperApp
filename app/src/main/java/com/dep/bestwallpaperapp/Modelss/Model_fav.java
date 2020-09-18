package com.dep.bestwallpaperapp.Modelss;

public class Model_fav {


    String img_url , url_diwnload ,img_title,author_name,img_author;
    boolean Selected =true ;

    public String getImg_author() {
        return img_author;
    }

    public void setImg_author(String img_author) {
        this.img_author = img_author;
    }

    public String getImg_title() {
        return img_title;
    }

    public void setImg_title(String img_title) {
        this.img_title = img_title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Model_fav(String img_url, String url_diwnload, String img_title, String author_name, String img_author) {
        this.img_url = img_url;
        this.url_diwnload = url_diwnload;
        this.img_title = img_title;
        this.author_name = author_name;
        this.img_author = img_author;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }


    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUrl_diwnload() {
        return url_diwnload;
    }

    public void setUrl_diwnload(String url_diwnload) {
        this.url_diwnload = url_diwnload;
    }


    // end class
}
