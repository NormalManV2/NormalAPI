package org.normal.api.economy;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Balance extends Serializable {

    boolean add(BigDecimal amount);
    boolean subtract(BigDecimal amount);
    void set(BigDecimal amount);
    BigDecimal getBalance();

}
