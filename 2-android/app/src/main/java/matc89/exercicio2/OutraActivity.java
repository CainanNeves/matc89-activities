package matc89.exercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OutraActivity extends AppCompatActivity{
    public static final String KEY_TEXTO = "texto";
    public static final String KEY_SAVE= "label";
    private EditText edit;
    private String texto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outro_layout);

        edit = findViewById(R.id.editText);

        Bundle extra = getIntent().getExtras();
        if(extra!=null){
            texto = extra.getString(KEY_TEXTO, null);
        }
        edit.setText(texto);
    }

    public void clicaBotaoConfirma(View v){
        if(""+edit.getText() == ""){
            texto = null;
        }else {
            texto = "" + edit.getText();
        }
        Intent intent = new Intent();
        intent.putExtra(KEY_TEXTO, texto);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void clicaBotaoCancela(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_SAVE, texto);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        texto = savedInstanceState.getString(KEY_SAVE);
        edit.setText(texto);
    }
}
