package com.devchs.chs.springdataredis.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@RedisHash(":core.redis.model.Board")
public class Board {

    @Id
    private String id;

    @Indexed
    private String symbol;

    private BigDecimal lastPrice;

    private Long updateTime;
}
