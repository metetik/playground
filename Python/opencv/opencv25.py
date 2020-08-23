from PIL import Image
import pytesseract
import cv2

pytesseract.pytesseract.tesseract_cmd = 'C:\\Program Files (x86)\\Tesseract-OCR\\tesseract.exe'
img = cv2.imread("data/atesten_gomlek.jpg")
cv2.imshow("img",img)
cv2.waitKey(0)

img1 = Image.fromarray(img)
a=pytesseract.image_to_string(img1)

print(a)