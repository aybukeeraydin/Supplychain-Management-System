package com.example.supplychain.model;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int quantity;

    // Lombok ile getter ve setterlar otomatik olarak oluşturulur
    @Data
    public class Product {
        private Long id;
        private String name;
        private String description;
        private int quantity;
    }
}
