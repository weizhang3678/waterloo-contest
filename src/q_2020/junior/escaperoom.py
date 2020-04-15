cellDict = {}
cellList = []
row = int(input(''))
searched = [[0 for i in range(1005)] for i in range(1005)]
column = int(input(''))
result = 'no'
class Cell:
  def __init__(self, r, c):
    self.row = r
    self.column = c 
last = Cell(row, column)
def willArrived(cell):    
    cellList.append(cell)
    while(cellList):
        cell = cellList[0]
        del cellList[0] 
        neighbors = cellDict[str(cell.row * cell.column)]
        for neighbor in neighbors:
            if neighbor.row == 1 and neighbor.column == 1:
                return "yes"
            elif searched[cell.row][cell.column] == 0:
                searched[cell.row][cell.column] =1
                cellList.append(neighbor)
    return "no"
for i in range(row):
    valueStr = input('')
    values = valueStr.split(" ")
    for j in range(column):
        cell = Cell(i+1,j+1)
        if values[j] not in cellDict:
            list1 = [cell]
            cellDict[values[j]] = list1
        else:
            cellDict[values[j]].append(cell)
print(willArrived(last))    


