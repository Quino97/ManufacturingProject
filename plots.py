import matplotlib.pyplot as plt
import numpy as np
import linearmodel as lm

outputs = lm.model()
model = outputs[0]
intercept = outputs[1]
rsquared = outputs[2]
slope = outputs[3]
outpred =outputs[4]
x = outputs[5]
y = outputs[6]
modout = outputs[7]

plt.title("Fitted Data") 
plt.xlabel("input") 
plt.ylabel("output") 
plt.plot(x,y, "ob")
plt.plot(x,outpred, 'r') 
plt.plot(x,modout, 'g') 
plt.show()
