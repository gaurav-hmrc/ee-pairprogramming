import org.scalatest.{Matchers, WordSpec}

class CheckoutSpec extends WordSpec with Matchers{


  "calling the checkout cart" should {

    "return the product details" in {
       val shoppingItem = ShoppingItem("Dove soap", 39.99, 5)
      CheckOut.addItem(List(shoppingItem)) shouldBe ShoppingDetails(List(shoppingItem), 199.95)
    }

    "return the 2 same product details" in {
      val shoppingItem1 = ShoppingItem("Dove soap", 39.99, 5)
      val shoppingItem2 = ShoppingItem("Dove soap", 39.99, 3)

      val totalShopping = ShoppingItem("Dove soap", 39.99, 8)

      CheckOut.addItem(List(shoppingItem1, shoppingItem2)) shouldBe ShoppingDetails(List(totalShopping), 319.92)

    }

    "return the price of 2 when you buy 3 (buy 2 get 1 offer)" in {
      val shoppingItem3 = ShoppingItem("Dove soap", 39.99, 3)

      CheckOut.addItem(List(shoppingItem3)) shouldBe ShoppingDetails(List(shoppingItem3), 79.98)

    }

    "return the 2 different product details" in {
      val shoppingItem1 = ShoppingItem("Dove soap", 39.99, 2)
      val shoppingItem2 = ShoppingItem("Axe Deo", 99.99, 2)

      CheckOut.addItem(List(shoppingItem1, shoppingItem2)) shouldBe ShoppingDetails(List(shoppingItem1, shoppingItem2), 279.96)

    }

  }

}
