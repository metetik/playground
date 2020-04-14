* If you are using a 64-bit machine, you will have to modify k = cv.waitKey(0) line as follows : k = cv.waitKey(0) & 0xFF

* <u>warning:</u> Color image loaded by OpenCV is in BGR mode. But Matplotlib displays in RGB mode. So color images will not be displayed correctly in Matplotlib if image is read with OpenCV. Please see the exercises for more details.

* img.item(10,10,2) : tek pixel'e erişmek için
* img.itemset((10,10,2),100) : tek pixeli değiştirmek için.
* img.size : toplam pixel sayısı
* img.dtype : datatype. Bu önemli çünkü opencv'de veri tipi uyuşmazlığı hatalarına sık rastlanır.
* bgr kanallarını ayırma : 
    * b,g,r = cv.split(img)
    * img = cv.merge((b,g,r))
    
        veya
    * b = img[:,:,0]

* <u>Warning</u> : cv.split() is a costly operation (in terms of time). So use it only if necessary. Otherwise go for Numpy indexing.

* cv.setUseOptimized() : kodların daha hızlı çalışmasını sağlar. 

    cv.useOptimized() : optimize özelliği açık mı?
* <u>Note :</u>Python scalar operations are faster than Numpy scalar operations. So for operations including one or two elements, Python scalar is better than Numpy arrays. Numpy has the advantage when the size of the array is a little bit bigger.

### Renk uzayı dönüşümleri
* cv2.cvtColor(input_image, flag)
    
    flag : dönüşüm tipi
* HSV : Hue, Saturation, Value.
    For HSV, hue range is [0,179], saturation range is [0,255], and value range is [0,255]

### Geometrik Dönüşümler
* https://docs.opencv.org/master/d7/d4d/tutorial_py_thresholding.html
### Thresholding
* https://docs.opencv.org/master/d7/d4d/tutorial_py_thresholding.html
### Smoothing Images
https://docs.opencv.org/master/d4/d13/tutorial_py_filtering.html
