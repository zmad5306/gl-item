# gl-item
Grocery list, item service

## Build with Docker

`gradlew build`

`docker build . --build-arg version=0.0.1-SNAPSHOT -t zmad5306/gl-item:latest`

`docker push zmad5306/gl-item:latest`

# API

| URL                                    | Method | Description                                           |
| -------------------------------------- | ------ | ----------------------------------------------------- |
| /api/item/{listId}                     |GET     | Gets items in a list                                  |
| /api/item/{listId}/{departmentId}      |GET     | Gets items in a list for a department                 |
| /api/item/{listId}/{departmentId}      |POST    | Adds a new item to a list, in the supplied department |
| /api/item/{itemId}                     |PUT     | Updates an item                                       |
| /api/item/{itemId}                     |DELETE  | Deletes an item                                       |

## GET /api/item/{listId} 

### Sample response

```json
[
    {
        "itemId": "5ab4e0a352faff0001d45094",
        "listId": "5ab4da845f15030001942891",
        "departmentId": "5ab4cf0b52faff0001f95039",
        "username": "sue",
        "active": true,
        "quantity": 3,
        "name": "pizza",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/item/5ab4e0a352faff0001d45094",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/list/5ab4da845f15030001942891",
                "hreflang": null,
                "media": null,
                "title": "list",
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/dept/5ab4cf0b52faff0001f95039",
                "hreflang": null,
                "media": null,
                "title": "dept",
                "type": null,
                "deprecation": null
            }
        ]
    },
    {
        "itemId": "5ab4e0b052faff0001d45095",
        "listId": "5ab4da845f15030001942891",
        "departmentId": "5ab4cf0b52faff0001f95039",
        "username": "sue",
        "active": true,
        "quantity": 8,
        "name": "pizza 2",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/item/5ab4e0b052faff0001d45095",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/list/5ab4da845f15030001942891",
                "hreflang": null,
                "media": null,
                "title": "list",
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/dept/5ab4cf0b52faff0001f95039",
                "hreflang": null,
                "media": null,
                "title": "dept",
                "type": null,
                "deprecation": null
            }
        ]
    }
]
```

## GET /api/item/{listId}/{departmentId}

### Sample response

```json
[
    {
        "itemId": "5ab4e0a352faff0001d45094",
        "listId": "5ab4da845f15030001942891",
        "departmentId": "5ab4cf0b52faff0001f95039",
        "username": "sue",
        "active": true,
        "quantity": 3,
        "name": "pizza",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/item/5ab4e0a352faff0001d45094",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/list/5ab4da845f15030001942891",
                "hreflang": null,
                "media": null,
                "title": "list",
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/dept/5ab4cf0b52faff0001f95039",
                "hreflang": null,
                "media": null,
                "title": "dept",
                "type": null,
                "deprecation": null
            }
        ]
    },
    {
        "itemId": "5ab4e0b052faff0001d45095",
        "listId": "5ab4da845f15030001942891",
        "departmentId": "5ab4cf0b52faff0001f95039",
        "username": "sue",
        "active": true,
        "quantity": 8,
        "name": "pizza 2",
        "links": [
            {
                "rel": "self",
                "href": "http://minikube:31726/api/item/5ab4e0b052faff0001d45095",
                "hreflang": null,
                "media": null,
                "title": null,
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/list/5ab4da845f15030001942891",
                "hreflang": null,
                "media": null,
                "title": "list",
                "type": null,
                "deprecation": null
            },
            {
                "rel": "self",
                "href": "/api/dept/5ab4cf0b52faff0001f95039",
                "hreflang": null,
                "media": null,
                "title": "dept",
                "type": null,
                "deprecation": null
            }
        ]
    }
]
```

## POST /api/item/{listId}/{departmentId} 

### Sample request

```json
{
	"active": true,
	"quantity": 8,
	"name": "pizza 2"
}
```

### Sample response

```json
{
    "itemId": "5ab4e0b052faff0001d45095",
    "listId": "5ab4da845f15030001942891",
    "departmentId": "5ab4cf0b52faff0001f95039",
    "username": "sue",
    "active": true,
    "quantity": 8,
    "name": "pizza 2",
    "_links": {
        "self": [
            {
                "href": "http://minikube:31726/api/item/5ab4e0b052faff0001d45095"
            },
            {
                "href": "/api/list/5ab4da845f15030001942891",
                "title": "list"
            },
            {
                "href": "/api/dept/5ab4cf0b52faff0001f95039",
                "title": "dept"
            }
        ]
    }
}
```

## PUT /api/item/{itemId}

### Sample request

```json
{
    "active": false,
    "quantity": 2,
    "name": "steak"
}
```

### Sample response

```json
```

## DELETE/api/item/{itemId}

### Sample response

```json
```