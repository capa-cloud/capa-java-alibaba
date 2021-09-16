package group.rxcloud.capa.spi.alibaba.http;


import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class AliCapaHttp extends CapaSerializeHttpSpi {

    /**
     * Instantiates a new Capa serialize http spi.
     *
     * @param httpClient       the http client
     * @param objectSerializer the object serializer
     */
    public AliCapaHttp(OkHttpClient httpClient, CapaObjectSerializer objectSerializer) {
        super(httpClient, objectSerializer);
    }

    @Override
    protected <T> CompletableFuture<HttpResponse<T>> invokeSpiApi(String appId, String method, Object requestData, Map<String, String> headers, TypeRef<T> type, RpcServiceOptions rpcServiceOptions) {
        return null;
    }
}
