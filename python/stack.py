class Queue:
	def __init__(self):
		self.list = []
	
	def push(self,item):
		self.list.append(item)
		print(item+" pushed to Stack")
	
	def pop(self):
		print(len(self.list))
		if(len(self.list)==0):
			print("Stack is Empty")
		else:
			print(self.list[len(self.list)-1]+" popped from Stack")
			self.list.pop()
	
	def top(self):
		if(len(self.list)==0):
			print("Stack is Empty")
		else:
			print(self.list[len(self.list)-1])

	def print_stack(self):
		print(self.list)
		

q=Queue()
flag=True
while(flag):
	choice=int(input("Select Option\n1. Add item to Stack\n2. Remove Item from Stack\n3. Print Stack\n4. Print Stack Top\n5. Exit\n"))
	if(choice==1):
		item = input("Enter item to Push in Stack: ")
		q.push(item)
	elif(choice==2):
		q.pop()
	elif(choice==3):
		q.print_stack()
	elif(choice==4):
		q.top()
	elif(choice==5):
		flag=False
	else:
		print("Invalid Input")