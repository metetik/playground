# resources : 
#   https://www.turanerdemsimsek.com/2017/08/opencv-python-dersleri.html
#   https://www.kitapyurdu.com/kitap/opencv-goruntu-isleme-ve-yapay-ogrenme/376463.html

import cv2

def webcam_goster():

    cap = cv2.VideoCapture(0) # harici bir kamerada i=0 yerine i=1,2,3..vs kullanabilirsiniz

    while True:

    #Çerçeveler halinde görüntü yakalar
        ret, frame = cap.read()

        type(ret)
    #Üzerinde işlem yapacağımız çerçeve buraya gelsin
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    #Sonuç Çerçeveyi Görüntüleme:
        cv2.imshow('frame',gray)
        if cv2.waitKey(1) & 0xFF == ord('q'): # q ile çıkış yapabilirsiniz
            break

    #Herşey yolunda gitti ise dükkanı kapatabiliriz :)
    cap.release()
    cv2.destroyAllWindows()

def video_goster():
    cap = cv2.VideoCapture('data/youtube BYZpsbu9ds.mp4') # Kullanacağınız videonun adını buraya yazmalısınız!!

    while(cap.isOpened()):
    #Çerçeveler halinde görüntü yakalar
        ret, frame = cap.read()

    #Üzerinde işlem yapacağımız çerçeve buraya gelsin ve griye dönsün
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    #Sonuç Çerçeveyi Görüntüleme:
        cv2.imshow('frame',gray)
        if cv2.waitKey(1) == ord('q'):
            break

    #Herşey yolunda gitti ise dükkanı kapatabiliriz :)
    cap.release()
    cv2.destroyAllWindows()

def video_kaydet():
    cap = cv2.VideoCapture(0)
    #Codec tanımlama ve VideoWriter nesnesi(object) oluşturma
    fourcc = cv2.VideoWriter_fourcc(*'XVID')
    out = cv2.VideoWriter('output.avi', fourcc, 20.0, (640,480))#20 fps, 640,480

    while(cap.isOpened()):
        ret, frame = cap.read()
        if ret == True:
            frame = cv2.flip(frame,0)
            out.write(frame)
            
            cv2.imshow('frame',frame)
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break
        else:
            break
    #Herşey yolunda gitti ise dükkanı kapatabiliriz :)
    cap.release()
    out.release()
    cv2.destroyAllWindows()
def main():
    webcam_goster()
    video_goster()
    video_kaydet()

main()