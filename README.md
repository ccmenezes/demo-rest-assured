![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)  ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

# Rest assured project

## Introduction

This project have a proposal to use the [rest assured](https://rest-assured.io/) to test an API Rest.

https://jsonplaceholder.typicode.com/

**Limitation**
* Only get requests tested.

## Prerequisites

Do you need to have Java Sdk, Junit5, Maven and Docker installed.

## How to run the tests

### Create docker image
Do you need to create a docker image, at main root run the command:

```
# code block
docker build -t myrestimage:1 .
```

**docker build:** The command to create the docker image.

**-t:** The tag option to name the image, otherwise it will receive a random name.

**.** The root directory where the Dockerfile is.

### Create a docker container
Do you need to run the container, since the image was successfully created, you can create a container, that will run the tests 
inside and show the test status.

```
# code block
docker run --name myresttest myrestimage:1
```

**docker run:** The command to create a container.

**--name:** The option to name a container.

**myrestimage:1:** The docker image to create a container.


<img src="images/Screenshot from 2024-10-24 12-03-59.png">

## Considerations

I used Ubuntu as my operating system, so maybe It could change if your SO is Windows.

The repository kept the first version tested against a weather API with Junit4 without Docker.
To check please checkout the branch `old-version`.
