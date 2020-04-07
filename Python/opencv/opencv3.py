# resources : 
#   https://www.turanerdemsimsek.com/2017/08/opencv-python-dersleri.html
#   https://www.kitapyurdu.com/kitap/opencv-goruntu-isleme-ve-yapay-ogrenme/376463.html

import numpy as np
import cv2
#Siyah bir zemin oluşturuyoruz
img = np.zeros((512,512,3), np.uint8)

# 5 piksel kalınlığında diagonal mavi bir çizgi çizdiriyoruz. Çizginin özellikleri size kalmış, 
# 8 bitlik değerleri istediğiniz gibi değiştirebilirsiniz.
cv2.line(img,(0,0),(511,511),(255,0,0),5)
cv2.rectangle (img,(384,0), (510,511), (0,255,0), 3)
cv2.circle (img,(447,63),63,(0,0,255),-1)
cv2.ellipse(img,(256,256), (100,50),0,0,180,255,-1)
pts = np.array([[10,5],[20,30],[70,20],[50,10]],np.int32)
pts = pts.reshape((-1,1,2))
cv2.polylines(img,[pts],True,(0,255,255))
#Beyaz renkte Esogu-EEE yazdıracağız.
font = cv2.FONT_HERSHEY_SIMPLEX
cv2.putText(img,'Esogu-EEE', (10,500), font, 4, (255,255,255),2,cv2.LINE_AA)
cv2.imshow("pencere",img)
cv2.waitKey(0)
