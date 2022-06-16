import lk.ijse.supermarket.embeded.Name;
import lk.ijse.supermarket.entity.Customer;
import lk.ijse.supermarket.entity.Item;
import lk.ijse.supermarket.entity.Order;
import lk.ijse.supermarket.entity.OrderDetail;
import lk.ijse.supermarket.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class AppInitializer {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        // add customer
        Name name1 = new Name();
        name1.setfName("Sumudu");
        name1.setsName("Lakmal");
        name1.setlName("Jayawardhana");

        Customer c1 = new Customer();
        c1.setId("C001");
        c1.setName(name1);
        c1.setSalary(56000);
        c1.setAddress("Kadawatha");

        Name name2 = new Name();
        name2.setfName("Hansika");
        name2.setsName("Madushani");
        name2.setlName("Perera");

        Customer c2 = new Customer();
        c2.setId("C002");
        c2.setName(name2);
        c2.setSalary(26000);
        c2.setAddress("Panadura");

        session.save(c1);
        session.save(c2);


        // add item
        Item item1 = new Item();
        item1.setCode("I001");
        item1.setDescription("Biscuit");
        item1.setPrice(100);
        item1.setQty(5);

        Item item2 = new Item();
        item2.setCode("I002");
        item2.setDescription("Cake");
        item2.setPrice(500);
        item2.setQty(10);

        session.save(item1);
        session.save(item2);

        // add order

        Name name3 = new Name();
        name3.setfName("Kamala");
        name3.setsName("Yasawathi");
        name3.setlName("Perera");

        Customer c3 = new Customer();
        c3.setId("C003");
        c3.setName(name3);
        c3.setSalary(6000);
        c3.setAddress("Gall");

        Order o1 = new Order();
        o1.setoId("O001");
        o1.setDate(LocalDate.now());
        o1.setCustomer(c3);

        Order o2 = new Order();
        o2.setoId("O002");
        o2.setDate(LocalDate.now());
        o2.setCustomer(c3);

        session.save(c3);
        session.save(o1);
        session.save(o2);

        // add orderDetail

        Item item3 = new Item();
        item3.setCode("I003");
        item3.setDescription("IceCream");
        item3.setPrice(100);
        item3.setQty(15);

        Item item4 = new Item();
        item4.setCode("I004");
        item4.setDescription("Soap");
        item4.setPrice(500);
        item4.setQty(12);

        Name name4 = new Name();
        name4.setfName("Sisira");
        name4.setsName("Senasiri");
        name4.setlName("Perera");

        Customer c4 = new Customer();
        c4.setId("C004");
        c4.setName(name4);
        c4.setSalary(6000);
        c4.setAddress("Gall");

        Order o3 = new Order();
        o3.setoId("O003");
        o3.setDate(LocalDate.now());
        o3.setCustomer(c4);

        OrderDetail od1 = new OrderDetail();
        od1.setId("OD001");
        od1.setItem(item1);
        od1.setOrder(o1);
        od1.setQty(2);

        OrderDetail od2 = new OrderDetail();
        od2.setId("OD002");
        od2.setItem(item2);
        od2.setOrder(o2);
        od2.setQty(5);

        session.save(item3);
        session.save(item4);
        session.save(c4);
        session.save(o3);
        session.save(od1);
        session.save(od2);


        transaction.commit();

        session.close();

    }
}
