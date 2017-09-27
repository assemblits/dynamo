#!/usr/bin/env bash

openssl aes-256-cbc -d -a -in .build/sec.enc -out secring.gpg -pass pass:"${SIGNING_DECRYPT_KEY}"

./gradlew uploadArchives -PossrhUsername="${OOSRH_USERNAME}" -PossrhPassword="${OSSRH_PASSWORD}" -Psigning.keyId="${SIGNING_KEY}" -Psigning.password="${SIGNING_PASSWORD}" -Psigning.secretKeyRingFile=secring.gpg