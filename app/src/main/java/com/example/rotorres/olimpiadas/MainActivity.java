package com.example.rotorres.olimpiadas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spnModalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnModalidade = (Spinner) findViewById(R.id.spnModalidade);
        List<Modalidade> listModalidades = ModalidadeDAO.listar();
        SpinnerAdapter adapter = new ArrayAdapter<Modalidade>(this, android.R.layout.simple_spinner_item, listModalidades);
        spnModalidade.setAdapter(adapter);
    }

    public void reservar(View v)
    {
        final Dialog dlResumo = new Dialog(this);
        dlResumo.setContentView(R.layout.resumo);

        final EditText edtNome = (EditText) findViewById(R.id.edtNome);
        final EditText edtIdade = (EditText) findViewById(R.id.edtIdade);
        final Spinner spnModal = (Spinner) findViewById(R.id.spnModalidade);

        final RadioGroup rbPeriodo = (RadioGroup) findViewById(R.id.rgPeriodo);
        int intIdSelecionado = rbPeriodo.getCheckedRadioButtonId();
        RadioButton rbSelecao = (RadioButton) findViewById(intIdSelecionado);

        TextView tvNome = (TextView) dlResumo.findViewById(R.id.lblNome);
        TextView tvIdade = (TextView) dlResumo.findViewById(R.id.lblIdade);
        TextView tvModalidade = (TextView) dlResumo.findViewById(R.id.lblModalidade);
        TextView tvPeriodo = (TextView) dlResumo.findViewById(R.id.lblPerido);

        tvNome.setText(edtNome.getText());
        tvIdade.setText(edtIdade.getText());
        tvModalidade.setText(spnModal.getSelectedItem().toString());
        tvPeriodo.setText(rbSelecao.getText().toString());

        Button btConfirmar = (Button) dlResumo.findViewById(R.id.btConfirmar);
        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Confirmação");
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dlResumo.dismiss();
                        edtNome.setText("");
                        edtIdade.setText("");
                        spnModal.setSelection(0);
                        rbPeriodo.setSelected(false);
                    }
                });
                builder.show();
            }
        });

        dlResumo.show();
    }
}
