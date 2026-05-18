package com.ksheera.sagara.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.ksheera.sagara.R;
import com.ksheera.sagara.data.AppDatabase;
import com.ksheera.sagara.data.AppDao;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView tvTotalIncome = findViewById(R.id.tvTotalIncome);
        TextView tvTotalExpense = findViewById(R.id.tvTotalExpense);
        TextView tvNetProfit = findViewById(R.id.tvNetProfit);
        TextView tvHealthStatus = findViewById(R.id.tvHealthStatus);
        TextView tvFodder = findViewById(R.id.tvFodder);
        TextView tvMedical = findViewById(R.id.tvMedical);
        TextView tvLabor = findViewById(R.id.tvLabor);
        LinearLayout cowContainer = findViewById(R.id.cowContainer);
        CardView cardProfit = findViewById(R.id.cardProfit);

        AppDao dao = AppDatabase.getInstance(this).appDao();

        double totalIncome = dao.getTotalIncome();
        double totalExpense = dao.getTotalExpenses();
        double netProfit = totalIncome - totalExpense;

        tvTotalIncome.setText(String.format("Total Income: Rs.%.2f", totalIncome));
        tvTotalExpense.setText(String.format("Total Expenses: Rs.%.2f", totalExpense));
        tvNetProfit.setText(String.format("Net Profit: Rs.%.2f", netProfit));

        if (netProfit >= 0) {
            tvHealthStatus.setText("PROFIT - You are doing well!");
            tvHealthStatus.setTextColor(0xFF4CAF50);
            cardProfit.setCardBackgroundColor(0xFFE8F5E9);
        } else {
            tvHealthStatus.setText("LOSS - Review your expenses!");
            tvHealthStatus.setTextColor(0xFFF44336);
            cardProfit.setCardBackgroundColor(0xFFFFEBEE);
        }

        double fodder = dao.getExpenseByCategory("Fodder");
        double medical = dao.getExpenseByCategory("Medical");
        double labor = dao.getExpenseByCategory("Labor");

        tvFodder.setText(String.format("Fodder: Rs.%.2f", fodder));
        tvMedical.setText(String.format("Medical: Rs.%.2f", medical));
        tvLabor.setText(String.format("Labor: Rs.%.2f", labor));

        List<String> cows = dao.getAllCowNames();
        cowContainer.removeAllViews();
        for (String cow : cows) {
            double cowIncome = dao.getIncomeByCow(cow);
            TextView tv = new TextView(this);
            tv.setText(String.format("%s: Rs.%.2f", cow, cowIncome));
            tv.setTextSize(16);
            tv.setPadding(0, 8, 0, 8);
            cowContainer.addView(tv);
        }
    }
}
