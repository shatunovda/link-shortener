package org.example.tinurl.backend.integration;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import org.example.tinurl.ShortenerServiceApplication;
import org.example.tinurl.backend.TinyUrlServiceGrpc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.lognet.springboot.grpc.GRpcServerRunner;
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties;
import org.lognet.springboot.grpc.context.LocalRunningGrpcPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@SpringBootTest(
        classes = {ShortenerServiceApplication.class},
        properties = {
                "grpc.enableReflection=true",
                "grpc.port=0",
                "grpc.shutdownGrace=-1",
        })
@Tag("integration")
public class IntegrationTestBase {
    @Autowired(required = false)
    @Qualifier("grpcServerRunner")
    GRpcServerRunner grpcServerRunner;

    @Autowired(required = false)
    @Qualifier("grpcInprocessServerRunner")
    GRpcServerRunner grpcInprocessServerRunner;

    ManagedChannel channel;
    ManagedChannel inProcChannel;

    @LocalRunningGrpcPort
    int runningPort;

    @Autowired
    ApplicationContext context;

    @Autowired
    GRpcServerProperties gRpcServerProperties;

    TinyUrlServiceGrpc.TinyUrlServiceFutureStub tinyUrlServiceFutureStub;

    @BeforeAll
    void setupChannels() throws IOException {
        if (gRpcServerProperties.isEnabled()) {
            ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", getPort());
            Resource certChain = Optional.ofNullable(gRpcServerProperties.getSecurity())
                    .map(GRpcServerProperties.SecurityProperties::getCertChain)
                    .orElse(null);
            if (null != certChain) {
                ((NettyChannelBuilder) channelBuilder)
                        .useTransportSecurity()
                        .sslContext(GrpcSslContexts.forClient().trustManager(certChain.getInputStream()).build());
            } else {
                channelBuilder.usePlaintext();
            }

            channel = onChannelBuild(channelBuilder).build();
        }
        if (StringUtils.hasText(gRpcServerProperties.getInProcessServerName())) {
            inProcChannel = onChannelBuild(
                    InProcessChannelBuilder.forName(gRpcServerProperties.getInProcessServerName())
                            .usePlaintext()
            ).build();

        }

        tinyUrlServiceFutureStub = TinyUrlServiceGrpc.newFutureStub(Optional.ofNullable(channel).orElse(inProcChannel));
    }

    @AfterAll
    void shutdownChannels() {
        Optional.ofNullable(channel).ifPresent(ManagedChannel::shutdownNow);
        Optional.ofNullable(inProcChannel).ifPresent(ManagedChannel::shutdownNow);
    }


    ManagedChannelBuilder<?> onChannelBuild(ManagedChannelBuilder<?> channelBuilder){
        return  channelBuilder;
    }

    InProcessChannelBuilder onChannelBuild(InProcessChannelBuilder channelBuilder){
        return  channelBuilder;
    }

    int getPort(){
        return runningPort;
    }

}
