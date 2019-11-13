package br.com.etecia.bookclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ModeloPaginas extends AppCompatActivity {
    TextView lstTextoUm, lstTextoDois;
    ImageView lstImgCadeiras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modelopaginas_layout);
        lstTextoUm = (TextView) findViewById(R.id.lstTextoUm);
        lstTextoDois = (TextView) findViewById(R.id.lstTextoDois);
        lstImgCadeiras = (ImageView) findViewById(R.id.lstImgCadeiras);

        Intent intent = getIntent();
        String textoRetorno = intent.getStringExtra("texto");
        String textodoisRetorno = intent.getStringExtra("textodois");
        int imagemRetorno = intent.getIntExtra("image", 0);

        lstTextoUm.setText(textoRetorno);
        lstTextoDois.setText(textodoisRetorno);
        lstImgCadeiras.setImageResource(imagemRetorno);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
