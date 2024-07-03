package mycar.data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity //jakarta.persistence
@Table(name = "mycar")//테이블명
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MycarDto {
    @Id //각 엔터티를 구별할 수 있도록 식별아이디 역할 : primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //시퀀스 역할
    private Long num;

    @Column(name = "carname", length = 30) //name이 변수명이랑 같을 경우 생략 가능
    private String carname;

    private int carprice;//컬럼명을 변수명이랑 같게 할 경우 생략

    @Column(length = 20)
    private String carcolor;

    @Column(length = 20)
    private String carguip;

    @Column(length = 100)
    private String carphoto;

    @CreationTimestamp//현재시간으로 세팅
    @Column(updatable = false)//수정시 컬럼을 제외하겠다 : 수정시 null값으로 바뀌는 문제 해결
    private Timestamp writeday;

    //@Transient : 테이블의 컬럼으로는 생성되지 않고 객체에서만 사용가능한 멤버 변수
    @Transient
    private int commentcount; //댓글 개수

    @Transient
    private String message;// 비고, 하고 싶은 말
}
