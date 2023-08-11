package tibame.myOrders.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tibame.product.vo.Product;

@Entity
@Table(name = "sub_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SubProductPK.class)
public class SubProduct {

	@Id
    @Column(name = "order_id")
    private Integer orderId;

    @Id
    @Column(name = "p_p_id")
    private Integer pPId;

    @Column(name = "p_m_stock")
    private Integer pMStock;

    @Column(name = "p_m_price")
    private Integer pMPrice;

    @Column(name = "sub1")
    private String sub1;

    @Column(name = "sub2")
    private String sub2;

    @Column(name = "sub3")
    private String sub3;
    
//    @ManyToOne
//    @JoinColumn(name = "order_id", insertable = false, updatable = false)
//    private SubOrder subOrder;

    @ManyToOne
    @JoinColumn(name = "p_p_id", insertable = false, updatable = false)
    private Product product;
}
