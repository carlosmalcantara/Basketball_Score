package com.alcantaracarlos.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.alcantaracarlos.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public int tanteoLocal, tanteoVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.localMenos1.setOnClickListener(view -> {
            int resultadoLocal = Integer.parseInt(binding.marcadorLocal.getText().toString());
            if (resultadoLocal == 0) {
                Toast.makeText(this, getString(R.string.impossible), Toast.LENGTH_SHORT).show();
            } else {
                tanteoLocal = resultadoLocal - 1;
                binding.marcadorLocal.setText(String.valueOf(tanteoLocal));
                Toast.makeText(this, getString(R.string.one_minus), Toast.LENGTH_SHORT).show();

            }
        });

        binding.localMas1.setOnClickListener(view -> {
            int resultadoLocal = Integer.parseInt(binding.marcadorLocal.getText().toString());
            if (resultadoLocal >= 0) {
                tanteoLocal = resultadoLocal + 1;
                binding.marcadorLocal.setText(String.valueOf(tanteoLocal));
                Toast.makeText(this, getString(R.string.one_more), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, getString(R.string.impossible), Toast.LENGTH_SHORT).show();
            }
        });

        binding.localMas2.setOnClickListener(view -> {
            int resultadoLocal = Integer.parseInt(binding.marcadorLocal.getText().toString());
            if (resultadoLocal >= 0) {
                tanteoLocal = resultadoLocal + 2;
                binding.marcadorLocal.setText(String.valueOf(tanteoLocal));
                Toast.makeText(this, getString(R.string.two_more), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, getString(R.string.impossible), Toast.LENGTH_SHORT).show();
            }
        });

        binding.visitMenos1.setOnClickListener(view -> {
            int resultadoVisitante = Integer.parseInt(binding.marcadorVisitante.getText().toString());
            if (resultadoVisitante == 0) {
                Toast.makeText(this, getString(R.string.zero_score), Toast.LENGTH_SHORT).show();
            } else {
                tanteoVisitante = resultadoVisitante - 1;
                binding.marcadorVisitante.setText(String.valueOf(tanteoVisitante));
                Toast.makeText(this, getString(R.string.one_minus), Toast.LENGTH_SHORT).show();
            }
        });

        binding.visitMas1.setOnClickListener(view -> {
            int resultadoVisitante = Integer.parseInt(binding.marcadorVisitante.getText().toString());
            if (resultadoVisitante >= 0) {
                tanteoVisitante = resultadoVisitante + 1;
                binding.marcadorVisitante.setText(String.valueOf(tanteoVisitante));
                Toast.makeText(this, getString(R.string.one_more), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.impossible), Toast.LENGTH_SHORT).show();
            }
        });

        binding.visitMas2.setOnClickListener(view -> {
            int resultadoVisitante = Integer.parseInt(binding.marcadorVisitante.getText().toString());
            if (resultadoVisitante >= 0) {
                tanteoVisitante = resultadoVisitante + 2;
                binding.marcadorVisitante.setText(String.valueOf(tanteoVisitante));
                Toast.makeText(this, getString(R.string.two_more), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.impossible), Toast.LENGTH_SHORT).show();
            }
        });

        binding.resetButton.setOnClickListener(view -> {
            binding.marcadorLocal.setText(String.valueOf(getString(R.string.zero_double)));
            binding.marcadorVisitante.setText(String.valueOf(getString(R.string.zero_double)));
        });

        binding.nextButton.setOnClickListener(view -> {
            String pasoLocal = binding.marcadorLocal.getText().toString();
            String pasoVisitante = binding.marcadorVisitante.getText().toString();
            openActivity(pasoLocal, pasoVisitante);
        });

    }

    private void openActivity(String marcadorLocal, String marcadorVisitante) {
        Intent intent = new Intent(this, Details.class);
        intent.putExtra(Details.MARCADOR_LOCAL, marcadorLocal);
        intent.putExtra(Details.MARCADOR_VISITANTE, marcadorVisitante);
        startActivity(intent);
    }
}