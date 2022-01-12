import Extraction
import numpy as np
from sklearn.linear_model import LinearRegression

def model():
    datain = {"velocity":"2", "diamond": "3", "hydration":"4","time":"5"}
    dataout = {"ravalue":"6","ryvalue":"7", "force":"8"}

    selectedin = input("Which input value would you like to correlate: velocity, diamond, hydration or time?")

    selectedout = input("Which output value would you like to correlate: ravalue, ryvalue or force?")

    selin = int(datain[selectedin])
    selout = int(dataout[selectedout])

    inarr = Extraction.extract(selin)
    outarr = Extraction.extract(selout)

    x = inarr.reshape((-1,1))
    y = outarr

    mod = LinearRegression()

    mod.fit(x,y)

    rsquared = mod.score(x,y)
    intercept = mod.intercept_
    slope = mod.coef_

    modout = mod.predict(x.reshape((-1,1)))

    px = float(input("Enter a value to predict for your input:"))
    x2 = np.ones(len(x))*px
    outpred = mod.predict(x2.reshape((-1,1)))

    
    return(mod,intercept,rsquared,slope,outpred,x,y, modout)