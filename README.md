# Ksheera Sagara - Dairy Profit/Loss Calculator

## Project Title: 29 - Android App Development using GenAI - Ksheera Sagara (Agriculture)

---

## About The App

*Ksheera Sagara* is a simple Android app designed for dairy farmers to track their daily milk income and expenses. It calculates net profit/loss and helps farmers understand their financial health at a glance.

Many dairy farmers receive a Milk Slip every day but do not have a way to track their monthly profit after subtracting costs like feed, medicines, and labor. This app solves that problem.

---

## Features

| Feature | Description |
|---------|-------------|
| Income Log | Enter liters, fat percent, rate per liter, and cow name |
| Expense Log | Record expenses with categories: Fodder, Medical, Labor, Electricity, Other |
| Profit Dashboard | Green/Red financial health indicator showing net profit or loss |
| Cow-wise Analysis | Shows income per cow to identify most profitable ones |
| Expense Breakdown | Displays spending by category |
| Clear Income | Delete all income records with confirmation dialog |
| Clear Expenses | Delete all expense records with confirmation dialog |
| Clear All Data | Reset entire app data with confirmation dialog |
| Home Screen Icon | App appears on home screen with a green icon |

---

## Tech Stack

- Language: Java
- IDE: Android Studio
- Database: Room (SQLite)
- UI: Material Components, CardView
- Min SDK: API 24 (Android 7.0)
- Target SDK: API 34 (Android 14)

---

## Project Structure


KsheeraSagara/
├── app/
│   ├── build.gradle
│   ├── proguard-rules.pro
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/ksheera/sagara/
│       │   ├── MainActivity.java
│       │   ├── data/
│       │   │   ├── AppDao.java
│       │   │   ├── AppDatabase.java
│       │   │   ├── ExpenseEntry.java
│       │   │   └── IncomeEntry.java
│       │   └── ui/
│       │       ├── AddIncomeActivity.java
│       │       ├── AddExpenseActivity.java
│       │       └── DashboardActivity.java
│       └── res/
│           ├── layout/
│           │   ├── activity_main.xml
│           │   ├── activity_add_income.xml
│           │   ├── activity_add_expense.xml
│           │   └── activity_dashboard.xml
│           ├── values/
│           │   ├── strings.xml
│           │   └── themes.xml
│           └── mipmap-*/
│               ├── ic_launcher.png
│               └── ic_launcher_round.png
├── build.gradle
├── settings.gradle
├── gradle.properties
└── gradle/wrapper/
    └── gradle-wrapper.properties


---

## How to Run on Android Studio (Windows)

### Prerequisites

- Windows 10 or 11
- Android Studio latest version from https://developer.android.com/studio
- At least 8GB RAM recommended

### Step 1: Extract the Project

1. Download and extract the KsheeraSagara.zip file
2. Place the KsheeraSagara folder on your Desktop or any preferred location

### Step 2: Open in Android Studio

1. Open Android Studio
2. Click File then Open
3. Navigate to the KsheeraSagara folder and select it
4. Click OK

### Step 3: Wait for Gradle Sync

1. Android Studio will automatically download dependencies
2. Wait for the progress bar at the bottom to finish (2-5 minutes first time)
3. If prompted to install SDK components click Install and accept licenses
4. If AGP upgrade is prompted just IGNORE it

### Step 4: Create an Emulator

1. Go to Tools then Device Manager
2. Click Create Virtual Device (the plus button)
3. Select Pixel 6 then click Next
4. Choose system image Tiramisu API 33 or S API 31
5. Click Download if not already installed
6. Click Next then Finish

### Step 5: Run the App

1. Select your emulator from the device dropdown in top toolbar
2. Click the green Run button (play icon)
3. Wait for the app to install and launch on the emulator

### Step 6: Using the App

1. Add Milk Income - Enter daily milk data (liters, fat percent, rate, cow name)
2. Add Expense - Record expenses by category
3. View Dashboard - See profit/loss summary and breakdown
4. Clear buttons - Reset data when needed

---

## Troubleshooting

| Issue | Solution |
|-------|----------|
| Gradle sync failed | File then Invalidate Caches and Restart |
| SDK not found | File then Settings then SDK Manager then Install API 34 |
| Emulator wont start | Device Manager then Delete old device then Create new one |
| Build failed | Build then Clean Project then Build then Rebuild Project |
| Device unavailable | Make sure emulator is fully booted before clicking Run |
| AGP upgrade prompt | Ignore it or click Do not remind me |

---

## App Logic

- Net Profit = Total Income - Total Expenses
- Income = Liters x Rate per Liter
- Dashboard Color:
  - Green background = Profit (income greater than expenses)
  - Red background = Loss (expenses greater than income)

---

## Expense Categories

- Fodder - Feed bags, grass, silage
- Medical - Vet visits, medicines, vaccines
- Labor - Worker salaries
- Electricity - Farm electricity bills
- Other - Miscellaneous expenses

---

## Impact Goals

- Help farmers move from Survival Activity to Profitable Business
- Enable data-driven decisions such as when to sell a non-productive cow
- Teach the concept of Input Cost vs Gross Income

---

## Built With

- Android Studio
- Java
- Room Database (SQLite)
- Material Design Components

---

## Author

VTU Internship Program - MindMatrix
Project 29: Ksheera Sagara (Agriculture)

---

## License

This project is for educational purposes as part of the MindMatrix VTU Internship Program.
