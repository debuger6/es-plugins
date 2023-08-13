package com.debuger.search.aggregations.metrics.multi;

import org.elasticsearch.search.aggregations.metrics.NumericMetricsAggregation;

/**
 * An aggregation that computes the multi of the values in the current bucket.
 */
public interface Multi extends NumericMetricsAggregation.SingleValue {

    /**
     * The multi value.
     */
    double getValue();
}
