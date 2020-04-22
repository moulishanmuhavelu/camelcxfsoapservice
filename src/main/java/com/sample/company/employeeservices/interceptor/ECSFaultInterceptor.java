package com.sample.company.employeeservices.interceptor;

import org.apache.camel.Exchange;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class ECSFaultInterceptor.
 */
/**
 * @author Infosys Ltd
 * 
 */
@Service("ecsFaultInterceptor")
public class ECSFaultInterceptor extends AbstractSoapInterceptor {
    
    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /** The e CS logging in interceptor. */
    @Autowired
    private ECSLoggingInInterceptor eCSLoggingInInterceptor;

    /**
     * Constructor ECSFaultInterceptor.
     */
    public ECSFaultInterceptor() {
        super(Phase.POST_STREAM);
    }

    /**
     * Handle fault.
     *
     * @param message the message
     */
    @Override
    public void handleFault(SoapMessage message) {
        // If there is an exception in one way service, the request will never
        // be logged. So we are calling ecsLoggingInInterceptor explicitly to
        // log the request if its enabled
        eCSLoggingInInterceptor.handleMessage(message);
        Throwable exception = message.getContent(Exception.class);
        if (exception != null) {
            Exchange exchange = (Exchange) message
                    .get("org.apache.camel.exchange");
            if (exchange != null) {
                exchange.setException(exception);
            } 
        }
    }

    /**
     * Handle message.
     *
     * @param message the message
     * @throws Fault the fault
     */
    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        logger.warn("This was written only to the handle faults");
    }

}
