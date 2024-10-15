package com.fil.sra.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Perishable extends Article {
    private Date bestBefore;
    private String lot;
    private List<PerishableStock> stocks;
}
