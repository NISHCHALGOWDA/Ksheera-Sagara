package com.ksheera.sagara.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.ksheera.sagara.R;
import com.ksheera.sagara.data.AppDatabase;
import com.ksheera.sagara.data.IncomeEntry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddIncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        EditText etLiters = findViewById(R.id.etLiters);
        EditText etFat = findViewById(R.id.etFat);
        EditText etRate = findViewById(R.id.etRate);
        EditText etCowName = findViewById(R.id.etCowName);
        Button btnSave = findViewById(R.id.btnSaveIncome);

        btnSave.setOnClickListener(v -> {
            String litersStr = etLiters.getText().toString().trim();
            String fatStr = etFat.getText().toString().trim();
            String rateStr = etRate.getText().toString().trim();
            String cowName = etCowName.getText().toString().trim();

            if (litersStr.isEmpty() || fatStr.isEmpty() || rateStr.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double liters = Double.parseDouble(litersStr);
            double fat = Double.parseDouble(fatStr);
            double rate = Double.parseDouble(rateStr);

            IncomeEntry entry = new IncomeEntry();
            entry.date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            entry.liters = liters;
            entry.fatPercent = fat;
            entry.ratePerLiter = rate;
            entry.totalAmount = liters * rate;
            entry.cowName = cowName.isEmpty() ? "Default" : cowName;

            AppDatabase.getInstance(this).appDao().insertIncome(entry);
            Toast.makeText(this, "Income saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
