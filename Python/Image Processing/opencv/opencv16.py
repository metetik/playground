#Kod kaç saniyede çalışıyor?
import cv2 as cv

img1 = cv.imread('data/messi5.jpg')
e1 = cv.getTickCount()
for i in range(5,200,2):
    img1 = cv.medianBlur(img1,i)
e2 = cv.getTickCount()

t = (e2 - e1)/cv.getTickFrequency()
print("cv.useOptimized() : "+str(cv.useOptimized()))
print(t)

cv.setUseOptimized(False)

img1 = cv.imread('data/messi5.jpg')
e1 = cv.getTickCount()
for i in range(5,200,2):
    img1 = cv.medianBlur(img1,i)
e2 = cv.getTickCount()

t = (e2 - e1)/cv.getTickFrequency()
print("cv.useOptimized() : "+str(cv.useOptimized()))
print(t)

