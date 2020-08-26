using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace project3
{
    public class ProductDal
    {
        SqlConnection _connection = 
            new SqlConnection(@"server=(localdb)\mssqllocaldb;"
                            +   "initial catalog=ETrade;"
                            +   "integrated security=true");
        
        private void ConnectionControl()
        {
            if (_connection.State == ConnectionState.Closed)
            {
                _connection.Open();
            }
        }

        public List<Product> GetAll()
        {
            ConnectionControl();

            SqlCommand command = new SqlCommand("SELECT * FROM Products;", _connection);
            SqlDataReader dataReader = command.ExecuteReader();
            List<Product> products = new List<Product>();

            while (dataReader.Read())
            {
                Product product = new Product
                {
                    Id = Convert.ToInt32(dataReader["Id"]),
                    Name = dataReader["Name"].ToString(),
                    StockAmount = Convert.ToInt32(dataReader["StockAmount"]),
                    UnitPrice = Convert.ToDecimal(dataReader["UnitPrice"])
                };
                products.Add(product);
            }

            dataReader.Close();
            _connection.Close();

            return products;
        }

        public void Add(Product product)
        {
            ConnectionControl();
            SqlCommand command = new SqlCommand(
                "INSERT INTO Products VALUES(@name,@unitPrice,@stockAmount)", _connection);
            command.Parameters.AddWithValue("@name", product.Name);
            command.Parameters.AddWithValue("@unitPrice", product.UnitPrice);
            command.Parameters.AddWithValue("@stockAmount", product.StockAmount);
            command.ExecuteNonQuery();

            _connection.Close();
        }

        public void Update(Product product)
        {
            ConnectionControl();
            SqlCommand command = new SqlCommand(
                "UPDATE Products SET Name=@name,UnitPrice=@unitPrice,StockAmount=@stockAmount WHERE Id=@Id", _connection);
            command.Parameters.AddWithValue("@name", product.Name);
            command.Parameters.AddWithValue("@unitPrice", product.UnitPrice);
            command.Parameters.AddWithValue("@stockAmount", product.StockAmount);
            command.Parameters.AddWithValue("@Id", product.Id);
            command.ExecuteNonQuery();

            _connection.Close();
        }

        public void Delete(int id)
        {
            ConnectionControl();
            SqlCommand command = new SqlCommand(
                "DELETE Products WHERE Id=@Id", _connection);
            
            command.Parameters.AddWithValue("@Id", id);
            command.ExecuteNonQuery();

            _connection.Close();
        }
    }
}
