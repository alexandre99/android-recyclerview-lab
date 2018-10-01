package br.com.alexandredev.ceep.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alexandredev.ceep.R;
import br.com.alexandredev.ceep.dao.NotaDAO;
import br.com.alexandredev.ceep.model.Nota;

public class FormularioNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nota);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_nota_salva, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_nota_ic_salva: {
                EditText titulo = findViewById(R.id.formulario_nota_titulo);
                EditText descricao = findViewById(R.id.formulario_nota_descricao);

                Nota nota = new Nota(titulo.getText().toString(), descricao.getText().toString());

                Intent resultadoInsercao = new Intent();
                resultadoInsercao.putExtra("nota", nota);
                setResult(2, resultadoInsercao);
                Toast.makeText(FormularioNotaActivity.this, "Nota adicionado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
