package com.ksheera.sagara;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.ksheera.sagara.ui.AddIncomeActivity;
import com.ksheera.sagara.ui.AddExpenseActivity;
import com.ksheera.sagara.ui.DashboardActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIncome = findViewById(R.id.btnAddIncome);
        Button btnExpense = findViewById(R.id.btnAddExpense);
        Button btnDashboard = findViewById(R.id.btnDashboard);

        btnIncome.setOnClickListener(v -> startActivity(new Intent(this, AddIncomeActivity.class)));
        btnExpense.setOnClickListener(v -> startActivity(new Intent(this, AddExpenseActivity.class)));
        btnDashboard.setOnClickListener(v -> startActivity(new Intent(this, DashboardActivity.class)));
    }
}
