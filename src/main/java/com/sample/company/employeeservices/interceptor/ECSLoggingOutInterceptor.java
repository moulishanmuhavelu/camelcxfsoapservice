package com.sample.company.employeeservices.interceptor;

import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.ext.logging.slf4j.Slf4jVerboseEventSender;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * The Class ECSLoggingOutInterceptor.
 */
/**
 * @author Infosys Ltd
 * 
 */
@Service("ecsLoggingOutInterceptor")
public class ECSLoggingOutInterceptor extends LoggingOutInterceptor {

    /** The xml logging enabled. */
    @Value("${cxf.logging.enabled}")
    private boolean xmlLoggingEnabled;

    /**
     * Constructor ECSLoggingInInterceptor.
     */
    public ECSLoggingOutInterceptor() {
        super(new Slf4jVerboseEventSender());
    }

    /**
     * Handles writing the message to log file. Response content will be logged
     * only if its enabled
     * 
     * @param message
     *            message object
     *  @throws Fault message
     */
    @Override
    public void handleMessage(Message message) throws Fault {
        if (xmlLoggingEnabled) {
            super.handleMessage(message);
        }
    }
}