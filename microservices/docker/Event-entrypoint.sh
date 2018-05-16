#!/bin/sh
while ! nc -z eureka-server 8761; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
java -jar /var/lib/docker/event.jar