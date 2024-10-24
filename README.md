# PROJET SRA1

Groupe B - Projet 3

Axel LABARRE M2GL - <axel.labarre.etu@univ-lille.fr>

## PRE-REQUIS

Avoir démarrer le démon docker sur sa machine

## Configuration de développement local

1. Lancement des conteneurs kafka :

    ```sh
    docker-compose -f docker-compose.local.yml up -d
    ```

2. Lancement des micro-services :

    a. Product-Referencement

    ```sh
    cd product-referencement
    mvn clean install exec:java -pl productreferencement-application
    ```

    b. Discount-Management :

    ```sh
    cd discount-management
    mvn clean install exec:java -pl discountmanagement-application
    ```

## Configuration de pré-production

1. Lancement des conteneurs kafka & micro-services

    ```sh
    docker-compose -f docker-compose.yml up -d
    ```

* URL product-referencement-api : `http://localhost:8082`
* URL discount-management-api : `http://localhost:8083`
* URL kafka : `http://localhost:3000`

---

## Help - Commandes docker utiles

* Arreter docker :

    ```sh
    docker-compose -f <docker-compose.yml> down
    ```

* Reconstuire les conteneurs dockers si nouveaux changements :

    ```sh
    docker-compose build
    ```

* Lancer un terminal interactif dans un conteneur :

    ```sh
    docker exec -it <contneur> bash
    ```

* Inspecter les logs d'un conteneur :

    ```sh
    docker logs <contneur>
    ```
