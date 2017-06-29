
# coding: utf-8

# In[1]:

"""
Identify DDoS Attacks by continuous 503 error
"""

from datetime import datetime
from collections import deque
FMT = '%H:%M:%S'
error={}
time={}

timeq=deque([])


def detector(code, timestamp):
    if(len(timeq) == 9):
        if(((datetime.strptime(timestamp, FMT) - datetime.strptime(timeq[0], FMT)).seconds//600)<1):
            print("DDoS Attacks.")
        else:
            timeq.append(timestamp)
            timeq.popleft()
    else:
        timeq.append(timestamp)

def start():
    code = input('Enter your code ')
    timestamp = input('Enter timestamp ')
    detector(code, timestamp)
    while(code and timestamp and code == '503'):
        ip = input('Enter your code ')
        timestamp = input('Enter timestamp ')
        detector(code, timestamp)
start()


# In[ ]:




# In[ ]:



