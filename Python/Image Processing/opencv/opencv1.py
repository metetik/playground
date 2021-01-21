# resources : 
#   https://www.turanerdemsimsek.com/2017/08/opencv-python-dersleri.html
#   https://www.kitapyurdu.com/kitap/opencv-goruntu-isleme-ve-yapay-ogrenme/376463.html

import numpy as np
import cv2
import matplotlib.pyplot as plt

img1 = cv2.imread("data/img1.jpg")
cv2.imshow("Pencere Adı",img1)
cv2.waitKey(0)

img2 = cv2.imread("data/img1.jpg",cv2.IMREAD_GRAYSCALE)
cv2.imshow("Pencere Adı",img2)
cv2.waitKey(0)

img3 = cv2.imread("data/img1.jpg",)
cv2.imshow("Pencere Adı",img3)
cv2.waitKey(0)

img4 = cv2.imread('data/img1.jpg')
plt.imshow(img4, cmap = 'gray', interpolation = 'bicubic')
plt.show()
