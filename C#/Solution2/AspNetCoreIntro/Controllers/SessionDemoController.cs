using AspNetCoreIntro.Controllers.Entities;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AspNetCoreIntro.Extensions;

namespace AspNetCoreIntro.Controllers
{
    public class SessionDemoController:Controller 
    {
        private string isim = "Engin";

        public string Index1()
        {
            Customer customer = new Customer { Id = 1, FirstName = "maho" };

            HttpContext.Session.SetString("isim","Engin");

            HttpContext.Session.SetObject("customer", customer);

            return "Session oluştu";
        }
        public string Index2()
        {
            Customer customer = HttpContext.Session.GetObject<Customer>("customer");

            return customer.FirstName;
        }
    }
}
