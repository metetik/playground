from tkinter import *
from tkinter.colorchooser import askcolor

class Genetik():
   def __init__(self): 
        self.sayac=0
        self.nKromozom=0
        self.positions=[]
     
class Paint(object):
    def __init__(self): 
        self.root = Tk()
        self.c = Canvas(self.root, bg='white', width=600, height=600)
        self.c.grid(row=1, columnspan=5)
        self.c.bind("<Button-1>", self.draw_circles)
        self.g = Genetik()

        self.root.mainloop()

    def draw_circles(self, event):
        self.c.create_oval(event.x-10, event.y-10, event.x+10, event.y+10, outline="#f11", width=2)
        self.g.sayac+=1
        self.g.positions.append([event.x,event.y])
        print(self.g.positions)
        if self.g.sayac==10:
            self.c.unbind("<Button-1>")


if __name__ == '__main__':
    Paint()