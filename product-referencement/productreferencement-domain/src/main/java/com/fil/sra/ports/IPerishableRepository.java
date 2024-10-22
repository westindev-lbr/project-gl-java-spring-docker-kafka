package com.fil.sra.ports;

import com.fil.sra.models.Perishable;

public interface IPerishableRepository {
    Perishable getPerishable(Integer id);
    Perishable createPerishable(Perishable perishable);
    Perishable updatePerishable(Perishable perishable);
    void deletePerishable(Integer id);
}
