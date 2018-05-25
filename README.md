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

test
=======
# gl-item
Grocery list, item service

## Build with Docker

`docker build . --build-arg version=0.0.1-SNAPSHOT -t zmad5306/gl-item:latest`

`docker push zmad5306/gl-item:latest`

## Circle CI Build

https://circleci.com/gh/zmad5306/gl-item

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

## Continious Integration Builds

### GitHub Integration

#### Storage Bucket

A storage bucket is required to store an encrypted GitHub OAuth authenticaion token. This is utilzed by the builds to authenticate to GitHub to push changes, create branches and create pull requests. The name of the storage bucket is passed to the builds as Substitution Variables (see _GIT_HUB_KEY_BUCKET_NAME below).

#### Cryptographic Keys

In the Google Cloud Platform Console there must be a Cryptographic Key-Ring and Key created. The name of the key-ring and key are passed to the builds (see _KMS_KEY and _KMS_KEYRING below).

In addition to creating the keys a GitHub access token must be encrypted in a hub.enc and uploaded to the storage bucked created above.

Create a `hub` file in the following format:

```yaml
github.com:
  - protocol: https
    user: ${GITHUB_USERNAME}
    oauth_token: <git hub token here>
```

See Creating a personal access token for the command line for more details: https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/

Once the `hub` file is created it needs encrypted using the gcloud API:

`gcloud kms encrypt --location=global --keyring=gl-keyring --key=gl --plaintext-file=hub --ciphertext-file=hub.enc`

Then finally, the hub.enc needs uploaded to the storage bucked created above.

### Staging

**Name:** Item Micro-Service Staging CI Build

**Trigger type:** Branch

**Branch (regex):** ^develop$

**Build configration:** cloudbuild.yaml

**cloudbuild.yaml location:** /staging/cloudbuild.yaml

#### Staging Substitution variables

| Variable                    | Value               |
| --------------------------- | -----               |
| _CLOUDSDK_COMPUTE_ZONE      | us-central1-f       |
| _CLOUDSDK_CONTAINER_CLUSTER | staging             |
| _KMS_KEY                    | gl                  |
| _KMS_KEYRING                | gl-keyring          |
| _PROJECT_ID                 | grocery-list-205220 |
| _GIT_HUB_KEY_BUCKET_NAME    | gl-git-hub-key      |

### QA

**Name:** Item Micro-Service QA CI Build

**Trigger type:** Tag

**Tag (regex):** .*

**Build configration:** cloudbuild.yaml

**cloudbuild.yaml location:** /qa/cloudbuild.yaml

#### QA Substitution variables

| Variable                    | Value               |
| --------------------------- | -----               |
| _CLOUDSDK_COMPUTE_ZONE      | us-central1-f       |
| _CLOUDSDK_CONTAINER_CLUSTER | qa                  |
| _KMS_KEY                    | gl                  |
| _KMS_KEYRING                | gl-keyring          |
| _PROJECT_ID                 | grocery-list-205220 |
| _GIT_HUB_KEY_BUCKET_NAME    | gl-git-hub-key      |