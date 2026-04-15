package oop_00000105527_michaelchristophersalim.week08

class City(val name: String)
class Address(val city: City?)
class DeliveryDetails(val address: Address?)
class Order(val deliveryDetails: DeliveryDetails?, val totalPrice: Int?)
