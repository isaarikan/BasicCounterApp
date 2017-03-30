package arksoft.com.sayac;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int counter=0;
    SharedPreferences sharedPreferences;
    Button artir,sifirla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        artir=(Button)findViewById(R.id.artir);
        sifirla=(Button)findViewById(R.id.zero);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        counter=sharedPreferences.getInt("sayi",0);
        artir.setText(""+counter);



        artir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                artir.setText(""+counter);
            }
        });

        sifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=0;
                artir.setText(""+counter);
            }
        });

    }

    @Override
    protected void onPause() {
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.putInt("sayi",counter);
       edit.commit();
        super.onPause();
    }
}
