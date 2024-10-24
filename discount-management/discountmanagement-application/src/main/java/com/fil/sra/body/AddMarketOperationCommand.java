package com.fil.sra.body;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class AddMarketOperationCommand {

    public List<String> eans;

    public final Date startDate;

    public final Date endDate;

    public double value;

    public boolean isPercent;

    public String code;

    public double numberForLot;

    public double priceForLot;
}
