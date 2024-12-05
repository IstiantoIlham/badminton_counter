package com.example.badmintoncounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int teamA = 0;
    private int teamB = 0;
    TextView tv_score_a;
    Button btn_add_a;
    Button btn_min_a;
    TextView tv_score_b;
    Button btn_add_b;
    Button btn_min_b;
    Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_score_a = findViewById(R.id.tv_score_a);
        btn_add_a = findViewById(R.id.btn_add_a);
        btn_min_a = findViewById(R.id.btn_min_a);

        tv_score_b = findViewById(R.id.tv_score_b);
        btn_add_b = findViewById(R.id.btn_add_b);
        btn_min_b = findViewById(R.id.btn_min_b);

        btn_reset = findViewById(R.id.btn_reset);

        btn_add_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA += 1;
                tv_score_a.setText(String.valueOf(teamA));
            }
        });

        btn_min_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA -= 1;
                if (teamA <= 0) {
                    teamA = 0;
                }

                tv_score_a.setText(String.valueOf(teamA));
            }
        });

        btn_add_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB += 1;
                tv_score_b.setText(String.valueOf(teamB));
            }
        });

        btn_min_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB -= 1;
                if (teamB <= 0) {
                    teamB = 0;
                }
                tv_score_b.setText(String.valueOf(teamB));
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA = 0;
                teamB = 0;
                tv_score_a.setText(String.valueOf(teamA));
                tv_score_b.setText(String.valueOf(teamB));
            }
        });

    }
}