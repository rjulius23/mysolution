#!/bin/bash

if [ -f './target/closest-pair-identifier-1.1-SNAPSHOT-jar-with-dependencies.jar' ]; then
    mvn clean package
fi

for i in $(seq 10 1000 10000)
do
    python generate_test_files.py -d "$1" -n $i -f test-file_10_$i.tsv
    echo "Execution time with $i pieces of 50-dimension points:"
    time java -jar target/closest-pair-identifier-1.1-SNAPSHOT-jar-with-dependencies.jar test-file_10_$i.tsv > /dev/null
    echo ""
done


