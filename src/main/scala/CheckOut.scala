import scala.collection.mutable.ListBuffer

object CheckOut {

  def addItem(shoppingItems: List[ShoppingItem]): ShoppingDetails = {

    val groupItems = shoppingItems.groupBy(item => item.productName)

    var shoppingItemsList = List[ShoppingItem]()

    groupItems.foreach(item =>
      shoppingItemsList = shoppingItemsList :+ ShoppingItem(item._1, item._2.head.itemCost, item._2.map(items => items.numberOfitems).sum)
    )

    val totalCost = shoppingItemsList.map(x => getShoppingCost(x.numberOfitems, x.itemCost)).sum

    ShoppingDetails(shoppingItemsList, totalCost)

  }

  private def isEligibleForBuy3For2(numberOfItems: Int) : Boolean = {
    numberOfItems == 3
  }

  private def getShoppingCost(numberOfItems: Int, costOfItem: BigDecimal): BigDecimal = {
    if(isEligibleForBuy3For2(numberOfItems)) {
      ((numberOfItems - 1) * costOfItem).setScale(2)
    } else {
      (numberOfItems * costOfItem).setScale(2)
    }
  }
}

