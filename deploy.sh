#!/bin/bash

SCRIPT_HOME="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
JARFILE="${SCRIPT_HOME}/target/scala-2.12/sparkGen-assembly-0.1.jar"

SPARK_HOME="${SPARK_HOME:-/opt/spark}"

"${SPARK_HOME}/bin/spark-submit" \
    --class="sparkgen.Main" \
    --master="local" \
    --driver-java-options "-Dlog4j.configuration=file://${SCRIPT_HOME}/log4j.properties" \
    "$JARFILE" "$@"
