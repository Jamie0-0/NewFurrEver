package tibame.myOrders.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "order_uid")
	private Integer orderUid;

	@Column(name = "order_r_name")
	private String orderReceiverName;

	@Column(name = "order_r_phone")
	private String orderReceiverPhone;

	@Column(name = "order_r_addr")
	private String orderReceiverAddress;

	@Column(name = "order_dfee")
	private Integer orderDeliveryFee;

	@Column(name = "order_t")
	private Integer orderTotalAmount;

	@Column(name = "order_s")
	private String orderShippingStatus;

	@Column(name = "order_pay")
	private String orderPaymentStatus;

	@Column(name = "gm_id")
	private Integer gmId;

	@Column(name = "gm_date")
	private Timestamp gmDate;

	@Column(name = "order_1")
	private String order1;

	@Column(name = "order_2")
	private String order2;

	@Column(name = "order_3")
	private String order3;

	@OneToMany
	@JoinColumn(name = "so_order_num", referencedColumnName = "order_id")
    private List<SubOrder> subOrders;
}
