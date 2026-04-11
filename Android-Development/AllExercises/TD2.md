# Université Mohamed V Rabat
## Ecole Supérieure de Technologie de Salé
### Département d'informatique
**Filière :** IAM  
**Année :** 2025/2026  
**Module :** TD Android

---

### Exercice 1 : Structure de vues
1. Soit une zone texte dans l'activité.
2. Modifier les marges et les positionnements.
3. Ajuster la couleur et l'opacité.
4. Afficher le contenu de cette zone avec la classe `Toast`.
5. Tester la propriété cliquable avec java et xml.

### Exercice 2 : Cycle de vie d'une activité
Afficher par la classe `Toast` et par les LogCat un message pour chaque méthode du cycle de vie d'une activité.
`Log.i(TAG, "Salut !"), .....`

### Exercice 3 : editText
Copier le contenu d'un editText dans un label après clic sur un bouton puis par implémentation de l'interface `TextWatcher`.

### Exercice 4 : OnTouch
Réaliser un `FrameLayout`. Mettre dedans une image.
Appliquer l'événement `OnTouch` sur cette image. Si on touche l'image elle sera remplacée par une autre.

### Exercice 5
Afficher le nombre de clic sur un bouton à l'aide d'une boite de dialogue.

### Exercice 6
Réaliser une application avec une image. L'image suit votre doigt sur l'écran une fois vous la touchez.

### Exercice 7
Réaliser une application qui prend votre date de naissance du calendrier et affiche votre âge sur une `AlertDialog`.

### Exercice 8 : conversion de devise
[Image : exo8_convertisseur_monetaire.png]

### Exercice 9 :
[Image : exo9_radio_boutons_fruits.png]

### Exercice 10
Remplir un tableau par les jours de la semaine puis les afficher dans un `Spinner`.*

---

### Exercice 11 : authentification avec les intents explicites
1) Réaliser une application dans laquelle, si le login et le mot de passe sont incorrects une activité d'erreur est lancée, sinon vous lancez l'activité principale.
2) Réaliser un projet permettant la communication entre deux activités.
   L'activité principale envoie des données (deux nombres) à l'activité 2. L'activité 2 traite ces données (somme) et envoie le résultat à l'activité principale.

### Exercice 12 : démarrage du téléphone
Ecrire un `BroadcastReceiver` qui s'exécute lors du démarrage du téléphone.

### Exercice 13 : Listes

[Image : exo13_listview_repas.png]

1. Un appui long sur un item permet de voir plus d'info sur le repas.
2. Un clic permet de sélectionner les repas voulus.
3. Vous pouvez calculer la somme de votre facture en cliquant sur ces repas.

### Exercice 14 : Interception des sms
* Réaliser une activité qui intercepte un SMS et affiche un message dans une zone de texte.
* Réaliser une activité pour appel téléphonique.

### Exercice 15
L'objectif de cet exercice est de créer deux applications.
* La première application, installée sur le téléphone d'un enfant, permet d'envoyer sa position à une base de données toutes les 30mn.
* La deuxième application installée sur le téléphone du père de cet enfant permet de récupérer ces positions et affiche la carte Google Map avec des marqueurs sur les positions.