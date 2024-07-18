package bit.data.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "reactboard")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BoardDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardnum;

    @Column(length = 30)
    private String writer;

    @Column(length = 20, updatable = false)
    private String pass;

    @Column(length = 1000)
    private String subject;

    @Column(length = 2000)
    private String content;

    @Column(updatable = false)
    private int readcount = 0;

    @Column(length = 100)
    private String photo;

    @Column(updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeday;

    @Transient //컬럼 생성 안함!
    private int answercount;

}
