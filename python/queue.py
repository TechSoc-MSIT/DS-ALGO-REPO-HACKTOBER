class Queue:
	def __init__(self):
		self.list = []
	
	def enqueue(self,item):
		self.list.insert(0,item)
		print(item+" added to Queue")
	
	def dequeue(self):
		if(len(self.list)==0):
			print("Queue is Empty")
		else:
			self.list.pop()
			print("Removed from Queue")
	
	def print_queue(self):
		print(self.list)
		

q=Queue()
flag=True
while(flag):
	choice=int(input("Select Option\n1. Add item to Queue\n2. Remove Item from Queue\n3. Print the Queue \n4. Exit\n"))
	if(choice==1):
		item = input("Enter item to Enqueue: ")
		q.enqueue(item)
	elif(choice==2):
		q.dequeue()
	elif(choice==3):
		q.print_queue()
	elif(choice==4):
		flag=False
	else:
		print("Invalid Input")
