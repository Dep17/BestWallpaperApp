package com.dep.bestwallpaperapp.Modelss;

public class Model_collections {

  private String url_img_collections ;
  private String  title_collections ;
  private String subtitle_collections ;

    public Model_collections(String url_img_collections, String title_collections, String subtitle_collections) {
        this.url_img_collections = url_img_collections;
        this.title_collections = title_collections;
        this.subtitle_collections = subtitle_collections;
    }

    public String getUrl_img_collections() {
        return url_img_collections;
    }

    public void setUrl_img_collections(String url_img_collections) {
        this.url_img_collections = url_img_collections;
    }

    public String getTitle_collections() {
        return title_collections;
    }

    public void setTitle_collections(String title_collections) {
        this.title_collections = title_collections;
    }

    public String getSubtitle_collections() {
        return subtitle_collections;
    }

    public void setSubtitle_collections(String subtitle_collections) {
        this.subtitle_collections = subtitle_collections;
    }
}
