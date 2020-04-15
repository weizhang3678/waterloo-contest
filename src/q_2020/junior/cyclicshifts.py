str1 = input('')
str2 = input('')
result = 'no'
for i in range(len(str2)):
    str2 = str2[1:len(str2)] + str2[0]
    if str1.count(str2) > 0:
        result = 'yes'
        break
print(result)
    