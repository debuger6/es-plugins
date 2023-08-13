package com.debuger.search.aggregations.metrics.multi;

import org.elasticsearch.search.aggregations.Aggregator;
import org.elasticsearch.search.aggregations.AggregatorFactories;
import org.elasticsearch.search.aggregations.AggregatorFactory;
import org.elasticsearch.search.aggregations.CardinalityUpperBound;
import org.elasticsearch.search.aggregations.support.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MultiAggregatorFactory extends ValuesSourceAggregatorFactory {
    public MultiAggregatorFactory(String name, ValuesSourceConfig config, AggregationContext context, AggregatorFactory parent, AggregatorFactories.Builder subFactoriesBuilder, Map<String, Object> metadata) throws IOException {
        super(name, config, context, parent, subFactoriesBuilder, metadata);
    }

    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        builder.register(
                MultiAggregationBuilder.REGISTRY_KEY,
                List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
                (name1, config1, context1, parent1, metadata1) -> new MultiAggregator(name1, config1, context1, parent1, metadata1, multiField),
                true
        );
    }

    @Override
    protected Aggregator createUnmapped(Aggregator aggregator, Map<String, Object> map) throws IOException {
        return null;
    }

    @Override
    protected Aggregator doCreateInternal(Aggregator aggregator, CardinalityUpperBound cardinalityUpperBound, Map<String, Object> map) throws IOException {
        return null;
    }
}
