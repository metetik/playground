boxes = [1,2,3]
unitsPerBox = [3,2,1]
truckSize = 3

def getMaxUnits(boxes, unitsPerBox, truckSize):
    summ = 0

    for i in range(truckSize):
        maxUnitsIndex = getMaxIndex(unitsPerBox)
        
        if(boxes[maxUnitsIndex] == 0):
            unitsPerBox[maxUnitsIndex] = 0
            maxUnitsIndex = getMaxIndex(unitsPerBox)
            boxes[maxUnitsIndex] -= 1
            summ += unitsPerBox[maxUnitsIndex]
        else:
            boxes[maxUnitsIndex] -= 1
            summ += unitsPerBox[maxUnitsIndex]
    
    return summ

def getMaxIndex(li):
    max1 = 0
    for i in range(len(li)):
        if li[i] > li[max1]:
            max1 = i
    
    return max1

a = getMaxUnits(boxes,unitsPerBox,truckSize)
print(a)

"""

def getMaxUnits(boxes, unitsPerBox, truckSize):
    print("/////////////////////\\\\\\\\\\\\\\\\")
    print(boxes)
    print(unitsPerBox)
    print(truckSize)
    print("/////////////////////\\\\\\\\\\\\\\\\")
    
    summ = 0

    for i in range(truckSize):
        maxUnitsIndex = unitsPerBox.index(max(unitsPerBox))
        
        if(boxes[maxUnitsIndex] == 0):
            unitsPerBox[maxUnitsIndex] = 0
            maxUnitsIndex = unitsPerBox.index(max(unitsPerBox))
            boxes[maxUnitsIndex] -= 1
            summ += unitsPerBox[maxUnitsIndex]
        else:
            boxes[maxUnitsIndex] -= 1
            summ += unitsPerBox[maxUnitsIndex]
    
    return summ
"""