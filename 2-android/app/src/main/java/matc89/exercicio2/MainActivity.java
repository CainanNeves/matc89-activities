package matc89.exercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_EDIT_TEXTO = 999;
    private TextView tv;
    private String texto = null;
    private String textoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        tv = findViewById(R.id.textView);
    }

    public void clicaBotaoMain(View v){
        Intent intent = new Intent(this, OutraActivity.class);
        intent.putExtra(OutraActivity.KEY_TEXTO, texto);
        startActivityForResult(intent, REQUEST_EDIT_TEXTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_EDIT_TEXTO && resultCode == RESULT_OK){
            texto = data.getStringExtra(OutraActivity.KEY_TEXTO);
        }
        if(texto!="" && texto!=null) {
            textoView = "Oi, " + texto + "!";
        }else{
            textoView = "Oi!";
        }
        tv.setText(textoView);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("label", textoView);
        outState.putString("label2", texto);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textoView = savedInstanceState.getString("label");
        texto = savedInstanceState.getString("label2");
        tv.setText(textoView);
    }
}
