package com.ksheera.sagara.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense_entries")
public class ExpenseEntry {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String date;
    public String category;
    public double amount;
    public String description;
}
