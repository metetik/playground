export class Product{
  id:number;
  name:string;
  description:string;
  price:number;
  categoryId:number;
  imageUrl:string;

  constructor (id: number,name: string,description: string,price: number,categoryId: number,imageUrl: string){
    this.id=id;
    this.name=name;
    this.description=description;
    this.price=price;
    this.categoryId=categoryId;
    this.imageUrl=imageUrl;
  }
}
