using NUnit.Framework;
using CalcLibrary;

namespace CalcLibrary.Tests
{
    [TestFixture]
    public class CalculatorTests
    {
        private Calculator calc;

        [SetUp]
        public void Setup()
        {
            calc = new Calculator();
        }

        [Test]
        [TestCase(2, 3, 5)]
        [TestCase(0, 0, 0)]
        [TestCase(-5, 5, 0)]
        public void Add_ValidInputs_ReturnsExpected(int a, int b, int expected)
        {
            Assert.That(calc.Add(a, b), Is.EqualTo(expected));
        }

        [Test]
        [TestCase(5, 3, 2)]
        [TestCase(10, 5, 5)]
        [TestCase(0, 0, 0)]
        [TestCase(-5, -5, 0)]
        public void Subtract_ValidInputs_ReturnsExpected(int a, int b, int expected)
        {
            Assert.That(calc.Subtract(a, b), Is.EqualTo(expected));
        }

        [TearDown]
        public void Cleanup()
        {
            calc = null!;
        }
    }
}
