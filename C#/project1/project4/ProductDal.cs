using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace project4
{
    class ProductDal
    {
        public List<Product> getAll()
        {
            using (ETradeContext context = new ETradeContext())
            {
                 return context.Products.ToList();
            }
        }

        public void Add(Product product)
        {
            using (ETradeContext context = new ETradeContext())
            {
                context.Products.Add(product);
                context.SaveChanges();
            }
        }

        public void Update(Product product)
        {
            using (ETradeContext context = new ETradeContext())
            {
                var entity = context.Entry(product);
                entity.State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void Delete(Product product)
        {
            using (ETradeContext context = new ETradeContext())
            {
                var entity = context.Entry(product);
                entity.State = EntityState.Deleted;
                context.SaveChanges();
            }
        }
        public List<Product> getByName(string key)
        {
            using (ETradeContext context = new ETradeContext())
            {
                return context.Products.Where(p=>p.Name.Contains(key)).ToList();
            }
        }
        public List<Product> getByUnitPrice(decimal price)
        {
            using (ETradeContext context = new ETradeContext())
            {
                return context.Products.Where(p => p.UnitPrice >= price).ToList();
            }
        }
        public List<Product> getByUnitPrice(decimal min,decimal max)
        {
            using (ETradeContext context = new ETradeContext())
            {
                return context.Products
                    .Where(p => p.UnitPrice >= min && p.UnitPrice <= max).ToList();
            }
        }

        public Product getById(int id)
        {
            using (ETradeContext context = new ETradeContext())
            {
                return context.Products.FirstOrDefault(p => p.Id == id);
            }
        }
    }
}