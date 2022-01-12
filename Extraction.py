import pyodbc
import numpy

def extract(num):
    conn = pyodbc.connect(r'Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:/Users/quint/OneDrive/Desktop/Yoco/reg.accdb;')
    cursor = conn.cursor()

    #finding the amount of entries in the database
    cursor.execute('select * from ExperimentalResults')
    amountitems = len(cursor.fetchall())

    #setting null values for population
    exid = numpy.zeros(amountitems)
    velocity = numpy.zeros(amountitems)
    diamond = numpy.zeros(amountitems)
    hydration = numpy.zeros(amountitems)
    time = numpy.zeros(amountitems)
    ravalue = numpy.zeros(amountitems)
    ryvalue = numpy.zeros(amountitems)
    force = numpy.zeros(amountitems)

    #extracting all values from the database
    cursor.execute('select * from ExperimentalResults')
    count = 0
    for row in cursor.fetchall():
        exid[count] = int(row[0])
        velocity[count] = float(row[2])
        diamond[count] = float(row[3])
        hydration[count] = float(row[4])
        time[count] = float(row[5])
        ravalue[count] = float(row[6])
        ryvalue[count] = float(row[7])
        force[count] = float(row[8])
        count = count+1

    extracted = {1:exid,2:velocity,3:diamond,4:hydration,5:time,6:ravalue,7:ryvalue,8:force}
    return(extracted[num])
