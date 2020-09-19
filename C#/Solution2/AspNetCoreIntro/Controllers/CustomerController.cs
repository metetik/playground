using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using AspNetCoreIntro.Controllers.Entities;
using AspNetCoreIntro.Models;
using Microsoft.AspNetCore.Mvc.Rendering;
using AspNetCoreIntro.Services.Logging;

namespace AspNetCoreIntro.Controllers
{
    [Route("deneme")]
    public class CustomerController : Controller
    {
        private ILogger _logger;

        public CustomerController(ILogger logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        [Route("index")]
        public IActionResult Index3()
        {
            _logger.Log("");

            List<Customer> customers = new List<Customer>()
            {
                new Customer{Id=1,FirstName="afsaf",LastName="asfasf",City="asdğpkasf"},
                new Customer{Id=2,FirstName="fn1",LastName="ln1",City="city1"},
                new Customer{Id=3,FirstName="fn2",LastName="ln2",City="city2"}

            };
            List<string> shops = new List<string> { "Ankara", "Istanbul", "Izmir" };

            var model = new CustomerListViewModel
            {
                Customers = customers,
                Shops = shops
            };

            return View(model);
        }
        [HttpGet]
        [Route("save")]
        public IActionResult SaveCustomer()
        {
            return View(new SaveCustomerViewModel
            {
                Cities = new List<SelectListItem>
                {
                    new SelectListItem{Text="Ankara", Value="06"},
                    new SelectListItem{Text="Istanbul", Value="34"},
                    new SelectListItem{Text="Izmir", Value="35"}
                }
            });
        }
        
        [HttpPost]
        [Route("save")]
        public string SaveCustomer(Customer customer)
        {
            return "Kaydedildi";
        }
    }
}