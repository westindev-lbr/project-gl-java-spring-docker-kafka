package com.fil.sra.command;

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

    public double valueOrPercentReduction;
}
