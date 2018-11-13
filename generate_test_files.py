import argparse
import random as rng
import sys

def parse_commandline():
    usage = ("\n"
             "./{script} -d|--dimension <integer> -n|--number"
             " <number of points> -f|--filename <fname>").format(script=sys.argv[0])
    parser = argparse.ArgumentParser(
            usage=usage,
            formatter_class=argparse.RawDescriptionHelpFormatter,
            description=("CLI Tool to Generate test input files\n"))
    parser.add_argument('-d', "--dimension", dest='dimension',
                        help=argparse.SUPPRESS, required=True)
    parser.add_argument('-n', "--number", dest='number',
                        help=argparse.SUPPRESS, required=True)
    parser.add_argument('-f', "--filename", dest='fname',
                        help=argparse.SUPPRESS, required=False, default="test-input-file.tsv")
    args_ret = parser.parse_args()
    return args_ret


# Class to realize multi dimensional points
class MultiDimPoint:
    def __init__(self, dimension):
        self.coords = []
        self.dim = int(dimension)

    def generate_coords(self):
        for i in range(0,self.dim):
            self.coords.append(rng.uniform(-10000.0000, 10000.0000))

# Save the generated points in a test file
def save_results(test_filename, generated_points):
    with open(test_filename, "w") as f:
        for point in generated_points:
            f.write("\t".join(map(str, point.coords)))
            f.write("\n")
        f.close()

if __name__ == '__main__':
    args = parse_commandline()
    points = []
    for i in range(0, int(args.number)):
        point = MultiDimPoint(args.dimension)
        point.generate_coords()
        points.append(point)
    save_results(args.fname, points)

