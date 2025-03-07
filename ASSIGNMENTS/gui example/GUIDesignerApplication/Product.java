public class Product {
    private String name;
    private String producerCompany;
    private Integer count;


    public Product(String n, String pC, Integer c){
        this.name = n;
        this.producerCompany = pC;
        this.count = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducerCompany() {
        return producerCompany;
    }

    public void setProducerCompany(String producerCompany) {
        this.producerCompany = producerCompany;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
