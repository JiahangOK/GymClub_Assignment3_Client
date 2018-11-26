package edu.bjtu.gymclub.gymclub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.bjtu.gymclub.gymclub.R;
import edu.bjtu.gymclub.gymclub.Entity.Trainer;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TrainerViewHolder>{

    private List<Trainer> trainerList;
    private Context context;

    public RecyclerViewAdapter(List<Trainer> trainerList,Context context) {
        this.trainerList = trainerList;
        this.context=context;
    }


    //自定义ViewHolder类
    static class TrainerViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView trainer_photo;
        TextView trainer_name;
        TextView trainer_intro;
        TextView trainer_tel;
        Button call_button;


        public TrainerViewHolder(final View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.trainer_list_card_view);
            trainer_photo= (ImageView) itemView.findViewById(R.id.trainer_image);
            trainer_name= (TextView) itemView.findViewById(R.id.trainer_name);
            trainer_intro = (TextView) itemView.findViewById(R.id.trainer_intro);
            trainer_tel = (TextView) itemView.findViewById(R.id.trainer_tel);
            call_button = (Button) itemView.findViewById(R.id.trainer_call_button);
            call_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + trainer_tel.getText().toString().split(":")[1]));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    itemView.getContext().startActivity(intent);
                }
            });
//            //设置TextView背景为半透明
//            trainer_name.setBackgroundColor(Color.argb(20, 0, 0, 0));

        }


    }

    @Override
    public RecyclerViewAdapter.TrainerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        TrainerViewHolder nvh=new TrainerViewHolder(v);
        return nvh;
    }


    @Override
    public void onBindViewHolder(RecyclerViewAdapter.TrainerViewHolder personViewHolder, int i) {
        final int j=i;
        Trainer trainer = trainerList.get(i);
//        Bitmap bitmap = trainer.getTrainer_image();

        Picasso.with(context).load(trainerList.get(i).getTrainer_image()).into(personViewHolder.trainer_photo);

        personViewHolder.trainer_name.setText(trainerList.get(i).getTrainer_name());
        personViewHolder.trainer_intro.setText(trainerList.get(i).getTrainer_intro());
        personViewHolder.trainer_tel.setText("Tel:"+trainerList.get(i).getTrainer_tel());
    }

    @Override
    public int getItemCount() {
        return trainerList.size();
    }
}
