package com.alcantaracarlos.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alcantaracarlos.basketballscore.databinding.ActivityDetailsBinding;

public class Details extends AppCompatActivity {

    public static final String MARCADOR_LOCAL = "marcador_local";
    public static final String MARCADOR_VISITANTE = "marcador_visitante";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDetailsBinding binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        String tanteoLocal = extras.getString(MARCADOR_LOCAL);
        String tanteoVisitante = extras.getString(MARCADOR_VISITANTE);

        binding.resultadoLocal.setText(tanteoLocal);
        binding.resultadoVisitante.setText(tanteoVisitante);

        int local = Integer.parseInt(binding.resultadoLocal.getText().toString());
        int visitante = Integer.parseInt(binding.resultadoVisitante.getText().toString());

        if (local == visitante) {
            binding.resultadoTexto.setText(getString(R.string.tie));
        } else {
            if (local < visitante) {
                binding.resultadoTexto.setText(getString(R.string.visitors_won));
            } else {
                binding.resultadoTexto.setText(getString(R.string.local_won));
            }
        }
    }
}