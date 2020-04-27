package com.sample.company.employeeservices.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * The Class GetEmployeeDetailServiceRouteBuilder.
 */
@Service
@DependsOn("SSLConfiguration")
public class GetEmployeeDetailServiceRouteBuilder extends EmployeeServicesGenericRouteBuilder {

    @Value("${services.getemployeedetail.jms.enabled}")
    private boolean getEmployeeDetailJMSEnabled;

    @Value("${services.getemployee.http.enabled}")
    private boolean getEmployeeDetailHttpEnabled;

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.camel.builder.RouteBuilder#configure()
     */
    @Override
    public void configure() throws Exception {
        super.configure();
        configureGetEmployeeDetailPaymentRoute();
    }

    /**
     * Method to configure GetEmployeeDetail HTTP and JMS routes
     */
    private void configureGetEmployeeDetailPaymentRoute() {
        final String getEmployeeDetailProcessor = "getEmployeeDetailProcessor";

        // RouteBuilder Configurations for GetEmployeeDetailHttp
        if (getEmployeeDetailHttpEnabled) {
            from("cxf:bean:cXFGetEmployeeDetailHttp")
                    .id("httpGetEmployeeDetailRoute").to(getEmployeeDetailProcessor);
        }

        // RouteBuilder Configurations for GetEmployeeDetailJms
        if (getEmployeeDetailJMSEnabled) {
            from("cxf:bean:cXFGetEmployeeDetailWmq0").id("jmsGetEmployeeDetailRoute0")
                    .to(getEmployeeDetailProcessor);
        }
    }
}