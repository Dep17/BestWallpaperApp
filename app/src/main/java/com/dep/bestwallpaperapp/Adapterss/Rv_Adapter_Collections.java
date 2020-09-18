package com.dep.bestwallpaperapp.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dep.bestwallpaperapp.Modelss.Model_collections;
import com.dep.bestwallpaperapp.R;

import java.util.List;

public class Rv_Adapter_Collections extends RecyclerView.Adapter<Rv_Adapter_Collections.myviewholder_collections> {

 Context ctx_coll ;
 List<Model_collections> mlist ;

    public Rv_Adapter_Collections(Context ctx_coll, List<Model_collections> mlist) {
        this.ctx_coll = ctx_coll;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public myviewholder_collections onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v ;
        v = LayoutInflater.from(ctx_coll).inflate(R.layout.item_design_collections,parent,false);

        return new myviewholder_collections(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder_collections holder, int position) {

        // loading img with Glide :

        Glide.with(ctx_coll).load(mlist.get(position).getUrl_img_collections()).into(holder.img_collections);

        holder.title_collections.setText(mlist.get(position).getTitle_collections());
        holder.subtitle_collections.setText(mlist.get(position).getSubtitle_collections());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class myviewholder_collections extends RecyclerView.ViewHolder {

        ImageView img_collections ;
        TextView title_collections , subtitle_collections ;
       public myviewholder_collections(@NonNull View itemView) {
           super(itemView);

           img_collections = itemView.findViewById(R.id.img_collection_item);
           title_collections = itemView.findViewById(R.id.title_item_collection);
           subtitle_collections = itemView.findViewById(R.id.subtitle_item_colection);

       }
   }
 //end class
}
