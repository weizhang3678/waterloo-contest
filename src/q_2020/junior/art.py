number = int(input(''))
top = 0
right = 0
bottom = 100
left = 100
for i in range(number):
    str = input('')
    strs = str.split(',')
    x = int(strs[0])
    y = int(strs[1])
    if top <= y:
        top = y+1
    if bottom >= y:
        bottom = y - 1
    if right <= x:
        right = x +1
    if left >= x:
        left = x -1
    
print('%i,%i' %(left, bottom))
print('%i,%i' %(right,top))