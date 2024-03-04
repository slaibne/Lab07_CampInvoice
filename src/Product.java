public class Product
{

    private String name;
    private double cost;
    private int quantity;

    public Product(String name, double cost, int quantity)
    {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getCost()
    {
        return cost;
    }
    public void setCost(double cost)
    {
        this.cost = cost;
    }
    public double getQuantity() {return quantity;}

    @Override
    public String toString()
    {
        return "Product{" +
                ", name='" + cost + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String toCSV()
    {
        return name + ", " + cost;
    }



}