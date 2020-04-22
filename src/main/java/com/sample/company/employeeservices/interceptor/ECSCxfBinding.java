package com.sample.company.employeeservices.interceptor;

import org.apache.camel.component.cxf.DefaultCxfBinding;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.security.SecurityContext;
import org.springframework.stereotype.Service;


/**
 * The Class ECSCxfBinding.
 */
/**
 * @author C50739 Need this for One Way HTTP Services when deploying on
 *         websphere
 */
@Service("ecsCXFBinding")
public class ECSCxfBinding extends DefaultCxfBinding {

    /**
     * Populate exchange from cxf request.
     *
     * @param cxfExchange the cxf exchange
     * @param camelExchange the camel exchange
     */
    @Override
    public void populateExchangeFromCxfRequest(Exchange cxfExchange,
            org.apache.camel.Exchange camelExchange) {
        Message cxfMessage = cxfExchange.getInMessage();
        cxfMessage.put(SecurityContext.class, null);
        super.populateExchangeFromCxfRequest(cxfExchange, camelExchange);
    }

}
