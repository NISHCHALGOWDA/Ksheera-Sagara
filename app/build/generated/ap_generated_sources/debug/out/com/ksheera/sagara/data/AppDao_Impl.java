package com.ksheera.sagara.data;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDao_Impl implements AppDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IncomeEntry> __insertionAdapterOfIncomeEntry;

  private final EntityInsertionAdapter<ExpenseEntry> __insertionAdapterOfExpenseEntry;

  public AppDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncomeEntry = new EntityInsertionAdapter<IncomeEntry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `income_entries` (`id`,`date`,`liters`,`fatPercent`,`ratePerLiter`,`totalAmount`,`cowName`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncomeEntry value) {
        stmt.bindLong(1, value.id);
        if (value.date == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.date);
        }
        stmt.bindDouble(3, value.liters);
        stmt.bindDouble(4, value.fatPercent);
        stmt.bindDouble(5, value.ratePerLiter);
        stmt.bindDouble(6, value.totalAmount);
        if (value.cowName == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.cowName);
        }
      }
    };
    this.__insertionAdapterOfExpenseEntry = new EntityInsertionAdapter<ExpenseEntry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `expense_entries` (`id`,`date`,`category`,`amount`,`description`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExpenseEntry value) {
        stmt.bindLong(1, value.id);
        if (value.date == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.date);
        }
        if (value.category == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.category);
        }
        stmt.bindDouble(4, value.amount);
        if (value.description == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.description);
        }
      }
    };
  }

  @Override
  public void insertIncome(final IncomeEntry entry) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIncomeEntry.insert(entry);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertExpense(final ExpenseEntry entry) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfExpenseEntry.insert(entry);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<IncomeEntry> getAllIncome() {
    final String _sql = "SELECT * FROM income_entries ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfLiters = CursorUtil.getColumnIndexOrThrow(_cursor, "liters");
      final int _cursorIndexOfFatPercent = CursorUtil.getColumnIndexOrThrow(_cursor, "fatPercent");
      final int _cursorIndexOfRatePerLiter = CursorUtil.getColumnIndexOrThrow(_cursor, "ratePerLiter");
      final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
      final int _cursorIndexOfCowName = CursorUtil.getColumnIndexOrThrow(_cursor, "cowName");
      final List<IncomeEntry> _result = new ArrayList<IncomeEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IncomeEntry _item;
        _item = new IncomeEntry();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _item.date = null;
        } else {
          _item.date = _cursor.getString(_cursorIndexOfDate);
        }
        _item.liters = _cursor.getDouble(_cursorIndexOfLiters);
        _item.fatPercent = _cursor.getDouble(_cursorIndexOfFatPercent);
        _item.ratePerLiter = _cursor.getDouble(_cursorIndexOfRatePerLiter);
        _item.totalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
        if (_cursor.isNull(_cursorIndexOfCowName)) {
          _item.cowName = null;
        } else {
          _item.cowName = _cursor.getString(_cursorIndexOfCowName);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ExpenseEntry> getAllExpenses() {
    final String _sql = "SELECT * FROM expense_entries ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final List<ExpenseEntry> _result = new ArrayList<ExpenseEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ExpenseEntry _item;
        _item = new ExpenseEntry();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _item.date = null;
        } else {
          _item.date = _cursor.getString(_cursorIndexOfDate);
        }
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _item.category = null;
        } else {
          _item.category = _cursor.getString(_cursorIndexOfCategory);
        }
        _item.amount = _cursor.getDouble(_cursorIndexOfAmount);
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _item.description = null;
        } else {
          _item.description = _cursor.getString(_cursorIndexOfDescription);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getTotalIncome() {
    final String _sql = "SELECT COALESCE(SUM(totalAmount), 0) FROM income_entries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getTotalExpenses() {
    final String _sql = "SELECT COALESCE(SUM(amount), 0) FROM expense_entries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getExpenseByCategory(final String category) {
    final String _sql = "SELECT COALESCE(SUM(amount), 0) FROM expense_entries WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getIncomeByCow(final String cowName) {
    final String _sql = "SELECT COALESCE(SUM(totalAmount), 0) FROM income_entries WHERE cowName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cowName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, cowName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getAllCowNames() {
    final String _sql = "SELECT DISTINCT cowName FROM income_entries";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
