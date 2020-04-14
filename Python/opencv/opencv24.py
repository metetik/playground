import numpy as np
import cv2 as cv

im = cv.imread('data/TEST.jpg',flags=cv.IMREAD_GRAYSCALE)
#res = cv.resize(im,None,fx=0.1, fy=0.1, interpolation = cv.INTER_CUBIC)
ret, thresh = cv.threshold(im, 127, 255, 0)
contours, hierarchy = cv.findContours(thresh, cv.RETR_TREE, cv.CHAIN_APPROX_SIMPLE)
cv.drawContours(thresh, contours, -1, (0,0,255), 1)
cv.namedWindow("2")
cv.imshow("2",thresh)
cv.waitKey(0)