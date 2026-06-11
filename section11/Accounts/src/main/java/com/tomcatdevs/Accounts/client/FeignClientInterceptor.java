package com.tomcatdevs.Accounts.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

// FeignClientInterceptor — CorrelationContext se lo
@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private final ObjectProvider<CorrelationContext> ctxProvider;

    public FeignClientInterceptor(ObjectProvider<CorrelationContext> ctxProvider) {
        this.ctxProvider = ctxProvider;
    }

    @Override
    public void apply(RequestTemplate template) {
        CorrelationContext ctx = ctxProvider.getIfAvailable();
        if (ctx != null && ctx.getTraceId() != null) {
            template.header("eazybank-correlation-id", ctx.getCorrelationId());
            template.header("traceparent",
                    "00-" + ctx.getTraceId() + "-" + ctx.getTraceId().substring(0, 16) + "-01");
        }
    }
}