package com.dep.bestwallpaperapp.Adapterss;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.dep.bestwallpaperapp.Activitiess.Details_img_Activity;
import com.dep.bestwallpaperapp.Databases.DB_sqlit;
import com.dep.bestwallpaperapp.Modelss.Model_Gallery;
import com.dep.bestwallpaperapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerView_Adapter_gallery extends RecyclerView.Adapter<RecyclerView_Adapter_gallery.MyViewHolder>{
    final static Random RANDOM = new Random();
    private Context ctx;

   private List<Model_Gallery> mlist = new ArrayList<>();

    public RecyclerView_Adapter_gallery(Context ctxx, List<Model_Gallery> mlist) {
        this.ctx = ctxx;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(ctx).inflate(R.layout.item_design_gallery,viewGroup,false);



        int width = viewGroup.getMeasuredWidth()/3;
        int high = viewGroup.getMeasuredHeight()/3;


        v.getLayoutParams().width = width;
        v.getLayoutParams().height = high;



        v.requestLayout();










        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.title_img.setText(mlist.get(position).getTitle_img());
        holder.name_author.setText(mlist.get(position).getAuthor_name());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ctx, Details_img_Activity.class);
                intent.putExtra("Img_url",mlist.get(position).getImg_gallery());
                intent.putExtra("img_title",mlist.get(position).getTitle_img());
                intent.putExtra("url_Donwload",mlist.get(position).getImg_download_url());

                intent.putExtra("img_author",mlist.get(position).getImg_author());
                intent.putExtra("author_name",mlist.get(position).getAuthor_name());

                ctx.startActivity(intent);

                // animation for activity

              //  Animatoo.animateFade(ctx);





            }
        });

        Glide.with(ctx).load(mlist.get(position).getImg_gallery()).into(holder.img);

        int red = RANDOM.nextInt(815);
        int green = RANDOM.nextInt(710);
        int bleu = RANDOM.nextInt(700);

    int color = Color.rgb(red,green,bleu);

    holder.container.setBackgroundColor(color);
        // holder.img.setImageResource(mlist.get(position).getImg_gallery());



       // seteup CheCkBox :



        holder.mycheckbox.setChecked(mlist.get(position).isSelected());

        holder.mycheckbox.setTag(mlist.get(position));




        holder.mycheckbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                CheckBox cb = (CheckBox) v;
                Model_Gallery contact = (Model_Gallery) cb.getTag();


                contact.setSelected(cb.isChecked());



                mlist.get(position).setSelected(cb.isChecked());



                if (cb.isChecked()) {

                    DB_sqlit db = new DB_sqlit(ctx);

                    boolean Result =  db.InsertData(mlist.get(position).getImg_gallery(),mlist.get(position).getImg_download_url(),
                            mlist.get(position).getTitle_img(),mlist.get(position).getAuthor_name(),mlist.get(position).getImg_author());

                    if (Result == true){

                        Toast.makeText(ctx,"Added to Favorite ",Toast.LENGTH_SHORT).show();
                    }else {
                             cb.setChecked(true);
                           Toast.makeText(ctx,"! Alredy  Exist  !",Toast.LENGTH_SHORT).show();

                    }


                }else {


                    DB_sqlit db2 = new DB_sqlit(ctx);

                    db2.DeleteContact(mlist.get(position).getImg_gallery());

                    if ( db2.DeleteContact(mlist.get(position).getImg_gallery()) == 0 )   {

                        Toast.makeText(ctx,mlist.get(position).getTitle_img()+" "+"is Deleted",Toast.LENGTH_SHORT).show();

                    }else{

                        Toast.makeText(ctx,"Error on Delete Method",Toast.LENGTH_SHORT).show();

                    }



                }




            }
        });








///////////////////////////////////////////
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


     //   private ConstraintLayout cnl ;
      private ImageView img ;
private TextView title_img , name_author ;
private ConstraintLayout container ;
private CheckBox mycheckbox ;
      public MyViewHolder(@NonNull View itemView) {
          super(itemView);

         // cnl = itemView.findViewById(R.id.ln_container_crd_item);
          img = itemView.findViewById(R.id.img_itrm_crd_gallery);
          title_img = itemView.findViewById(R.id.title_itrm_crd_gallery);
          name_author = itemView.findViewById(R.id.author_name_itrm_crd_gallery);
          container = itemView.findViewById(R.id.constraintLayout_containerrrrrr);
          mycheckbox = itemView.findViewById(R.id.myCompatCheckBox_id);




      }
  }



}
