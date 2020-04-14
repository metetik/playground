import cv2
import numpy as np

events = [i for i in dir(cv2) if 'EVENT' in i]
print( events )

# mouse callback function
def draw_circle(event,x,y,flags,params):
    if event == cv2.EVENT_LBUTTONDBLCLK:
        cv2.circle(img,(x,y),20,(255,0,0),thickness=-1)

img = np.zeros((512,512,3), np.uint8)
cv2.namedWindow('image')
cv2.setMouseCallback('image',draw_circle)

while True:
    cv2.imshow("image",img)
    if cv2.waitKey(1) & 0xFF == 27:
        break
