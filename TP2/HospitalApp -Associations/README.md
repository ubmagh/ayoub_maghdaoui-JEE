
### [ :arrow_backward: TP2 ](https://github.com/ubmagh/ayoub_maghdaoui-JEE/tree/main/TP2 "Go back")
<br>
  
# TP2: Hospital App

### Compte rendu


Après l'initialisation du projet sur l'editeur intellij avec l'outil 'Spring initializr', avec les dépendances nécessaires :

<img src="./imgs/1.png" width="600">
Notez qu'il faut traviller soit avec MySQL soit avec la BD en mémoire H2, j'ai désactivé une (voir `pom.xml`).


<br>

### Création des entités : 

* J'ai créé le package `entities` qui va regrouper toutes les entités de l'app

<br>

> l'entité `Patient` :

<img src="./imgs/2.png" width="600">


> l'entité `Medecin` :

<img src="./imgs/3.png" width="600">


> l'entité `RendezVous` :

<img src="./imgs/4.png" width="600">

* avec l'enumération `StatusRDV` :
<img src="./imgs/5.png" width="300">


> l'entité `Consultation` :

<img src="./imgs/6.png" width="600">


<br>

### Création des repositories :

* Après la definition des entités, j'ai créé une répository pour chaque entité dans le package `repositories` :

<br>

> Le repository `PatientRepository` :

<img src="./imgs/7.png" width="600">


> Le repository `MedecinRepository` :

<img src="./imgs/8.png" width="600">


> Le repository `ConsultationRepository` : (vide)

<img src="./imgs/9.png" width="600">


> Le repository `RendezVousRepository` : (vide)

<img src="./imgs/10.png" width="600">


<br>

### Création d'un service qui va représenter la couche métier :

* avant de coder le service, il faut définir l'interface qui va etre implémentée par le service (couplage faible ;).
* les services existent dans le package `services`

> L'interface implémentée par la couche métier `IHospitalService` : 

<img src="./imgs/11.png" width="600">



> Le service `IHospitalServiceImpl` :

<img src="./imgs/12.png" width="600">




<br>

### Application Spring :

* Dans une application Spring `SpringDataAppApplication` j'ai essayé de tester les fonctions définies dans le service :
* [voici un lien directe vers ce fichier](https://github.com/ubmagh/ayoub_maghdaoui-JEE/blob/main/TP2/HospitalApp%20-Associations/src/main/java/me/ubmagh/hospital/SpringDataAppApplication.java "here")

> Avant de passer à l'exécution du programme il fallait configurer les paramètres de connexion à la BD `ressources.application.properties` ;

<img src="./imgs/13.png" width="400">


> Voici une partie de l'application Spring qui va faire des insertion dans la BD:

<img src="./imgs/14.png" width="400">


<br>

* Voici les enregistrements insérés dans la BD, visualisés avec Navicat :

    - La table des patients :
      
      <img src="./imgs/15.png" width="400">

    - La table des medecins :
      
      <img src="./imgs/16.png" width="400">

    - La table des rendezVous :
      
      <img src="./imgs/17.png" width="400">

    - La table des consultations :
      
      <img src="./imgs/18.png" width="400">






<br>

### Création d'un controlleur web :

* dans le package `web` j'ai créé le controlleur `PatientsController` qui va contenir une route pour retourner tous les patients sous fromat JSON :

<img src="./imgs/19.png" width="600">


> Au lancement de l'app, le lien `localhsot:8081/patients` retourne les résultats suivants :

<img src="./imgs/20.png">

<br>

> Fin

<hr>
