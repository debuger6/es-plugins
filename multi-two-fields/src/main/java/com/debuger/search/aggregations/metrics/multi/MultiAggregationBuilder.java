package com.debuger.search.aggregations.metrics.multi;

import org.elasticsearch.TransportVersion;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregatorFactories;
import org.elasticsearch.search.aggregations.AggregatorFactory;
import org.elasticsearch.search.aggregations.metrics.MetricAggregatorSupplier;
import org.elasticsearch.search.aggregations.support.*;
import org.elasticsearch.xcontent.ObjectParser;
import org.elasticsearch.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Map;

public class MultiAggregationBuilder extends ValuesSourceAggregationBuilder.SingleMetricAggregationBuilder<MultiAggregationBuilder> {
    public static final String NAME = "multi";
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
            NAME,
            MetricAggregatorSupplier.class
    );

    public static final ObjectParser<MultiAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, MultiAggregationBuilder::new);
    static {
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
    }

    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        MultiAggregatorFactory.registerAggregators(builder);
    }


    public MultiAggregationBuilder(String name) {
        super(name);
    }

    public MultiAggregationBuilder(LeafOnly<MultiAggregationBuilder> clone, AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        super(clone, factoriesBuilder, metadata);
    }

    public MultiAggregationBuilder(StreamInput in) throws IOException {
        super(in);
    }

    @Override
    protected void innerWriteTo(StreamOutput streamOutput) throws IOException {

    }

    @Override
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        return null;
    }

    @Override
    protected ValuesSourceType defaultValueSourceType() {
        return null;
    }

    @Override
    protected ValuesSourceAggregatorFactory innerBuild(AggregationContext aggregationContext, ValuesSourceConfig valuesSourceConfig, AggregatorFactory aggregatorFactory, AggregatorFactories.Builder builder) throws IOException {
        return null;
    }

    @Override
    protected XContentBuilder doXContentBody(XContentBuilder xContentBuilder, Params params) throws IOException {
        return null;
    }

    @Override
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder builder, Map<String, Object> map) {
        return null;
    }

    @Override
    public TransportVersion getMinimalSupportedVersion() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
