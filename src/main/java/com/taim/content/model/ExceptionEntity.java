package com.taim.content.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExceptionEntity {
    private String error;
    private String description;
    private Integer httpCode;
    private Date timeStamp;
}
