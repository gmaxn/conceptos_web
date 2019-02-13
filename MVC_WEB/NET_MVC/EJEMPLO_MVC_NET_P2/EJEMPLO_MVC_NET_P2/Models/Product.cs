using System;
using System.ComponentModel.DataAnnotations;

namespace EJEMPLO_MVC_NET_P2.Models
{
    public class Product
    {
        [Key]
        public int ProductID { get; set; }
        public string Title { get; set; }
        public decimal Price { get; set; }
        public DateTime LastBuy { get; set; }
        public int Stock { get; set; }
        public string Remarks { get; set; }
    }
}