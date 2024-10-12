# Application Galerie de Stars pour Android

## Aperçu
Cette application Android est une galerie de stars de cinéma, avec un écran d'accueil animé et une liste de stars incluant des capacités de filtrage.

## Fonctionnalités
- Écran d'accueil animé
- RecyclerView pour afficher une liste de stars de cinéma
- Système de notation pour chaque célébrité
- Fonction de recherche permettant de filtrer les stars par nom et genre
- Option de partage de l'application
- Boîte de dialogue pour modifier la note des stars

## Structure du projet
- `adapter` : Contient le `StarAdapter` pour la gestion de la RecyclerView.
- `beans` : Inclut la classe `Star` qui représente une star de cinéma.
- `dao` : Contient l'interface `IDao` pour les opérations d'accès aux données.
- `service` : Inclut la classe `StarService` qui implémente l'interface `IDao`.

## Composants clés
1. **SplashActivity** : Affiche un logo animé avant de rediriger vers l'activité principale.
2. **ListActivity** : Affiche la liste des stars et gère la fonctionnalité de recherche.
3. **StarAdapter** : Adaptateur personnalisé pour la RecyclerView, incluant la logique de filtrage.
4. **Star** : Classe modèle représentant une star de cinéma.
5. **StarService** : Classe de service Singleton pour gérer les données des stars.
