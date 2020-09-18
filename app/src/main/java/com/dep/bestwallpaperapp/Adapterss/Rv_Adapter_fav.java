package com.dep.bestwallpaperapp.Adapterss;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dep.bestwallpaperapp.Activitiess.Details_img_Activity;
import com.dep.bestwallpaperapp.Activitiess.Favorite_Activity;
import com.dep.bestwallpaperapp.Databases.DB_sqlit;
import com.dep.bestwallpaperapp.Databases.Model_fav;
import com.dep.bestwallpaperapp.R;

import java.util.List;

public class Rv_Adapter_fav extends RecyclerView.Adapter<Rv_Adapter_fav.MyViewHolderFav>{

    Context ctx_fav;
    List<Model_fav> mlist_fav ;
    View v ;

    public Rv_Adapter_fav(Context ctx_fav, List<Model_fav> mlist_fav) {
        this.ctx_fav = ctx_fav;
        this.mlist_fav = mlist_fav;
    }

    @NonNull
    @Override
    public MyViewHolderFav onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(ctx_fav).inflate(R.layout.item_card_design_fav,viewGroup,false);


        int width = viewGroup.getMeasuredWidth()/3;
        int high = viewGroup.getMeasuredHeight()/3;


       v.getLayoutParams().width = width;
        v.getLayoutParams().height = high;



        v.requestLayout();






        return new MyViewHolderFav(v);    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolderFav holder, final int position) {



        Glide.with(ctx_fav)
                .load(mlist_fav.get(position).getImg_url())
                .apply(new RequestOptions()
                                .placeholder(R.drawable.ic_info).centerCrop()
                        //.fitCenter() // no need for this
                )
                .into(holder.img);

          holder.name_author.setText(mlist_fav.get(position).getAuthor_name());
        holder.title_img.setText(mlist_fav.get(position).getImg_title());






        holder.checkBox_fav.setChecked(mlist_fav.get(position).isSelected());
        holder.checkBox_fav.setTag(mlist_fav.get(position));

        holder.checkBox_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                CheckBox cb = (CheckBox) v;
                Model_fav contact = (Model_fav) cb.getTag();

                   contact.setSelected(cb.isChecked());
              mlist_fav.get(position).setSelected(cb.isChecked());


                if (cb.isChecked()){




                } else {

                    DB_sqlit db2 = new DB_sqlit(ctx_fav);

                    db2.DeleteContact(mlist_fav.get(position).getImg_url());


                    if ( db2.DeleteContact(mlist_fav.get(position).getImg_url()) == 0 )   {

                        // remove item with animation

                         holder.container.setVisibility(View.GONE);
                        Toast.makeText(ctx_fav, "..Deleted",Toast.LENGTH_SHORT).show();
                        // mlist_fav.remove(position);

                        // notifyItemRemoved(position);


                    }else{

                        Toast.makeText(ctx_fav,"Error on Delete Method",Toast.LENGTH_SHORT).show();

                    }




                }

            }
        });

holder.container.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent intent = new Intent(ctx_fav, Details_img_Activity.class);
        intent.putExtra("Img_url",mlist_fav.get(position).getImg_url());
        intent.putExtra("img_title",mlist_fav.get(position).getImg_title());
        intent.putExtra("url_Donwload",mlist_fav.get(position).getUrl_diwnload());

        intent.putExtra("img_author",mlist_fav.get(position).getImg_author());
        intent.putExtra("author_name",mlist_fav.get(position).getAuthor_name());
        intent.putExtra("author_name",mlist_fav.get(position).getAuthor_name());

        ctx_fav.startActivity(intent);
        Animatoo.animateFade(ctx_fav);




    }
});




    }

    @Override
    public int getItemCount() {
        return mlist_fav.size();
    }




////////////////////////////////////////////////////////////////////////////////


    public class MyViewHolderFav extends RecyclerView.ViewHolder{

        private ImageView img ;
        private TextView title_img , name_author ;
        private ConstraintLayout container ;
        private CheckBox checkBox_fav;


        public MyViewHolderFav(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.img_itrm_crd_galleryf);
        title_img = itemView.findViewById(R.id.title_itrm_crd_gallery);
        name_author = itemView.findViewById(R.id.author_name_itrm_crd_gallery);
        container = itemView.findViewById(R.id.ln_container_crd_item);
        checkBox_fav = itemView.findViewById(R.id.myCompatCheckBox_id2);









    }





}




///// END CLASS
}
