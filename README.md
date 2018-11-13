# Closest Pair Identifier for N-dimensions

Java based solution for the closest point pair in N-dimensions.
Not full solution.

## Getting Started


### Prerequisites

Install maven tool for Java

```
sudo apt-get install maven
```

Install OpenJDK-8

```
sudo apt-get install openjdk-8-jdk
```

Install Python interpreter

```
sudo apt update
sudo apt install python3.6
```
### Installing

A step by step series of examples that tell you how to get a development env running

Clone the git repo

```
git clone https://github.com/rjulius23/mysolution.git
```

Build the package using Maven

```
cd <repo path>
mvn clean package
```

Run the generated jar file which has "jar-with-dependencies" in its name

```
java -jar target/closest-pair-identifier-1.1-SNAPSHOT-jar-with-dependencies.jar <input file path>
```

## Running the tests

To run tests use the provided bash script which generates test input files based on the dimension parameter

```
./run_tests.sh 50   #To generate 50D points
```

### Basic test results with 50-dimension points P(x,y,z.......)

Execution time of different input files with 50D and 1000D points
to demonstrate the weaknesses and limits of the current algorithm.

```

Execution time with 6010 pieces of 50-dimension points:

real	0m3.672s
user	0m4.201s
sys	0m0.119s

Execution time with 7010 pieces of 50-dimension points:

real	0m5.413s
user	0m6.012s
sys	0m0.048s

Execution time with 8010 pieces of 50-dimension points:

real	0m7.984s
user	0m8.612s
sys	0m0.056s

Execution time with 9010 pieces of 50-dimension points:

real	0m11.079s
user	0m11.731s
sys	0m0.080s

Execution time with 10 pieces of 1000-dimension points:

real	0m0.302s
user	0m0.486s
sys	0m0.037s

Execution time with 1010 pieces of 1000-dimension points:

real	0m2.431s
user	0m3.040s
sys	0m0.086s

Execution time with 2010 pieces of 1000-dimension points:

real	0m8.492s
user	0m9.124s
sys	0m0.124s

Execution time with 3010 pieces of 1000-dimension points:

real	0m17.918s
user	0m18.563s
sys	0m0.260s

Execution time with 4010 pieces of 1000-dimension points:

real	0m30.398s
user	0m31.487s
sys	0m0.261s

Execution time with 5010 pieces of 1000-dimension points:

real	0m49.178s
user	0m50.272s
sys	0m0.476s

Execution time with 6010 pieces of 1000-dimension points:

real	1m8.513s
user	1m9.511s
sys	0m0.456s

Execution time with 7010 pieces of 1000-dimension points:

real	1m37.298s
user	1m38.263s
sys	0m0.436s
```
### Conclusion of the tests above

It can be seen that even with the usage of Array arithmetics ( common-math3 ), the execution time 
of the 1000D points slows down exponentially. In the future it is worth investigating on how to
adapt Plain sweep or Divide and Conquer algorithms for the n-dimensional problem. The gain for smaller dimension points is not significant if the number of points is below 10000.

### Generate test input files

Run the provided python code to generate various test files

```
usage: 
./generate_test_files.py -d|--dimension <integer> -n|--number <number of points> -f|--filename <fname>
```

## References

* [Rosetta-Code](https://rosettacode.org/wiki/Closest-pair_problem)
* https://baptiste-wicht.com/posts/2010/04/closest-pair-of-point-plane-sweep-algorithm.html

## Built With

* [Common-Math3](http://commons.apache.org/proper/commons-math/) - The Apache Commons Mathematics Library

## Authors

* **Gyula Halmos**

