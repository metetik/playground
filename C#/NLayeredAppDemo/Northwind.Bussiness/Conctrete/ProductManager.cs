using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Northwind.Entities.Concrete;
using Northwind.DataAcess.Concrete.EntityFramework;

namespace Northwind.Business.Concrete
{
    public class ProductManager
    {
        EfProductDal _productDal = new EfProductDal();
        public List<Product> GetAll()
        {
            //Bussiness code

            return _productDal.GetAll();
        }
    }
}
