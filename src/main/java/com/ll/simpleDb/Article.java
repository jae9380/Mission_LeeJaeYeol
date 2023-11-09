package com.ll.simpleDb;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class Article {
    private long id;
    private LocalDateTime createDate,modifiedDate;
    private String title,body;
    private boolean isBlind;
}
