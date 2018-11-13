#!/bin/bash

mvn clean package

if [[ $# -eq 1 ]]; then
    dim="$1"
else
    dim=50
fi

for i in $(seq 10 1000 10000)
do
    python generate_test_files.py -d "$dim" -n $i -f test-file_10_$i.tsv
    echo "Execution time with $i pieces of $dim-dimension points:"
    time java -jar target/closest-pair-identifier-1.1-SNAPSHOT-jar-with-dependencies.jar test-file_10_$i.tsv > /dev/null
    echo ""
done


