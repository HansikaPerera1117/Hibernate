package lk.ijse.supermarket.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDetail {
    @Id
    private String Id;

    @ManyToOne
    private  Item item;

    @ManyToOne
    private Order order;

    private int qty;

    public OrderDetail() {
    }

    public OrderDetail(String id, Order order, Item item, int qty) {
        Id = id;
        this.order = order;
        this.item = item;
        this.qty = qty;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "Id='" + Id + '\'' +
                ", order=" + order +
                ", item=" + item +
                ", qty=" + qty +
                '}';
    }
}
