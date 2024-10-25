# PROJET SRA1

Groupe B - Projet 3

Axel LABARRE M2GL - <axel.labarre.etu@univ-lille.fr>

## PRE-REQUIS

Avoir démarrer le démon docker sur sa machine

## Configuration de développement en local

Vous veillerez à ouvrir 3 terminaux au préalable pour les taches (1), (2.a) et (2.b)

1. Lancement des conteneurs kafka :

    ```sh
    docker-compose -f docker-compose.local.yml up -d
    ```

2. Lancement des micro-services :

    a. Product-Referencement

    ```sh
    cd product-referencement && mvn clean install
    ```

    puis

    ```sh
    cd productreferencement-application && mvn spring-boot:run
    ```

    b. Discount-Management :

    ```sh
    cd discount-management && mvn clean install
    ```

    puis

    ```sh
    cd discountmanagement-application && mvn spring-boot:run
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
