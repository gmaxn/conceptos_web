namespace EJEMPLO_MVC_NET.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddRemarksFieldToModelProduct : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Products", "Remarks", c => c.String());
            //CreateTable(
            //    "dbo.Products",
            //    c => new
            //        {
            //            ProductID = c.Int(nullable: false, identity: true),
            //            Title = c.String(),
            //            Price = c.Decimal(nullable: false, precision: 18, scale: 2),
            //            LastBuy = c.DateTime(nullable: false),
            //            Stock = c.Int(nullable: false),
            //            Remarks = c.String(),
            //        })
            //    .PrimaryKey(t => t.ProductID);
            
        }
        
        public override void Down()
        {
            DropColumn("dbo.Products", "Remarks");
        }
    }
}
