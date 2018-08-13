package ru.inpleasure.sketches.cards;

import android.app.Activity;
import android.os.Bundle;
import ru.inpleasure.sketches.R;
import android.support.v7.widget.*;

public class CardActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        RecyclerView recyclerView = findViewById(R.id.cards_activity_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard adapter = new AdapterCard(this);
        recyclerView.setAdapter(adapter);
    }
}
