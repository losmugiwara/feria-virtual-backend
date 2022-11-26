package com.portafolio.feriavirtual.entities;

import com.portafolio.feriavirtual.entities.enums.ApprovalStatusEnum;
import com.portafolio.feriavirtual.security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "requests_sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<Product> products;

    @Column(name = "shipping_address")
    @NotNull
    private String shippingAddress;

    @Column(name = "created_date")
    private Date createdDate = new Date();

    // @Column(name = "approval_date")
    // @Null
    // private Date approvalDate;


    @Column(name = "approval_status")
    private ApprovalStatusEnum approvalStatus = ApprovalStatusEnum.ON_HOLD;

}
