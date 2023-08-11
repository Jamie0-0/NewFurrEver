package tibame.myOrders.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sub_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "so_order_id")
	private Integer soOrderId;

	@Column(name = "so_order_num")
	private Integer soOrderNum;

	@Column(name = "so_m_id")
	private Integer soMId;

	@Column(name = "order_num")
	private Integer orderNum;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "so_1")
	private String so1;

	@Column(name = "so_2")
	private String so2;

	@Column(name = "so_3")
	private String so3;
	
//	@ManyToOne
//    @JoinColumn(name = "so_order_num", insertable= false, updatable= false)
//    private ProductOrder productOrder;
	
	@OneToMany
	@JoinColumn(name = "order_id", referencedColumnName = "so_order_num")
    private List<SubProduct> subProducts;
}
