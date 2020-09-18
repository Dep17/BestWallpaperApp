package com.dep.bestwallpaperapp.Databases;
//   created By aminecherchelle@gmail.com

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class DB_sqlit extends SQLiteOpenHelper {

    public static final  String DB_Name = "WallpapersDB.db";

    public DB_sqlit(Context context) {
        super(context, DB_Name, null, 1);
    }



// Working Methods :



    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE favorut_wallpapers_table(img_url  TEXT PRIMARY KEY , download_url TEXT,img_title TEXT,author_name TEXT,author_img TEXT )");



    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }









    // 1- Delete Method :

    public Integer DeleteContact (String put_img_url) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("favorut_wallpapers_table", "img_url=?", new String[]{put_img_url});
    }






    // 2-inserting Data :


    public boolean InsertData (String put_img_url, String put_download_url, String put_img_title,String put_author_name,String put_author_img) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("img_url",put_img_url);
        contentValues.put("download_url",put_download_url);
        contentValues.put("img_title",put_img_title);
        contentValues.put("author_name",put_author_name);
        contentValues.put("author_img",put_author_img);

        long result = db.insert("favorut_wallpapers_table",null,contentValues);
        if (result == -1){

            return false;


        }else {

            return true ;}


    }



    // 3- read Method :












    public List<Model_fav> Get_Selected_Imgs  (){

        List<Model_fav> mlst2 = new ArrayList<>();


        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM favorut_wallpapers_table",null);

        res.moveToFirst();




        while (res.isAfterLast() == false){


             String imgurl = res.getString(res.getColumnIndex("img_url"));
            String url_download = res.getString(res.getColumnIndex("download_url"));
            String img_title = res.getString(res.getColumnIndex("img_title"));
            String author_name = res.getString(res.getColumnIndex("author_name"));
            String author_img = res.getString(res.getColumnIndex("author_img"));


            mlst2.add(new Model_fav(imgurl,url_download,img_title,author_name,author_img));
            res.moveToNext();

        }


        return  mlst2;



    }





/////////////////////////


 ////////////////////// INSERTING DATA  :











//   created By aminecherchelle@gmail.com

// end Class
}
