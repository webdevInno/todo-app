# 🌸 SonPlan — Gestionnaire de Tâches

> Application web de gestion de tâches développée avec **Spring Boot** et **Thymeleaf**

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.11-green?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-darkgreen?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.9-red?style=flat-square&logo=apachemaven)

---

## 📋 Description

**SonPlan** est une application web de gestion de tâches développée dans le cadre de l'examen à l'**Université Cheikh Hamidou Kane** — Master 1 Ingénierie Logiciel.

Elle permet de :
- ➕ **Ajouter** une tâche avec titre, description et statut
- ✏️ **Modifier** une tâche existante
- 🗑️ **Supprimer** une tâche avec confirmation
- ✅ **Marquer** une tâche comme terminée
- 📊 Voir les **statistiques en temps réel**
- 🔔 Recevoir des **notifications visuelles** pour chaque action

---

## 🛠️ Technologies Utilisées

| Technologie | Version | Rôle |
|---|---|---|
| Java | 21 LTS | Langage de programmation |
| Spring Boot | 3.5.11 | Framework backend |
| Spring Data JPA | 3.5.x | Persistance des données |
| Thymeleaf | 3.1.x | Moteur de templates HTML |
| MySQL | 8.0 | Base de données |
| Lombok | 1.18.x | Réduction du code répétitif |
| Maven | 3.9.x | Gestion des dépendances |

---

## 🏗️ Architecture en Couches

```
┌─────────────────────────────────────┐
│         VUE (Thymeleaf)             │  taches.html | modifier.html
├─────────────────────────────────────┤
│           CONTROLLER                │  TacheViewController | TacheController
├─────────────────────────────────────┤
│            SERVICE                  │  ITacheService | TacheService
├─────────────────────────────────────┤
│          REPOSITORY                 │  TacheRepository (JpaRepository)
├─────────────────────────────────────┤
│          ENTITY / DTO               │  Tache.java | TacheDTO.java
├─────────────────────────────────────┤
│        BASE DE DONNÉES              │  MySQL — tododb — table : taches
└─────────────────────────────────────┘
```

---

## ✅ Principes SOLID

| Principe | Description | Implémentation |
|---|---|---|
| **S** — Single Responsibility | Chaque classe a une seule responsabilité | `TacheService`, `TacheRepository`, `TacheViewController` séparés |
| **O** — Open/Closed | Ouvert à l'extension, fermé à la modification | Nouvelles fonctionnalités sans modifier l'existant |
| **L** — Liskov Substitution | `TacheService` peut remplacer `ITacheService` | `TacheService implements ITacheService` |
| **I** — Interface Segregation | Interface bien définie | `ITacheService` avec méthodes précises |
| **D** — Dependency Inversion | Dépendre des abstractions | Controllers dépendent de `ITacheService` |

---

## 📁 Structure du Projet

```
todo-backend/
├── src/main/java/com/todoapp/todo_backend/
│   ├── controller/
│   │   ├── HomeController.java
│   │   ├── TacheController.java        (API REST)
│   │   └── TacheViewController.java    (Vues Thymeleaf)
│   ├── dto/
│   │   └── TacheDTO.java
│   ├── entity/
│   │   └── Tache.java
│   ├── repository/
│   │   └── TacheRepository.java
│   ├── service/
│   │   ├── ITacheService.java          (Interface)
│   │   └── TacheService.java           (Implémentation)
│   └── TodoBackendApplication.java
├── src/main/resources/
│   ├── templates/
│   │   ├── taches.html
│   │   └── modifier.html
│   └── application.properties
└── pom.xml
```

---

## ▶️ Comment Lancer le Projet

### Prérequis
- Java 21
- MySQL 8.0
- Maven 3.9

### Étapes

**1. Cloner le projet**
```bash
git clone https://github.com/webdevInno/todo-app.git
cd todo-app
```

**2. Configurer la base de données**

Dans `src/main/resources/application.properties` :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tododb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

**3. Lancer l'application**
```bash
mvn spring-boot:run
```

**4. Ouvrir dans le navigateur**
```
http://localhost:8080
```

---

## 📸 Aperçu

| Page principale | Modification |
|---|---|
| Liste des tâches avec statistiques | Formulaire pré-rempli |
| Notifications visuelles | Confirmation de suppression |

---

## 👤 Auteure

**Ndeye Sokhna Mbaye**
- 🎓 Master 1 — Ingénierie Logiciel
- 🏫 Université Cheikh Hamidou Kane
  

---

## 📄 Licence

Projet académique — Examen — Université Cheikh Hamidou Kane — 2026
