package com.open.assignment.facade;

import com.open.assignment.data.AggregatedData;

public interface ProductDetailsFacade {
    AggregatedData getProductDetails(String user);
}
