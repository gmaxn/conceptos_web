using EJEMPLO_MVC_NET.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;


namespace EJEMPLO_MVC_NET.Context
{
    public class StoreContext : DbContext
    {
        public DbSet<Product> Products { get; set; }
    }
}