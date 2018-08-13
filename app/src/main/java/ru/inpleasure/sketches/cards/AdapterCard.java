package ru.inpleasure.sketches.cards;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import ru.inpleasure.sketches.R;
import java.util.List;
import com.squareup.picasso.*;
import android.view.*;
import android.view.View.*;
import android.view.GestureDetector.*;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder>
{
    public static class CardViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView cardImage;
        public TextView cardCaption;
        
        public CardViewHolder(View parent) {
            super(parent);
            cardImage = parent.findViewById(R.id.list_item_card_image);
            cardCaption = parent.findViewById(R.id.list_item_card_caption);
        }
    }
    
    private List<CardData> cards;
    private Context context;
    
    public AdapterCard(Context context) {
        this.context = context;
        cards = CardData.buildDataSet(context);
    }
    
    @Override
    public AdapterCard.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_card, parent, false);
        return new CardViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(CardViewHolder holder, int position)
    {
        final GestureDetector gestureDetector = new GestureDetector(context,
            new SlideRightGestureDetector(holder.cardImage));
        holder.cardImage.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    gestureDetector.onTouchEvent(event);
                    return true;
                }
            });
        CardData cd = cards.get(position);
        holder.cardCaption.setText(cd.caption);
        Picasso.with(context)
            .load(cd.imageId)
            .centerCrop()
            .fit()
            .into(holder.cardImage);
    }
    
    @Override
    public int getItemCount() {
        return cards.size();
    }
    
    
    class SlideRightGestureDetector extends GestureDetector.SimpleOnGestureListener
    {
        private View view;
        public SlideRightGestureDetector(final View view) {
            this.view = view;
        }
        
        @Override
        public boolean onScroll(MotionEvent start, MotionEvent end, float dx, float dy) {
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0)
                    view.setTranslationX(-200);
                else
                    view.setTranslationX(0);
            }
            
            return true;
        }
    }
}
