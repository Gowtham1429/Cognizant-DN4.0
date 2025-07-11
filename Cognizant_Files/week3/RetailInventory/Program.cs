using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RetailInventory.Models;

class Program
{
    static async Task Main(string[] args)
    {
        await Lab4_InsertData();
        await Lab5_ReadData();
        await Lab6_UpdateDelete();
        await Lab7_LinqQueries();
        await Lab8_SchemaChange();
        await Lab9_SeedData();
        await Lab10_Loading();
        await Lab11_Relationships();
        await Lab12_CircularReferences();
        await Lab13_QueryOptimization();
    }

    static async Task Lab4_InsertData()
    {
        using var context = new AppDbContext();
        var electronics = new Category { Name = "Electronics" };
        var groceries = new Category { Name = "Groceries" };
        await context.Categories.AddRangeAsync(electronics, groceries);
        var product1 = new Product { Name = "Laptop", Price = 75000, Category = electronics };
        var product2 = new Product { Name = "Rice Bag", Price = 1200, Category = groceries };
        await context.Products.AddRangeAsync(product1, product2);
        await context.SaveChangesAsync();
    }

    static async Task Lab5_ReadData()
    {
        using var context = new AppDbContext();
        var products = await context.Products.ToListAsync();
        foreach (var p in products)
            Console.WriteLine($"{p.Name} - ₹{p.Price}");

        var product = await context.Products.FindAsync(1);
        Console.WriteLine($"Found: {product?.Name}");

        var expensive = await context.Products.FirstOrDefaultAsync(p => p.Price > 50000);
        Console.WriteLine($"Expensive: {expensive?.Name}");
    }

    static async Task Lab6_UpdateDelete()
    {
        using var context = new AppDbContext();
        var product = await context.Products.FirstOrDefaultAsync(p => p.Name == "Laptop");
        if (product != null)
        {
            product.Price = 70000;
            await context.SaveChangesAsync();
        }

        var toDelete = await context.Products.FirstOrDefaultAsync(p => p.Name == "Rice Bag");
        if (toDelete != null)
        {
            context.Products.Remove(toDelete);
            await context.SaveChangesAsync();
        }
    }

    static async Task Lab7_LinqQueries()
    {
        using var context = new AppDbContext();
        var filtered = await context.Products.Where(p => p.Price > 1000).OrderByDescending(p => p.Price).ToListAsync();
        var productDTOs = await context.Products.Select(p => new ProductDTO { Name = p.Name, CategoryName = p.Category.Name }).ToListAsync();
    }

    static async Task Lab8_SchemaChange()
    {
        using var context = new AppDbContext();
        var product = await context.Products.FirstOrDefaultAsync();
        if (product != null)
        {
            product.StockQuantity = 25;
            await context.SaveChangesAsync();
        }
    }

    static async Task Lab9_SeedData() { }

    static async Task Lab10_Loading()
    {
        using var context = new AppDbContext();
        var products = await context.Products.Include(p => p.Category).ToListAsync();
        var product = await context.Products.FirstAsync();
        await context.Entry(product).Reference(p => p.Category).LoadAsync();
    }

    static async Task Lab11_Relationships() { }

    static async Task Lab12_CircularReferences()
    {
        using var context = new AppDbContext();
        var productDTOs = await context.Products.Select(p => new ProductDTO { Name = p.Name, CategoryName = p.Category.Name }).ToListAsync();
    }

    static async Task Lab13_QueryOptimization()
    {
        using var context = new AppDbContext();
        var products = await context.Products.AsNoTracking().ToListAsync();
    }
}