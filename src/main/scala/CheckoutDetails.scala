

case class ShoppingItem(productName : String,
                        itemCost: BigDecimal,
                        numberOfitems: Int)

case class ShoppingDetails(shoppingItems: List[ShoppingItem],
                           totalCost: BigDecimal)


