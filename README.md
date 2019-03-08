# Template de projet pour le TP SIR en M1 Miage 2019 UniR

# L’objectif du projet est de construire une application de prise de RDV type doodle mais en y ajoutant un certain nombre de services. 
# L’idée est de partir de la création d’un sondage par un utilisateur sur un choix de dates pour une réunion ayant au moins un intitulé et un résumé. 
# Les participants au sondage renseignent leur nom, leur prénom et leur mail (ils participent au sondage au travers d’un lien Web unique). 
# Quand le créateur du sondage valide une date, si la date contient une pause déjeuner (ou pause), les utilisateurs reçoivent automatiquement un mail avec un lien unique pour renseigner leur préférence alimentaire et leurs allergies. 
# L’application envoie aussi un mail avec un clear code qui contient un code qui pourra être demandé pour entrer dans le bâtiment et un lien vers un pad qui permettra de partager les notes de réunion. 
# Le pad sera un service tierce. 

# Le système doit permettre de sauvegarder l’ensemble des sondages, les choix des participants, les préférences alimentaires des participants, …
# L’email servira d’identifiant pour les participants. 
# Le pad sera initialisé avec le titre de la réunion et une liste des présents et absents en fonction des réponses au sondage. 


# Les fonctionnalités supportées
# ------------------------------
# Réaliser une application en utilisant JPA :
#     -> Créer les classes Java et utiliser JPA pour créer la base de données ainsi que la couche d’accès aux données
#     -> Un template de projet pour la construction d’application autonome utilisant JPA, hibernate et hsqldb
# Les Servlet :
#    -> Combiner JPA et les Servlet
#    -> Comprendre les principes d’une architecture Rest
#    -> Comprendre les bénéfices d’un framework comme Jersey

# Les fonctionnalités à développer
# --------------------------------
# Toute la partie front end, correction du bug lors de la génération de la base avec JPA

# REPONSES AUX QUESTIONS TP NOSQL 
# ------------------------------
# Quelles sont les limites d’une base données orientées document ? 
# Les base de données orientées documents ne fixe de schéma comme le SQL ce qui peut devenir compliquer a gerer et mettre en place


# Quelles sont les types de données stockés dans Redis, que peut on faire comme types de requêtes ?
# On peut stocker et manipuler des valeurs numériques et binaires. 
# On peut donc manipuler des listes, des ensembles, des ensembles triés et des tables de hachage. 
# Les différents type de requêtes sont : get, sadd, zadd, put, hset, hget, hgetall, lpush, rpop.


# ERREUR LORS DE LA GENERATION DE LA BASE
# ------------------------------
# Nous avons rencontré une erreur lors de l'utilisation de JPA que nous n'avons pas réussit à résoudre.
# Par conséquent la base de donnée générée n'est pas valide. 
# Pour des associations entre deux même table, la génération crée une seule table d'association alors que vous voulions en avoir autant    qu'il existe de lien entre les tables. ( voir les association entre nourriture et participant )
