 RoomMVVMDemo

Description
RoomMVVMDemo est une application Android développée en Java qui permet de gérer une liste de notes en utilisant l’architecture MVVM et la persistance locale avec Room.

L’application permet :
- d’ajouter une note avec un titre et une description
- d’afficher toutes les notes dans une liste RecyclerView
- de supprimer une note par clic long
- de supprimer toutes les notes
- de conserver les notes même après fermeture de l’application

--------------------------------------------------

Objectifs du lab
- Comprendre l’architecture MVVM
- Comprendre le rôle de Entity, DAO, RoomDatabase, Repository, ViewModel et LiveData
- Utiliser Room pour stocker des données localement
- Utiliser RecyclerView pour afficher une liste de notes
- Séparer clairement les responsabilités entre les classes
- Éviter les opérations de base de données sur le thread principal
- Observer automatiquement les changements grâce à LiveData

--------------------------------------------------

Technologies utilisées
- Java
- Android Studio
- Room
- SQLite
- MVVM
- LiveData
- ViewModel
- RecyclerView
- CardView
- ExecutorService

--------------------------------------------------

Structure du projet

RoomMVVMDemo
│
├── data
│   ├── local
│   │   ├── Note.java
│   │   ├── NoteDao.java
│   │   └── NoteDatabase.java
│   └── NoteRepository.java
│
├── ui
│   ├── MainActivity.java
│   └── NoteAdapter.java
│
└── viewmodel
    └── NoteViewModel.java

--------------------------------------------------

Rôle des classes

Note.java
Représente l’Entity Room. Cette classe correspond à une table dans la base SQLite. Elle contient les colonnes id, title et description.

NoteDao.java
Représente l’interface d’accès aux données. Elle contient les méthodes insert, delete, deleteAllNotes et getAllNotes.

NoteDatabase.java
Représente la base Room. Elle fournit l’instance unique de la base de données et permet d’accéder au DAO.

NoteRepository.java
Joue le rôle d’intermédiaire entre le ViewModel et la base de données. Il exécute les opérations Room dans un thread secondaire grâce à ExecutorService.

NoteViewModel.java
Contient la logique de présentation. Il communique avec le Repository et expose les données à l’Activity sous forme de LiveData.

MainActivity.java
Représente la couche UI. Elle récupère les actions de l’utilisateur et observe les données envoyées par le ViewModel.

NoteAdapter.java
Permet d’afficher les notes dans le RecyclerView. Il gère aussi le clic simple et le clic long sur une note.

--------------------------------------------------

Fonctionnement de l’application

Quand l’utilisateur ajoute une note :
1. Il saisit un titre et une description.
2. Il clique sur le bouton AJOUTER UNE NOTE.
3. MainActivity crée un objet Note.
4. MainActivity appelle noteViewModel.insert(note).
5. Le ViewModel envoie la note au Repository.
6. Le Repository insère la note dans Room sur un thread secondaire.
7. Room sauvegarde la note dans SQLite.
8. LiveData notifie automatiquement l’Activity.
9. L’Adapter met à jour le RecyclerView.

Quand l’utilisateur supprime une note :
1. Il effectue un clic long sur une note.
2. MainActivity appelle noteViewModel.delete(note).
3. Le Repository supprime la note dans Room.
4. LiveData renvoie la nouvelle liste.
5. RecyclerView se met à jour automatiquement.

--------------------------------------------------

Résultat attendu
- Les notes s’ajoutent correctement.
- Les notes s’affichent dans le RecyclerView.
- Le clic long supprime une note.
- Le bouton SUPPRIMER TOUTES LES NOTES vide la liste.
- Les notes restent enregistrées après fermeture de l’application.
- La liste reste correcte après rotation de l’écran.

--------------------------------------------------

Conclusion
Ce lab montre comment construire une application Android moderne avec Room et MVVM.

Grâce à cette architecture :
- le code est mieux organisé
- chaque classe a une responsabilité claire
- l’interface utilisateur reste simple
- les données sont persistées localement
- les changements de données sont observés automatiquement
- l’application devient plus facile à maintenir et à faire évoluer

Cette architecture est utilisée dans les applications Android professionnelles.




https://github.com/user-attachments/assets/636f46dc-aef9-4165-9d23-b71ee772a1c9



