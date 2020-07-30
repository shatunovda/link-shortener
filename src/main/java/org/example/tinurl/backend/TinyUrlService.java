package org.example.tinurl.backend;

import io.grpc.stub.StreamObserver;
import org.example.tinurl.model.Url;
import org.example.tinurl.repository.RedisRepository;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;


import static java.util.Optional.ofNullable;

@GRpcService
public class TinyUrlService extends TinyUrlServiceGrpc.TinyUrlServiceImplBase {

    private final RedisRepository redisRepository;

    @Autowired
    public TinyUrlService(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @Override
    public void getMini(GetMiniRequest request, StreamObserver<GetMiniResponse> responseObserver) {
        String miniUrl = ofNullable(redisRepository.getShortUrlByOriginalUrl(request.getOriginalUrl()))
                .orElseGet(() -> {
                    String newMiniUrl = Base63.longToBase63(redisRepository.generateId());
                    redisRepository.add(new Url(newMiniUrl, request.getOriginalUrl()));
                    return newMiniUrl;
                });

        GetMiniResponse.Builder builder = GetMiniResponse.newBuilder().setMinifiedUrl(miniUrl);

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getMaxi(GetMaxiRequest request, StreamObserver<GetMaxiResponse> responseObserver) {
        String originalUrl = redisRepository.getOriginalUrlByShortUrl(request.getMinifiedUrl());
        GetMaxiResponse.Builder builder = GetMaxiResponse.newBuilder().setOriginalUrl(originalUrl);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }


}
