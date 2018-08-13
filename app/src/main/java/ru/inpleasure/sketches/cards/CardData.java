package ru.inpleasure.sketches.cards;

import android.content.Context;

import java.util.List;
import java.util.ArrayList;
import ru.inpleasure.sketches.*;

public class CardData
{
    public int imageId;
    public String caption;

    
    public CardData(int imageId, String caption)
    {
        this.imageId = imageId;
        this.caption = caption;
    }
    
    public static List<CardData> buildDataSet(Context context)
    {
        String c = context.getString(R.string.lorem_3);
        List<CardData> cards = new ArrayList<>();
        cards.add(new CardData(R.drawable.pic_1, c));
        cards.add(new CardData(R.drawable.pic_2, c));
        cards.add(new CardData(R.drawable.pic_3, c));
        cards.add(new CardData(R.drawable.pic_4, c));
        cards.add(new CardData(R.drawable.pic_5, c));
        cards.add(new CardData(R.drawable.pic_6, c));
        cards.add(new CardData(R.drawable.pic_7, c));
        return cards;
    }
}
