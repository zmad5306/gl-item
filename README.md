# gl-item
Grocery list, item service

## Build with Docker

`gradlew build`

`docker build . --build-arg version=0.0.1-SNAPSHOT -t zmad5306/gl-item:latest`

`docker push zmad5306/gl-item:latest`

## Deploy with Kubernetes

`kubectl apply -f k8s/deployment.yml`

`kubectl apply -f k8s/service.yml`

# API

| URL                                    | Method | Description                                           |
| -------------------------------------- | ------ | ----------------------------------------------------- |
| /api/item/{listId}                     |GET     | Gets items in a list                                  |
| /api/item/{listId}/{departmentId}      |GET     | Gets items in a list for a department                 |
| /api/list/{listId}/{departmentId}      |POST    | Adds a new item to a list, in the supplied department |
| /api/list/{itemId}                     |PUT     | Updates an item                                       |
| /api/list/{itemId}                     |DELETE  | Deletes an item                                       |