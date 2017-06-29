
# coding: utf-8

# In[ ]:

"""
Identify DDoS Attacks by continuous 503 error
"""

from datetime import datetime
from collections import deque
FMT = '%H:%M:%S'

timeq=deque([])


def detector(code, timestamp):
    if(len(timeq)):
        if(((datetime.strptime(timestamp, FMT) - datetime.strptime(timeq[0], FMT)).seconds//1800) >= 0):
            print("DDoS Attacks.")
            timeq.popleft()
        else:
            timeq.append(timestamp)
            timeq.popleft()
    else:
        timeq.append(timestamp)

def start():
    code = input('Enter your code [any kind of code] ')
    timestamp = input('Enter timestamp ')
    detector(code, timestamp)
    while(code and timestamp):
        ip = input('Enter your code ')
        timestamp = input('Enter timestamp ')
        detector(code, timestamp)
start()


# In[ ]:



