import matplotlib.pyplot as plt
import numpy as np
import Extraction as ext

ra = ext.extract()[5]
time = ext.extract()[4]
vel = ext.extract()[1]

print(ra)
print(time)
print(vel)
