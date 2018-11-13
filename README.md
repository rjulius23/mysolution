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

Usage:

```
E.g.: java -cp mySolution.jar <input file path>
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

To run tests use the provided bash script which generates test input files based on the dimension parameter

```
./run_tests.sh 50   #To generate 50D points
```

### Basic test results with 50-dimension points P(x,y,z.......)

Execution time of different input files

```
Execution time with 10 pieces of 50-dimension points:

real	0m0.223s
user	0m0.316s
sys	0m0.024s

Execution time with 1010 pieces of 50-dimension points:

real	0m0.429s
user	0m0.930s
sys	0m0.028s

Execution time with 2010 pieces of 50-dimension points:

real	0m0.858s
user	0m1.350s
sys	0m0.056s

Execution time with 3010 pieces of 50-dimension points:

real	0m1.692s
user	0m2.272s
sys	0m0.049s

Execution time with 4010 pieces of 50-dimension points:

real	0m3.190s
user	0m3.735s
sys	0m0.104s

Execution time with 5010 pieces of 50-dimension points:

real	0m4.850s
user	0m5.380s
sys	0m0.084s

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

```

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

