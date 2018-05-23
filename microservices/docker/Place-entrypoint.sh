#!/bin/sh
while ! nc -z eurekaserver 8761; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
java -jar /opt/lib/place_management-0.0.1-SNAPSHOT.jar
