package com.example.supplychain.model;
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToMany
    private List<Product> products;

    // Lombok ile getter ve setterlar otomatik olarak oluşturulur
    @Data
    public class Order {
        private Long id;
        private LocalDate orderDate;
        private OrderStatus status;
        private List<Product> products;
    }
}
