import math
import os
import random
import re
import sys

def roadsAndLibraries(n, c_lib, c_road, cities):
    if c_lib <= c_road:
        return n * c_lib

    disjoint = {i:i for i in range(1, n+1)}
    sets = {i:set([i]) for i in range(1, n+1)}

    for c1, c2 in cities:
        r1, r2 = disjoint[c1], disjoint[c2]

        if r1 != r2:
            sets[r2] = sets[r2].union(sets[r1])

            for n in sets[r1]:
                disjoint[n] = r2
            del sets[r1]

    return sum([len(s) * c_road + c_lib - c_road for s in sets.values()])

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        c_lib = int(first_multiple_input[2])

        c_road = int(first_multiple_input[3])

        cities = []

        for _ in range(m):
            cities.append(list(map(int, input().rstrip().split())))

        result = roadsAndLibraries(n, c_lib, c_road, cities)

        fptr.write(str(result) + '\n')

    fptr.close()
