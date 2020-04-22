package com.sample.company.employeeservices.config;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Class SSLConfiguration. Configures the SSL settings to connect to IBM MQ.
 * This class prevent creating a bunch of environment variables. If not for this
 * class we would be passing everything from cmd line to the app
 */
@Configuration("SSLConfiguration")
@ConfigurationProperties("wmq.ssl")
public class SSLConfiguration {

    /** The key store. */
    private String keyStore;

    /** The key store password. */
    private String keyStorePswd;

    /** The trust store. */
    private String trustStore;

    /** The trust store password. */
    private String trustStorePswd;

    /**
     * dont use Use MQCSPauthentication. We are using certificates to
     * authenticate. set this to true if we use use user name and password for
     * authentication
     */
    private String useMQCSPauthentication;

    /**
     * Use IBM cipher mappings. We dont want MQ to convert the cipher suite into
     * IBM naming
     */
    private String useIBMCipherMappings;

    /**
     * Configure SSL.
     */
    @PostConstruct
    public void configureSSL() {
        System.setProperty("javax.net.ssl.keyStore", keyStore);
        System.setProperty("javax.net.ssl.keyStorePassword", keyStorePswd);
        System.setProperty("javax.net.ssl.trustStore", trustStore);
        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePswd);
        System.setProperty("com.ibm.mq.cfg.jmqi.useMQCSPauthentication",
                useMQCSPauthentication);
        System.setProperty("com.ibm.mq.cfg.useIBMCipherMappings",
                useIBMCipherMappings);
        
        keyStorePswd = StringUtils.EMPTY;
        trustStorePswd = StringUtils.EMPTY;        
    }

    public final String getKeyStore() {
        return keyStore;
    }

    public final void setKeyStore(String keyStore) {
        this.keyStore = keyStore;
    }

    public final String getKeyStorePassword() {
        return keyStorePswd;
    }

    public final void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePswd = keyStorePassword;
    }

    public final String getTrustStore() {
        return trustStore;
    }

    public final void setTrustStore(String trustStore) {
        this.trustStore = trustStore;
    }

    public final String getTrustStorePassword() {
        return trustStorePswd;
    }

    public final void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePswd = trustStorePassword;
    }

    public final String getUseMQCSPauthentication() {
        return useMQCSPauthentication;
    }

    public final void setUseMQCSPauthentication(String useMQCSPauthentication) {
        this.useMQCSPauthentication = useMQCSPauthentication;
    }

    public final String getUseIBMCipherMappings() {
        return useIBMCipherMappings;
    }

    public final void setUseIBMCipherMappings(String useIBMCipherMappings) {
        this.useIBMCipherMappings = useIBMCipherMappings;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SSLConfiguration [keyStore=" + keyStore + ", trustStore="
                + trustStore + "]";
    }

}
