# 🎬 TMDB API Test Automation Project

This project contains an automated API testing framework for **The Movie Database (TMDB)**.  
It validates core functionalities such as authentication, account operations, movie data retrieval, and negative authorization scenarios.

---

## 🛠️ Tech Stack & Tools
- ☕️ Java
- 🌐 REST Assured
- ✅ TestNG
- 📦 Maven
- 📊 Allure Report
- 🧩 JSON / Jackson
- 🔧 Git & GitHub

---

## 🧪 Test Coverage Summary

This automation suite includes tests for:

### ✅ Authentication  
- Valid login  
- Invalid login  
- Token/session validation  

### ✅ Account Operations  
- Retrieve account details  
- Manage favorites and watchlist  

### ✅ Movie Endpoints  
- Retrieve genres, popular movies, top rated, upcoming, etc.  
- Search movies  
- Get movie details  

### ❗ Negative Scenarios  
- Unauthorized requests (e.g., invalid session ID)

---

## ▶️ Running the Test Suite

```bash
git clone https://github.com/your-repo/tmdb-api-tests.git
mvn clean test
mvn allure:serve
```

## 👥 Team
- Ruya Tiras
- Aslihan Gulluoglu
- Taner Ozcelik
- Efe Ersan


