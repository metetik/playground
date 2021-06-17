class Sinif1:
    sinif_degiskeni = "sınıf değişkeni 1"

    def __init__(self):
        self.ornek_degiskeni = "örnek değişkeni 1"
        self.__private_degisken = "private degisken 1"

    def ornek_metodu(self):
        print("ornek metodu")

    @classmethod
    def sinif_metodu(cls):
        print("sinif metodu")
    
    @staticmethod
    def statik_metod():
        print("statik metod")

    @property
    def private_degisken(self):
        return self.__private_degisken

    @private_degisken.setter
    def private_degisken(self,__private_degisken):
        self.__private_degisken = __private_degiskenw