list1 = []
list2 = []

input1 = int(raw_input())
for x in range(input1):
    p = raw_input()
    list1.append(p)
    
input2 = int(raw_input())
for x in range(input2):
    p = raw_input()
    list2.append(p)
    
final = [] 

for x in list2:
    counter = 0
    for y in list1:
        if y == x:
            counter += 1
    final.append(counter)
    
for x in final:
    print x