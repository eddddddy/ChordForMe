# a more complex python program that reads a java int array from input and
# prints the median of that array

import sys
import itertools
import random
import math
import numpy as np

def dosth(s):
	l = list(map(eval,s[1:-1].split(",")))
	l = np.array(l)
	return np.median(l)


if __name__ == "__main__":
	print(dosth(sys.argv[-1]))

