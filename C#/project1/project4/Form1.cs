using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace project4
{
    public partial class Form1 : Form
    {
        ProductDal _productDal = new ProductDal();

        public Form1()
        {
            InitializeComponent();
        }

        private void LoadProducts()
        {
            dgwProducts.DataSource = _productDal.getAll();
        }
        private void SearchProducts(string key)
        {
            dgwProducts.DataSource = _productDal.getByName(key);
        }
        private void dgwProducts_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            tbxNameUpdate.Text = dgwProducts.CurrentRow.Cells[1].Value.ToString();
            tbxUnitPriceUpdate.Text = dgwProducts.CurrentRow.Cells[2].Value.ToString();
            tbxStockAmountUpdate.Text = dgwProducts.CurrentRow.Cells[3].Value.ToString();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadProducts();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            _productDal.Add(new Product { 
                Name = tbxName.Text,
                StockAmount = Convert.ToInt32(tbxStockAmount.Text),
                UnitPrice = Convert.ToDecimal(tbxUnitPrice.Text)
            });

            LoadProducts();
            MessageBox.Show("Product Added!");
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            Product product = new Product
            {
                Id = Convert.ToInt32(dgwProducts.CurrentRow.Cells[0].Value),
                Name = tbxNameUpdate.Text,
                UnitPrice = Convert.ToDecimal(tbxUnitPriceUpdate.Text),
                StockAmount = Convert.ToInt32(tbxStockAmountUpdate.Text)
            };

            _productDal.Update(product);
            LoadProducts();
            MessageBox.Show("Product Updated!");
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            Product product = new Product
            {
                Id = Convert.ToInt32(dgwProducts.CurrentRow.Cells[0].Value)
            };

            _productDal.Delete(product);
            
            LoadProducts();
            MessageBox.Show("Product Deleted!");
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            SearchProducts(tbxSearch.Text);
        }
    }
}
