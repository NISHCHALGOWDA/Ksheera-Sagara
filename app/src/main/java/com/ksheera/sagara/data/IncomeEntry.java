package com.ksheera.sagara.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "income_entries")
public class IncomeEntry {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String date;
    public double liters;
    public double fatPercent;
    public double ratePerLiter;
    public double totalAmount;
    public String cowName;
}
