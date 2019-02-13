using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EJEMPLO_MVC_NET.Models
{
    public class Product
    {
        [Key]
        public int ID { get; set; }
        public string Descripcion { get; set; }
        public decimal Price { get; set; }
        public DateTime LastBuy { get; set; }
        public float Stock { get; set; }



    }
}