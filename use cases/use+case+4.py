
"""
Storing type of response from server (200, 404, etc) 
in a Python list and representing it on a Bar graph. 
This script is used to analyse the failure rate of page requests (404).
"""
import numpy as np
import matplotlib.pyplot as plt

counters = { "404" : 0, "503" : 0, "110" : 0 }

def get_graph():
    
    objects = counters.items()
    performance = counters.values()
    y_pos = np.arange(len(counters))
    performance = performance
    plt.bar(y_pos, performance, align='center', alpha=0.5)
    plt.xticks(y_pos, objects)
    plt.ylabel('Errors')
    plt.title('Errors in server')
    plt.show()
    

def start():
    responce = input("Enter the responce [In integer Values]")
    while responce:
        if responce == '110':
            counters["110"] = counters["110"] + 1
        elif responce == '404':
            counters["404"] = counters["404"] + 1
        elif responce == '503':
            counters["503"] = counters["503"] + 1 
        else :
            print("Responce is not valid...")
        responce = input("Enter the responce [In integer Values]")
    get_graph()
    
start()

