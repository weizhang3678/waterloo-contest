p = int(input(''))
n = int(input(''))
r = int(input(''))
total_number = n
new_number = n
day = 0
while(total_number <= p):
    new_number *= r
    total_number += new_number
    day += 1
print(day)