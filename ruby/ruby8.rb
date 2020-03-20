#ruby de nesneler
#attr_accessor : hem okuma hem yazma
#attr_reader : okuma
#attr_writer : yazma
#@title = this.title = self.title
class Film    
    attr_accessor :title,:director,:stars
    
    def initialize(title,director,stars)
      puts "Obje oluşturuluyor"
      @title = title
      @director = director
      @stars = stars
    end
    
    def isActorIncluded(actorName)
        isIncluded = false

        for actor in @stars
            if (actor == actorName)
                isIncluded = true
            end
        end
        
        if isIncluded
            puts "Aktör bulunuyor"
        else
            puts "Aktör bulunmuyor"
        end
    end
    
end

film1 = Film.new("Masumiyet","Zeki Demirkubuz",["Haluk Bilginer","Derya Alabolra","Güven Kıraç"])

film1.isActorIncluded("Haluk Bilgine2r")