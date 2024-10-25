package com.fil.sra.bdd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompositeKey implements Serializable {
    public int marketOperationId;

    public int productId;
}
