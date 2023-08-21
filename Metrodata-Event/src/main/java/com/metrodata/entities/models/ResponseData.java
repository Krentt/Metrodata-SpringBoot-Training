package com.metrodata.entities.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyKeyJavaClass;

@Data
@AllArgsConstructor
public class ResponseData<T> {
    private T data;
    private String message;
}
