package com.debuger.search.aggregations.metrics.multi;

import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.search.DocValueFormat;
import org.elasticsearch.search.aggregations.AggregationReduceContext;
import org.elasticsearch.search.aggregations.InternalAggregation;
import org.elasticsearch.search.aggregations.metrics.InternalNumericMetricsAggregation;
import org.elasticsearch.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InternalMulti extends InternalNumericMetricsAggregation.SingleValue implements Multi {
    private final double multi;

    public InternalMulti(String name, DocValueFormat format, Map<String, Object> metadata, double multi) {
        super(name, format, metadata);
        this.multi = multi;
    }

    public InternalMulti(StreamInput in) throws IOException {
        super(in);
        this.multi = in.readDouble();
    }

    @Override
    public double getValue() {
        return multi;
    }

    @Override
    protected void doWriteTo(StreamOutput streamOutput) throws IOException {

    }

    @Override
    public InternalAggregation reduce(List<InternalAggregation> list, AggregationReduceContext aggregationReduceContext) {
        return null;
    }

    @Override
    public XContentBuilder doXContentBody(XContentBuilder xContentBuilder, Params params) throws IOException {
        return null;
    }

    @Override
    public String getWriteableName() {
        return null;
    }

    @Override
    public double value() {
        return 0;
    }
}
