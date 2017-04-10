package com.example.cmltdstudent.class12_1;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cmltdstudent on 4/10/17.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView personNameView;
    private TextView personInfoView;
    private ImageView personPhotoView;
    private Context context;

    public PersonViewHolder(View itemView, Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        personNameView = (TextView) itemView.findViewById(R.id.person_name);
        personInfoView = (TextView) itemView.findViewById(R.id.person_info);
        personPhotoView = (ImageView) itemView.findViewById(R.id.person_photo);
        this.context = context;
    }

    public void bind(Person person) {
        personNameView.setText(person.name);
        personInfoView.setText(person.info);
        personPhotoView.setImageResource(person.photoId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, personNameView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}