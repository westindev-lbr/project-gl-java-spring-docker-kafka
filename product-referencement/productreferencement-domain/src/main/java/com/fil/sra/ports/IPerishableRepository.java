package com.fil.sra.ports;

import java.util.Date;
import java.util.List;

import com.fil.sra.models.Perishable;

public interface IPerishableRepository {
    Perishable getPerishable(Integer id);
    Perishable addPerishable(Perishable perishable);
    Perishable updatePerishable(Perishable perishable);
    void deletePerishable(Integer id);
    List<Perishable> getExpiredPerishable(Date currentDate);

    Perishable getPerishableByEan(String ean);
}
