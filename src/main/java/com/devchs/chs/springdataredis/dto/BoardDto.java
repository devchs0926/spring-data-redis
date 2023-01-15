package com.devchs.chs.springdataredis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BoardDto {

    private String symbol;

    private BigDecimal lastPrice;

    private Long updateTime;
}
