package br.com.etecia.bookclub;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] textoUm = {"Sleep All Day", "Book Club", "Designer Party", "Cook Lesson", "Designer Party"};
    String[] textoDois = {"Today 8:45 AM", "Tomorrow 2:45 PM", "3 MAY 12:30 PM", "6 MAY 12:30 PM", "Today 10:30 AM"};
    int[] imageCadeiras = {R.drawable.cadeiraum, R.drawable.cadeiradois, R.drawable.cadeiratres, R.drawable.cadeiraquatro, R.drawable.cadeiracinco};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lstCadeiras);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ModeloPaginas.class);
                intent.putExtra("texto", textoUm[position]);
                intent.putExtra("textodois", textoDois[position]);
                intent.putExtra("image", imageCadeiras[position]);
                startActivity(intent);
            }
        });
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imageCadeiras.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1 = getLayoutInflater().inflate(R.layout.modelo_cadeiras, null);

            TextView texto = (TextView) view1.findViewById(R.id.textoUm);
            TextView textodois = (TextView) view1.findViewById(R.id.textoDois);
            ImageView image = (ImageView) view1.findViewById(R.id.imgCadeiras);

            texto.setText(textoUm[position]);
            textodois.setText(textoDois[position]);
            image.setImageResource(imageCadeiras[position]);


            return view1;
        }
    }
}
