package com.ksheera.sagara.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AppDao {
    @Insert
    void insertIncome(IncomeEntry entry);

    @Insert
    void insertExpense(ExpenseEntry entry);

    @Query("SELECT * FROM income_entries ORDER BY date DESC")
    List<IncomeEntry> getAllIncome();

    @Query("SELECT * FROM expense_entries ORDER BY date DESC")
    List<ExpenseEntry> getAllExpenses();

    @Query("SELECT COALESCE(SUM(totalAmount), 0) FROM income_entries")
    double getTotalIncome();

    @Query("SELECT COALESCE(SUM(amount), 0) FROM expense_entries")
    double getTotalExpenses();

    @Query("SELECT COALESCE(SUM(amount), 0) FROM expense_entries WHERE category = :category")
    double getExpenseByCategory(String category);

    @Query("SELECT COALESCE(SUM(totalAmount), 0) FROM income_entries WHERE cowName = :cowName")
    double getIncomeByCow(String cowName);

    @Query("SELECT DISTINCT cowName FROM income_entries")
    List<String> getAllCowNames();
}
