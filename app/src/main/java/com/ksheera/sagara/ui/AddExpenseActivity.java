package com.ksheera.sagara.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.ksheera.sagara.R;
import com.ksheera.sagara.data.AppDatabase;
import com.ksheera.sagara.data.ExpenseEntry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        Spinner spinnerCategory = findViewById(R.id.spinnerCategory);
        EditText etAmount = findViewById(R.id.etExpenseAmount);
        EditText etDescription = findViewById(R.id.etDescription);
        Button btnSave = findViewById(R.id.btnSaveExpense);

        String[] categories = {"Fodder", "Medical", "Labor", "Electricity", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinnerCategory.setAdapter(adapter);

        btnSave.setOnClickListener(v -> {
            String amountStr = etAmount.getText().toString().trim();
            if (amountStr.isEmpty()) {
                Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show();
                return;
            }

            ExpenseEntry entry = new ExpenseEntry();
            entry.date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            entry.category = spinnerCategory.getSelectedItem().toString();
            entry.amount = Double.parseDouble(amountStr);
            entry.description = etDescription.getText().toString().trim();

            AppDatabase.getInstance(this).appDao().insertExpense(entry);
            Toast.makeText(this, "Expense saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
