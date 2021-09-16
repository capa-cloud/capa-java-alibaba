package group.rxcloud.capa.spi.alibaba.config;

import group.rxcloud.capa.infrastructure.env.CapaEnvironment;
import group.rxcloud.capa.spi.config.RpcServiceOptions;

import java.util.Objects;

/**
 * RPC service options. Define for AppId.
 */
public class AliRpcServiceOptions implements RpcServiceOptions {

    /**
     * Unique rpc service ID
     */
    private final String appId;
    private final ServiceRpcInvokeMode rpcInvokeMode;

    /*
     * Optional options
     */
    private AliToAliServiceOptions aliToAliServiceOptions;

    /**
     * Instantiates a new Capa rpc service options.
     *
     * @param appId         the app id
     * @param rpcInvokeMode the rpc invoke mode
     */
    public AliRpcServiceOptions(String appId, ServiceRpcInvokeMode rpcInvokeMode) {
        this.appId = appId;
        this.rpcInvokeMode = rpcInvokeMode;
    }

    /**
     * RPC service invoke mode
     */
    public enum ServiceRpcInvokeMode {
        /**
         * AWS → AWS
         */
        AWS_TO_AWS,
        ;
    }

    // -- Properties Defined

    /**
     * Properties required when calling the Ali service
     */
    public interface ToAliServiceOptions {

        /**
         * SOA ServiceCode
         *
         * @return the service code
         */
        String getServiceCode();

        /**
         * SOA ServiceName
         *
         * @return the service name
         */
        String getServiceName();
    }

    /**
     * Properties available when deployed on Ali
     */
    public interface AliServiceOptions {

        /**
         * Ali deployment environment
         *
         * @return the service env
         */
        CapaEnvironment.DeployVpcEnvironment getServiceEnv();
    }

    // Specific Properties Impl

    /**
     * The service deployed on Ali calls the service of Ali
     */
    public static class AliToAliServiceOptions implements AliServiceOptions, ToAliServiceOptions {

        private final String serviceCode;
        private final String serviceName;
        private final CapaEnvironment.DeployVpcEnvironment serviceEnv;

        /**
         * Instantiates a new Ali to ali service options.
         *
         * @param serviceCode the service code
         * @param serviceName the service name
         * @param serviceEnv  the service env
         */
        public AliToAliServiceOptions(String serviceCode, String serviceName, CapaEnvironment.DeployVpcEnvironment serviceEnv) {
            this.serviceCode = serviceCode;
            this.serviceName = serviceName;
            this.serviceEnv = serviceEnv;
        }

        @Override
        public String getServiceCode() {
            return serviceCode;
        }

        @Override
        public String getServiceName() {
            return serviceName;
        }

        @Override
        public CapaEnvironment.DeployVpcEnvironment getServiceEnv() {
            return serviceEnv;
        }
    }

    // -- Getter and Setter

    /**
     * Gets app id.
     *
     * @return the app id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Gets rpc invoke mode.
     *
     * @return the rpc invoke mode
     */
    public ServiceRpcInvokeMode getRpcInvokeMode() {
        return rpcInvokeMode;
    }

    /**
     * Gets ali to ali service options.
     *
     * @return the ali to ali service options
     */
    public AliToAliServiceOptions getAliToAliServiceOptions() {
        return aliToAliServiceOptions;
    }

    /**
     * Sets ali to ali service options.
     *
     * @param aliToAliServiceOptions the ali to ali service options
     */
    public void setAliToAliServiceOptions(AliToAliServiceOptions aliToAliServiceOptions) {
        this.aliToAliServiceOptions = aliToAliServiceOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AliRpcServiceOptions)) {
            return false;
        }
        AliRpcServiceOptions that = (AliRpcServiceOptions) o;
        return Objects.equals(appId, that.appId) && rpcInvokeMode == that.rpcInvokeMode && Objects.equals(aliToAliServiceOptions, that.aliToAliServiceOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, rpcInvokeMode, aliToAliServiceOptions);
    }

    @Override
    public String toString() {
        return "AliRpcServiceOptions{" +
                "appId='" + appId + '\'' +
                ", rpcInvokeMode=" + rpcInvokeMode +
                ", aliToAliServiceOptions=" + aliToAliServiceOptions +
                '}';
    }
}