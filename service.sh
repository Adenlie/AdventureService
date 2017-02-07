#!/usr/bin/env bash

function start {
    dropdb adventure && craetedb adventure
    ./gradlew build && java -jar build/libs/adenlie-adventure-service-0.1.0.jar & echo "$!" > tmp/adventure-service.lock
}

function stop {
    if [ -f "tmp/promotion-core.lock" ]; then
        echo "Stopping adventure service..."
        kill `cat "tmp/adventure-service.lock"`
        rm "tmp/adventure-service.lock"
    else
        echo "Service is not running."
    fi
}

function restart {
    stop
    sleep 1
    start
}

function status {
    id=`jps | grep adventure-service | grep -v grep | grep -v zsh`
    RET=$?
    if [ $RET -eq 0 ]; then
        echo "$1 Service is running..."
    else
        echo "$1 Service is not running..."
    fi
    return $RET
}

case "$1" in
    start)
        status adventure-service && exit 0
        $1
        ;;
    stop)
        $1
        ;;
    restart)
        $1
        ;;
    status)
        $1
        ;;

    *)
        echo "Usage:
        service [stop|start|restart|status] "
        exit 2
esac