package com.debuger.search.aggregations.metrics.multi;

import org.elasticsearch.common.util.DoubleArray;
import org.elasticsearch.index.fielddata.SortedNumericDoubleValues;
import org.elasticsearch.index.fielddata.plain.SortedNumericIndexFieldData;
import org.elasticsearch.index.mapper.MappedFieldType;
import org.elasticsearch.search.DocValueFormat;
import org.elasticsearch.search.aggregations.AggregationExecutionContext;
import org.elasticsearch.search.aggregations.Aggregator;
import org.elasticsearch.search.aggregations.InternalAggregation;
import org.elasticsearch.search.aggregations.LeafBucketCollector;
import org.elasticsearch.search.aggregations.metrics.NumericMetricsAggregator;
import org.elasticsearch.search.aggregations.support.AggregationContext;
import org.elasticsearch.search.aggregations.support.ValuesSource;
import org.elasticsearch.search.aggregations.support.ValuesSourceConfig;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

public class MultiAggregator extends NumericMetricsAggregator.SingleValue {

    final ValuesSource.Numeric valuesSource;
    final DocValueFormat formatter;

    DoubleArray maxes;

    final String multiField;
    final MappedFieldType multiFieldType;

    public MultiAggregator(String name, ValuesSourceConfig config, AggregationContext context, Aggregator parent, Map<String, Object> metadata, String multiField) throws IOException {
        super(name, context, parent, metadata);
        this.multiField = multiField;
        assert config.hasValues();
        this.valuesSource = (ValuesSource.Numeric) config.getValuesSource();
        maxes = context.bigArrays().newDoubleArray(1, false);
        maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);
        this.formatter = config.format();
        this.multiFieldType = context.getFieldType(multiField);
    }

    @Override
    public double metric(long l) {
        return 0;
    }

    @Override
    public InternalAggregation buildAggregation(long l) throws IOException {
        return null;
    }

    @Override
    protected LeafBucketCollector getLeafCollector(AggregationExecutionContext aggCtx, LeafBucketCollector leafBucketCollector) throws IOException {
        final SortedNumericDoubleValues values = valuesSource.doubleValues(aggCtx.getLeafReaderContext());

        return null;
    }

    @Override
    public InternalAggregation buildEmptyAggregation() {
        return null;
    }
}
