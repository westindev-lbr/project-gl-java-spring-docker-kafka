# Documentation pour tests fonctionnells.

Je vous mets ci-joint différents JSON servant de request body pour chaque type de discount

ATTENTION : Chaque code doit être écrit en uppercase. La route n'est pas sensible à la casse.

http://localhost:8083/swagger-ui-custom.html

## CODE :

```
{
    "eans" : [
        "1234567890123"
    ],
    "startDate" : "2024-04-23T18:25:43.511Z",
    "endDate" : "2025-04-23T18:25:43.511Z",
    "value" : 20.0,
    "isPercent" : true,
    "code" : "PROMO25"
}
```

## DEFAULT

```
{
    "eans" : [
        "1234567890123"
    ],
    "startDate" : "2024-04-23T18:25:43.511Z",
    "endDate" : "2025-04-23T18:25:43.511Z",
    "value" : 20.0,
    "isPercent" : true,
}
```

## LOT

```
{
    "eans" : [
        "1234567890123"
    ],
    "startDate" : "2024-04-23T18:25:43.511Z",
    "endDate" : "2025-04-23T18:25:43.511Z",
    "numberForLot" : 3,
    "priceForLot" : 3.0
}
```

## LEAST_PRICEY

```
{
    "eans" : [
        "1234567890123"
    ],
    "startDate" : "2024-04-23T18:25:43.511Z",
    "endDate" : "2025-04-23T18:25:43.511Z",
    "value" : 20.0,
    "isPercent" : true
}
```

## ONE_FREE

```
{
    "eans" : [
        "1234567890123"
    ],
    "startDate" : "2024-04-23T18:25:43.511Z",
    "endDate" : "2025-04-23T18:25:43.511Z",
    "numberForOneFree" : 3
}
```