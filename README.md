# 📝 Java CLI Task Manager — Gestionnaire de Tâches Console

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![CLI](https://img.shields.io/badge/Interface-Terminal%20CLI-black?logo=gnometerminal)](https://en.wikipedia.org/wiki/Command-line_interface)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Application interactive en ligne de commande développée en **Java** démontrant les principes fondamentaux de la **programmation orientée objet (POO)**, la manipulation de collections dynamiques (`ArrayList`) et la gestion des flux d'entrée/sortie standards (`Scanner`).

---

## 🚀 Fonctionnalités

- ➕ **Ajout dynamique de tâches** : Enregistrement à la volée avec description textuelle personnalisée.
- 📋 **Affichage tabulaire** : Visualisation de l'état d'avancement des tâches avec indicateurs visuels (`[Done]` / `[ ]`).
- ✅ **Marquage & validation** : Modification d'état par indexation sécurisée avec contrôle des bornes.
- 🔄 **Boucle interactive d'événements** : Menu interactif basé sur les nouvelles expressions switch (`switch-case` moderne Java).

---

## 🛠️ Compilation & Exécution

### Prérequis
- Un environnement **JDK 17** ou supérieur.

### Commandes
```bash
# 1. Cloner le projet
git clone https://github.com/SKJUV/projet-console.git
cd projet-console

# 2. Compiler la classe
javac ToDoList.java

# 3. Lancer l'application
java ToDoList
```

---

## 🏛️ Concepts Clés Démontrés
- **Encapsulation & Classes imbriquées** : Structure statique `Tache` encapsulant l'état de complétion et la description.
- **Gestion des exceptions & flux utilisateur** : Purge du buffer d'entrée clavier (`scanner.nextLine()`) après saisie numérique.
- **Cycle de vie CLI** : Libération propre des ressources système (`scanner.close()`) à la terminaison.
