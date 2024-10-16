package com.fil.sra.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Category {
    private int id;
    private String name;
    private int orderIdx;
}
