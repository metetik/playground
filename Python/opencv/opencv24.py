import numpy as np
import cv2 as cv

im = cv.imread('data/coins.jpg')
#res = cv.res,ize(im,None,fx=0.1, fy=0.1, interpolation = cv.INTER_CUBIC)

imgray = cv.cvtColor(im, cv.COLOR_BGR2GRAY)
imgray = cv.bitwise_not(imgray)
blur = cv.GaussianBlur(imgray,(5,5),0)

cv.imshow("im",blur)
ret,thresh = cv.threshold(imgray,15,255,cv.THRESH_BINARY)
cv.imshow("thresh",thresh)

contours, hierarchy = cv.findContours(thresh, cv.RETR_TREE, cv.CHAIN_APPROX_SIMPLE)
cv.drawContours(im, contours, -1, (0,0,255), 1)

cv.imshow("2",im)
cv.waitKey(0)