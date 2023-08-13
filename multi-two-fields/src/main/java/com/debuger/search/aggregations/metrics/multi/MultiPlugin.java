package com.debuger.search.aggregations.metrics.multi;

import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.SearchPlugin;
import org.elasticsearch.search.aggregations.metrics.InternalAvg;

import java.util.Collections;
import java.util.List;

public class MultiPlugin extends Plugin implements SearchPlugin {

    @Override
    public List<AggregationSpec> getAggregations() {
        AggregationSpec aggregationSpec = new AggregationSpec(MultiAggregationBuilder.NAME, MultiAggregationBuilder::new, MultiAggregationBuilder.PARSER).addResultReader(
                InternalAvg::new
        ).setAggregatorRegistrar(MultiAggregationBuilder::registerAggregators);
        return Collections.singletonList(aggregationSpec);
    }
}
