# Project Context: AllExercises

## Overview
This is an Android learning project (Java-based) designed as a collection of exercises covering fundamental and advanced Android development concepts. It serves as a practical "cookbook" or reference for common Android tasks.

## Project Structure
- **Package Name:** `com.example.allexercises`
- **Language:** Java
- **Build System:** Gradle
- **Minimum SDK:** 24 (Android 7.0)
- **Target SDK:** 36 (Android 15)

## Key Components & Features

### 1. Navigation & UI
- **MainActivity:** The main hub containing buttons to launch different exercise categories.
- **TD1MenuActivity:** A dedicated menu for "Travaux Dirigés 1" (TD1) exercises.
- **BasicViewsActivity:** Demonstrates standard UI widgets (TextView, Button, etc.).
- **ListActivity:** Implementation of a `ListView` with a `MyCustomAdapter` (extending `ArrayAdapter`).

### 2. Data Persistence (SQLite)
The project uses SQLite for local storage with two main handlers:
- **DBHandler:** Manages a "personnes" table (ID, Nom, Prenom). Used in `DatabaseActivity`.
- **MealDBHelper:** Manages a "meals" table (ID, Name, Description). It features `insertInitialMeal` to prepopulate the database with traditional dishes.

### 3. Components & Background Tasks
- **Intents:** `IntentActivity` and `IntentDestinationActivity` demonstrate passing data between activities.
- **Services:** `MyMusicService` (extending `Service`) shows background execution, managed via `ServiceActivity`.
- **Threads:** `ThreadActivity` demonstrates handling asynchronous operations.
- **Fragments:** `FragmentActivity` and `MyCustomFragment` show how to dynamically load and pass data to fragments using `FragmentManager`.
- **Alarms:** `AlarmActivity` and `MyAlarmReceiver` demonstrate using `AlarmManager` and `BroadcastReceiver`.

### 4. Specialized Exercises (TD1)
A series of activities (`TD1Ex1Activity` to `TD1ExA4Activity`) that likely correspond to specific course modules or lab requirements.

## Development Patterns
- **Adding an Exercise:** Create the Activity, add it to `AndroidManifest.xml`, and add a launch button in `MainActivity` or `TD1MenuActivity`.
- **UI Architecture:** Uses XML layouts with `ViewBinding` (enabled in gradle) or `findViewById`.
- **Data:** Uses `ContentValues` and `Cursor` for SQLite operations.
