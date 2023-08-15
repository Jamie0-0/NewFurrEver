package tibame.friends.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tibame.articles.vo.ArtUser;

@Entity
@Table(name = "friend")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FriendId.class)
@Builder
public class Friend {

	@Id
	private Integer fUid;
	@Id
	private Integer fId;

	private String fStatus;
	@Column(insertable = false, updatable = false)
	private Timestamp fDate;

	@ManyToOne
	@JoinColumn(name = "fId", insertable = false, updatable = false)
	private ArtUser friend;
}
