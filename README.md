# sa4e-server

This project uses Quarkus, the Supersonic Subatomic Java Framework to receive messages from a MQTT Server and displays them in a small frontend.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

## Native build and packaging as docker image

To build native and package in docker image, run `build.sh`.
This will create a runnable docker image with all features.

This image can be run with:
```shell
docker run -it -p 8080:8080 io.github.fierg/sa4e-server:1.0
```

or if the build fails, a published image is available with:
```shell
docker run -it -p 8080:8080 docker.io/fierg/sa4e:1.0
```
