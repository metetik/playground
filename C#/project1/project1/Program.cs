using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace project1
{
    class Program
    {
        //referans ve değer tipler
        static void Main(string[] args)
        {
            int number1 = 10;
            int number2 = 20;

            number2 = number1;

            number1 = 30;

            Console.WriteLine(
                "number1 : {0}\nnumber2 : {1}",number1,number2);
            Console.ReadLine();

            string[] cities1 = new string[] { "Adana", "Adıyaman", "Afyon" };
            string[] cities2 = new string[] { "Bursa", "Bolu", "Balıkesir" };

            cities1 = cities2;

            cities2[1] = "Bilecik";

            Console.Write("cities1 : ");
            foreach (var city in cities1){ Console.Write("{0}, ",city); }
            Console.Write("\ncities2 : ");
            foreach (var city in cities2){ Console.Write("{0}, ",city); }


            Console.ReadLine();

        }
    }
}
