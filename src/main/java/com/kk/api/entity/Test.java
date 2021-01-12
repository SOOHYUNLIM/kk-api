package com.kk.api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tbl_test")
@NoArgsConstructor
@ToString
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_no")
    public Integer no;

    @Column(name = "test_title", nullable = true)
    public String title;

    @CreationTimestamp
    public LocalDateTime registerYmdt;

    public Test(String title) {
        this.title = title;
    }
}
