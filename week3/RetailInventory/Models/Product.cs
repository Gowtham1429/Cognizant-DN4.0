using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace RetailInventory.Models
{
    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public decimal Price { get; set; }
        public int CategoryId { get; set; }
        public Category Category { get; set; }
        public int StockQuantity { get; set; }
        [Timestamp]
        public byte[] RowVersion { get; set; }
        public List<Tag> Tags { get; set; }
        public ProductDetail ProductDetail { get; set; }
    }
}