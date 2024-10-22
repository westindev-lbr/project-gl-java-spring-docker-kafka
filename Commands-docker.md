# DOCKER RUN

## PRE-REQUIS

Lancer le démon docker sur votre machine

## Monter les conteneurs dockers

```sh
docker-compose -f docker-compose.yml up -d
```

URL product-referencement-api : `http://localhost:8082`
URL discount-management-api : `http://localhost:8083`
URL kafka :

## Arreter docker

```sh
docker-compose -f docker-compose.yml down
```

## Reconstuire les conteneurs dockers si nouveaux changements

```sh
docker-compose build
```

## Aide

* Lancer un terminal interactive dans le conteneur docker

```sh
docker exec -it <contneur> bash
```

* Inspecter un conteneur docker

```sh
docker logs <contneur>
```
