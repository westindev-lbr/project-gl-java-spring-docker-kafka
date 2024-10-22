package com.fil.sra.body;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddMarketOperationQuery {

    public List<String> eans;

    public Date startDate;

    public Date endDate;

    public double value;

    public boolean isPercent;
}
