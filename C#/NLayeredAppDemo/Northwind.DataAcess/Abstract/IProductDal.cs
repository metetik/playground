﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Northwind.Entities.Concrete;

namespace Northwind.DataAcess.Abstract
{
    public interface IProductDal
    {
        List<Product> GetAll();
        Product Get(int productId);
        void Add(Product product);
        void Update(Product product);
        void Delete(Product product);
    }
}
