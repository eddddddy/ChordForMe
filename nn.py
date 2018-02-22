import numpy as np
import tensorflow as tf

import time
start = time.time()

#Output is list with two elements
#First element is chord name e.g. "G#"
#Second element is root note

#testing how long it takes to read byte data
all_lines = []
with open('C:\\Users\\James Jiang\\Documents\\in.txt') as f:
    for line in f:
        bytes_str = line.rstrip('\n')[1:-1].split(", ")
        all_lines.append([int(byte) for byte in bytes_str])

print(time.time() - start)
input()
