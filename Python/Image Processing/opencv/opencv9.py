import cv2
import numpy as np

img = np.zeros((640,640,3),dtype=np.uint8)

cv2.imshow("pencere",img)
cv2.waitKey(0)

cv2.line(img,(0,50),(640,50),(255, 122, 0),thickness=7)
cv2.imshow("pencere",img)
cv2.waitKey(0)

cv2.rectangle(img,(0,100),(640,320),(0, 0, 250),thickness=7)
cv2.imshow("pencere",img)
cv2.waitKey(0)

#Merkez 150,100 yarıçap 60
cv2.circle(img,(150,100), 60, (0,200,255),thickness=5)
cv2.imshow("pencere",img)
cv2.waitKey(0)

#(img,merkezkoordinat,(majoraxis,minoraxis),angle,startangle,
# endangle,color,thikness,shift)
cv2.ellipse(img,(256,256),(100,50),0,0,180,255,thickness=2)
cv2.imshow("pencere",img)
cv2.waitKey(0)

pts = np.array([[10,5],[20,30],[70,20],[50,10]], np.int32)
pts = pts.reshape((-1,1,2))
cv2.polylines(img,[pts],True,(0,255,255))
cv2.imshow("pencere",img)
cv2.waitKey(0)

font = cv2.FONT_HERSHEY_PLAIN
cv2.putText(img,'OpenCV',(10,400), font, 4,(255,255,255),3,cv2.LINE_8)
cv2.imshow("pencere",img)
cv2.waitKey(0)
