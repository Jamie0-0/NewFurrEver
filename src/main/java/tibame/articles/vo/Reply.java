package tibame.articles.vo;

import java.sql.Timestamp;
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
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "com_reply")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply extends Core {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer replyId;
	@Column(updatable = false)
	private Integer replyComId;
	@Column(updatable = false)
	private Integer replyUserId;

	private String replyContent;
	@Column(insertable = false, updatable = false)
	private Timestamp replyDateTime;
	@Column(insertable = false)
	private Integer replyRepCount;
	@Column(insertable = false)
	private String replyStatus;
	@Transient // 告訴 Hibernate 不需要映射到數據庫
	private String uName;

	@ManyToOne
	@JoinColumn(name = "replyUserId", insertable = false, updatable = false)
	private ArtUser artUser; // 對應到 User 實體

//    @ManyToOne
//    @JoinColumn(name = "replyComId", insertable = false, updatable = false)
//    @JsonBackReference  // comment那邊應該要是 @JsonManagedReference不然會無法解析json
//    private Comment comment; // 對應到 Comment 實體

	@OneToMany(mappedBy = "reply")
	private List<ReplyReport> replyReport;

}
