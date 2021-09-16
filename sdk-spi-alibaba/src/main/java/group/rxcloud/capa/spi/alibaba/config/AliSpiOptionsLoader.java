package group.rxcloud.capa.spi.alibaba.config;

import group.rxcloud.capa.infrastructure.env.CapaEnvironment;
import group.rxcloud.capa.spi.config.CapaSpiOptionsLoader;

import java.util.Objects;

public class AliSpiOptionsLoader implements CapaSpiOptionsLoader<AliRpcServiceOptions> {

    @Override
    public AliRpcServiceOptions loadRpcServiceOptions(String appId) {
        Objects.requireNonNull(appId, "appId");
        AliRpcServiceOptions rpcServiceOptions = new AliRpcServiceOptions(appId, AliRpcServiceOptions.ServiceRpcInvokeMode.AWS_TO_AWS);
        CapaEnvironment.DeployVpcEnvironment deployVpcEnvironment = CapaEnvironment.getDeployVpcEnvironment();
        AliRpcServiceOptions.AliToAliServiceOptions awsToAliServiceOptions =
                new AliRpcServiceOptions.AliToAliServiceOptions("", "", deployVpcEnvironment);
        rpcServiceOptions.setAliToAliServiceOptions(awsToAliServiceOptions);
        return rpcServiceOptions;
    }
}
