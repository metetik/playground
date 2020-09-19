using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using AspNetCoreIntro.Controllers.Entities;
using AspNetCoreIntro.Models;

namespace AspNetCoreIntro.Controllers
{
    public class ProductController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        public string Index2(int id)
        {
            return id.ToString();
        }
        
    }
}