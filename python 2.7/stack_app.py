#!/usr/bin/python

"""
	File	: stack_app.py
	Auther	: Rajanikant N. Devmore
	Purpose	: Demonstration of the 'List' data structure and stack.
"""

stack =[]

while True:
	choice = raw_input("""
		Stack Operation 
		================
		1. Push
		2. Pop
		3. Display
		4. Quit
		""")
	if int(choice) == 1:
		element = raw_input('Enter the element to push...')
		stack.append(element);
		print "element inserted..."
	elif int(choice) == 2:
		if len(stack) > 0 :
			element = stack.pop();
			print "%s element is poped..." % (element)
		else : 
			print "stack underflow..."
	elif int(choice) == 3:
		print stack
	elif int(choice) == 4:
		break
	else :
		print 'invalid choice...'

