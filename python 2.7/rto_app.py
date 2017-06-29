#!/usr/bin/python

"""
	File	: rto_app.py 
	Auther	: Rajanikant N. Devmore
	Purpose	: to demonstrate the rto CRUD application
"""

state_list ={}

while True:
	choice = raw_input("""
		RTO Operation 
		================
		1. Create 
		2. Read 
		3. Update
		4. Delete
		5. Quit
		""")
	if int(choice) == 1:
		state_code = raw_input("Enter the state code...")
		if state_code in state_list:
			print "Enter the valid state code..."
		else :
			state_list[state_code] = raw_input("Enter the state name...")

	elif int(choice) == 2:
		print state_list

	elif int(choice) == 3:
		state_code = raw_input("Enter the state code for update...")
		if state_code in state_list:
			state_name = raw_input("Enter the state name")
			response = raw_input("You want to update the State name(Y/n)... ")
			if response in "Yy":
				state_list[state_code] = state_name
				print "State name is updated succfually..."
			else : 
				print "You aborted the operation..."
		else :
			print "Enter the valid state code..."
	elif int(choice) == 4:
		state_code = raw_input("Enter the state code for delete...")
		if state_code in state_list:
			response = raw_input("You want to update the State name(Y/n)... ")
			if response in "Yy":
				state_list.pop(state_code)
				print "removed succefually..."
			else : 
				print "You aborted the operation..."
			
		else :
			print "Enter the valid state code..."
		
	elif int(choice) == 5:
		break
	
	else :
		print 'invalid choice...'

