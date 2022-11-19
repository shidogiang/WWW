package com.lv.api.storage.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = TablePrefix.PREFIX_TABLE + "customer")
public class Customer extends Auditable<String> {

    @Id
    @Column(name = "account_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @MapsId
    private Account account;

    @Column(name = "wallet_money")
    private Double walletMoney = 0d;

    private Integer gender;
    
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "rank_id")
    private Rank rank;

    @Column(name = "note", columnDefinition = "varchar(1000)")
    private String note;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CustomerAddress> customerAddresses;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = TablePrefix.PREFIX_TABLE+"customer_product",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",
                    referencedColumnName = "id"))
    private List<Product> favoriteProducts = new ArrayList<>();
}
