#Morphological Transformations
import cv2 as cv
import numpy as np
import matplotlib.pyplot as plt

img = cv.imread('data/j.png',0)

kernel = np.ones((5,5),np.uint8)
erosion = cv.erode(img,kernel,iterations = 1)
dilation = cv.dilate(img,kernel,iterations = 1)
opening = cv.morphologyEx(img, cv.MORPH_OPEN, kernel)
closing = cv.morphologyEx(img, cv.MORPH_CLOSE, kernel)
gradient = cv.morphologyEx(img, cv.MORPH_GRADIENT, kernel)
tophat = cv.morphologyEx(img, cv.MORPH_TOPHAT, kernel)
blackhat = cv.morphologyEx(img, cv.MORPH_BLACKHAT, kernel)

plt.subplot(421),plt.imshow(img,cmap="gray"),plt.title('Original Image')
plt.subplot(422),plt.imshow(erosion,cmap="gray"),plt.title('Erosion')
plt.subplot(423),plt.imshow(dilation,cmap="gray"),plt.title('Dilation')
plt.subplot(424),plt.imshow(opening,cmap="gray"),plt.title('Opening')
plt.subplot(425),plt.imshow(closing,cmap="gray"),plt.title('Closing')
plt.subplot(426),plt.imshow(gradient,cmap="gray"),plt.title('Gradient')
plt.subplot(427),plt.imshow(tophat,cmap="gray"),plt.title('Tophat')
plt.subplot(428),plt.imshow(blackhat,cmap="gray"),plt.title('BlackHat')

plt.show()