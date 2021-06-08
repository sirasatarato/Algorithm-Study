import math
import os
import random
import re
import sys

def triplets(a, b, c):
    a = sorted(list(set(a)))
    b = sorted(list(set(b)))
    c = sorted(list(set(c)))
    ia, ic = 0, 0
    result = 0

    for ib in range(len(b)):
        while ia < len(a):
            if a[ia] <= b[ib]:
                ia += 1
            else:
                break

        while ic < len(c):
            if c[ic] <= b[ib]:
                ic += 1
            else:
                break

        result += ia * ic

    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    lenaLenbLenc = input().split()

    lena = int(lenaLenbLenc[0])

    lenb = int(lenaLenbLenc[1])

    lenc = int(lenaLenbLenc[2])

    arra = list(map(int, input().rstrip().split()))

    arrb = list(map(int, input().rstrip().split()))

    arrc = list(map(int, input().rstrip().split()))

    ans = triplets(arra, arrb, arrc)

    fptr.write(str(ans) + '\n')

    fptr.close()
