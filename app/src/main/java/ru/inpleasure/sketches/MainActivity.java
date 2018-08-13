package ru.inpleasure.sketches;

import android.app.*;
import android.os.*;
import android.content.Intent;
import ru.inpleasure.sketches.cards.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startActivity(new Intent(this, CardActivity.class));
    }
}
