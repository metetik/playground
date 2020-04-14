import numpy as np
import cv2

img1 = cv2.imread("data/img1.jpg")
print(img1.shape)
cv2.imshow("img1",img1)

img2 = cv2.imread("data/opencv-logo.png")
print(img2.shape)
cv2.imshow("img2",img2)

img3 = cv2.add(img1[0:240,0:195,:],img2)
cv2.imshow('adding',img3)

img4 = cv2.addWeighted(img1[0:240,0:195,:],0.7,img2,0.3,0)
cv2.imshow("blending",img4)

cv2.waitKey(0)
cv2.destroyAllWindows()