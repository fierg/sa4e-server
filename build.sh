#!/bin/bash

set -e

printf '##################\nCompiling and performing native build ...\n##################\n'

./gradlew clean build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker

printf '##################\nBuilding docker image ...\n##################\n'

./gradlew imageBuild

printf '##################\nDone. run with:\n docker run -it -p 8080:8080 io.github.fierg/sa4e-server:1.0\n##################\n'