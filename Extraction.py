import pyodbc
import numpy

def extract():
    conn = pyodbc.connect(r'Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\Users\quint\OneDrive\Desktop\Regression\reg.accdb;')
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

    #extracting all values from the database
    cursor.execute('select * from ExperimentalResults')
    count = 0
    for row in cursor.fetchall():
        exid[count] = int(row[0])
        velocity[count] = int(row[2])
        diamond[count] = int(row[3])
        hydration[count] = int(row[4])
        time[count] = int(row[5])
        ravalue[count] = int(row[6])
        ryvalue[count] = int(row[7])
        count = count+1

    extracted = [exid,velocity,diamond,hydration,time,ravalue,ryvalue]
    return(extracted)
