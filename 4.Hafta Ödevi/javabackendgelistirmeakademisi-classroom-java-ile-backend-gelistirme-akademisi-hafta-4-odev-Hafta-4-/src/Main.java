
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
   private static final String FILE_NAME="etrade.txt";

   public static class Products {
      public static Customers Customer;
      public static Products.Order Order;
      private String productName;
      private int productId;
      private int productPrice;


      private static List<Products> products = new ArrayList<>();

      Products(String productName, int productId, int productPrice) {
         this.productName = productName;
         this.productId = productId;
         this.productPrice = productPrice;

      }
      @Override
      public String toString(){
         return "Products{" +
                 "productName='" + productName + '\'' +
                 ", productId=" + productId +
                 ", productPrice=" + productPrice +
                 '}';
      }
      public  int getProductPrice(){
         return productPrice;
      }

      void displayProductsInfo() {
         System.out.println("Product Name : " + productName);
         System.out.println("Product Id : " + productId);
         System.out.println("Product Price : " + productPrice);
      }

      static class shoppingCard {
         List<Products> products;
         List<Order> orders;

         shoppingCard() {
            products = new ArrayList<>();
            orders = new ArrayList<>();

         }

         void displayCartContents() {
            System.out.println("Shopping Carts  : ");
            System.out.println("Products : ");
            for (Products product : products) {
               product.displayProductsInfo();
            }
            System.out.println("Orders : ");
            for (Order order : orders) {
               order.displayOrderInfo();

            }

         }


         public void totalProductPrice(Order order)throws ProductNotFoundException {
            if(order == null){
               throw new ProductNotFoundException("Product not found.Orders not null.");
            }

           orders.add((Order));
            double totalPrice =0;
           List<Products> producttt = order.getProducts();

           if(producttt!= null && !producttt.isEmpty()){
              for(Products product:producttt){
                 if(products!=null){
                    totalPrice+=product.getProductPrice();
                 }else{
                    throw new ProductNotFoundException("Product is null");
                 }
              }
              totalProductPrice(products);

           }
           try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
              writer.write(" Total Price : "+totalPrice);
              writer.newLine();
              System.out.println("Total Product Prices Added");
           }catch (IOException e){
              throw new RuntimeException(e);
           }


         }

         private void totalProductPrice(List<Products> products) {
         }

      }


      public static class Customers {
         private String customerName;
         private int customerId;
         shoppingCard card;


         Customers(String customerName, int customerId) {
            this.customerName = customerName;
            this.customerId = customerId;
            this.card = new shoppingCard();
         }

         void displayCustomersInfo() {
            System.out.println("Customer Name : " + customerName);
            System.out.println("Customer Id : " + customerId);
            card.displayCartContents();
         }

      }

      public static class Order {
         private String orderName;
         private int orderId;

         Order(String orderName, int orderId) {
            this.orderName = orderName;
            this.orderId = orderId;
         }
         @Override
         public String toString(){
            return "Order{" +
                    "orderName='" + orderName + '\'' +
                    ", orderId=" + orderId +

                    '}';
         }
         void displayOrderInfo() {
            System.out.println("Order name : " + orderName);
            System.out.println("Order IP : " + orderId);
            System.out.println("Products in Order : ");
            for (Products product : products) {
               product.displayProductsInfo();
            }
         }
         public void addOrder(Order orders) throws ProductNotFoundException{
            orders.add(orders);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
               writer.write(String.valueOf(orders));
               writer.newLine();
               System.out.println("Order added");

            }catch (IOException e){
               throw new RuntimeException(e);
            }
            Products.Order order1 = new Order("TV",1);
            System.out.println("Order added successfully");
         }

         private void add(Products.Order orders) {
         }

         public void addProduct(Products product) throws ProductNotFoundException {
            products.add(product);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
               writer.write(String.valueOf(product));
               writer.newLine();
               System.out.println("Product added ");

            } catch (IOException e) {
               throw new RuntimeException(e);
            }
            Products productt = new Products("Laptop", 230, 450000);

            System.out.println("Product added successfully");
         }

         public List<Products> getProducts() {
            return products;
         }
      }

   }


   public static void main(String[] args) throws ProductNotFoundException {


      Products product = new Products("TV", 100, 80000);
      Products product1 = new Products("SmartPhone", 101, 90000);
      Products product2 = new Products("Laptop", 102, 450000);

      Products.Customer  = new Products.Customers("Maria", 12);
      Products.Order orderr  = new Products.Order("TV", 1);
      Products.Order order1 = new Products.Order("SmartPhone",2);




      orderr.addProduct(product);
      orderr.addProduct(product1);
      orderr.addProduct(product2);
      orderr.displayOrderInfo();


      orderr.addOrder(orderr);
      order1.addOrder(order1);
      orderr.displayOrderInfo();


      System.out.println("PRODUCT INFO : ");
      product.displayProductsInfo();
      product1.displayProductsInfo();
      product2.displayProductsInfo();



      System.out.println("CUSTOMER INFO : ");
      Products.Customer.displayCustomersInfo();


      System.out.println("SHOPPING CARD : ");

         Products.shoppingCard shoppingCart = new Products.shoppingCard();



         shoppingCart.products.add(product);
         shoppingCart.products.add(product1);
         shoppingCart.products.add(product2);
         shoppingCart.orders.add(orderr);
         shoppingCart.orders.add(order1);



         shoppingCart.displayCartContents();

         shoppingCart.totalProductPrice(orderr);

   }



   }


