package org.example.tinurl.backend;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: shortener.proto")
public final class TinyUrlServiceGrpc {

  private TinyUrlServiceGrpc() {}

  public static final String SERVICE_NAME = "org.example.tinurl.backend.TinyUrlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.tinurl.backend.GetMiniRequest,
      org.example.tinurl.backend.GetMiniResponse> getGetMiniMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMini",
      requestType = org.example.tinurl.backend.GetMiniRequest.class,
      responseType = org.example.tinurl.backend.GetMiniResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.tinurl.backend.GetMiniRequest,
      org.example.tinurl.backend.GetMiniResponse> getGetMiniMethod() {
    io.grpc.MethodDescriptor<org.example.tinurl.backend.GetMiniRequest, org.example.tinurl.backend.GetMiniResponse> getGetMiniMethod;
    if ((getGetMiniMethod = TinyUrlServiceGrpc.getGetMiniMethod) == null) {
      synchronized (TinyUrlServiceGrpc.class) {
        if ((getGetMiniMethod = TinyUrlServiceGrpc.getGetMiniMethod) == null) {
          TinyUrlServiceGrpc.getGetMiniMethod = getGetMiniMethod =
              io.grpc.MethodDescriptor.<org.example.tinurl.backend.GetMiniRequest, org.example.tinurl.backend.GetMiniResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMini"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.tinurl.backend.GetMiniRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.tinurl.backend.GetMiniResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TinyUrlServiceMethodDescriptorSupplier("GetMini"))
              .build();
        }
      }
    }
    return getGetMiniMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.tinurl.backend.GetMaxiRequest,
      org.example.tinurl.backend.GetMaxiResponse> getGetMaxiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMaxi",
      requestType = org.example.tinurl.backend.GetMaxiRequest.class,
      responseType = org.example.tinurl.backend.GetMaxiResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.tinurl.backend.GetMaxiRequest,
      org.example.tinurl.backend.GetMaxiResponse> getGetMaxiMethod() {
    io.grpc.MethodDescriptor<org.example.tinurl.backend.GetMaxiRequest, org.example.tinurl.backend.GetMaxiResponse> getGetMaxiMethod;
    if ((getGetMaxiMethod = TinyUrlServiceGrpc.getGetMaxiMethod) == null) {
      synchronized (TinyUrlServiceGrpc.class) {
        if ((getGetMaxiMethod = TinyUrlServiceGrpc.getGetMaxiMethod) == null) {
          TinyUrlServiceGrpc.getGetMaxiMethod = getGetMaxiMethod =
              io.grpc.MethodDescriptor.<org.example.tinurl.backend.GetMaxiRequest, org.example.tinurl.backend.GetMaxiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMaxi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.tinurl.backend.GetMaxiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.tinurl.backend.GetMaxiResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TinyUrlServiceMethodDescriptorSupplier("GetMaxi"))
              .build();
        }
      }
    }
    return getGetMaxiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TinyUrlServiceStub newStub(io.grpc.Channel channel) {
    return new TinyUrlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TinyUrlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TinyUrlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TinyUrlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TinyUrlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TinyUrlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMini(org.example.tinurl.backend.GetMiniRequest request,
        io.grpc.stub.StreamObserver<org.example.tinurl.backend.GetMiniResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMiniMethod(), responseObserver);
    }

    /**
     */
    public void getMaxi(org.example.tinurl.backend.GetMaxiRequest request,
        io.grpc.stub.StreamObserver<org.example.tinurl.backend.GetMaxiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMaxiMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMiniMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.tinurl.backend.GetMiniRequest,
                org.example.tinurl.backend.GetMiniResponse>(
                  this, METHODID_GET_MINI)))
          .addMethod(
            getGetMaxiMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.tinurl.backend.GetMaxiRequest,
                org.example.tinurl.backend.GetMaxiResponse>(
                  this, METHODID_GET_MAXI)))
          .build();
    }
  }

  /**
   */
  public static final class TinyUrlServiceStub extends io.grpc.stub.AbstractStub<TinyUrlServiceStub> {
    private TinyUrlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TinyUrlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TinyUrlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TinyUrlServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMini(org.example.tinurl.backend.GetMiniRequest request,
        io.grpc.stub.StreamObserver<org.example.tinurl.backend.GetMiniResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMiniMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMaxi(org.example.tinurl.backend.GetMaxiRequest request,
        io.grpc.stub.StreamObserver<org.example.tinurl.backend.GetMaxiResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMaxiMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TinyUrlServiceBlockingStub extends io.grpc.stub.AbstractStub<TinyUrlServiceBlockingStub> {
    private TinyUrlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TinyUrlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TinyUrlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TinyUrlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.tinurl.backend.GetMiniResponse getMini(org.example.tinurl.backend.GetMiniRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMiniMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.tinurl.backend.GetMaxiResponse getMaxi(org.example.tinurl.backend.GetMaxiRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMaxiMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TinyUrlServiceFutureStub extends io.grpc.stub.AbstractStub<TinyUrlServiceFutureStub> {
    private TinyUrlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TinyUrlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TinyUrlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TinyUrlServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.tinurl.backend.GetMiniResponse> getMini(
        org.example.tinurl.backend.GetMiniRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMiniMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.tinurl.backend.GetMaxiResponse> getMaxi(
        org.example.tinurl.backend.GetMaxiRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMaxiMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MINI = 0;
  private static final int METHODID_GET_MAXI = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TinyUrlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TinyUrlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MINI:
          serviceImpl.getMini((org.example.tinurl.backend.GetMiniRequest) request,
              (io.grpc.stub.StreamObserver<org.example.tinurl.backend.GetMiniResponse>) responseObserver);
          break;
        case METHODID_GET_MAXI:
          serviceImpl.getMaxi((org.example.tinurl.backend.GetMaxiRequest) request,
              (io.grpc.stub.StreamObserver<org.example.tinurl.backend.GetMaxiResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TinyUrlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TinyUrlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.tinurl.backend.Shortener.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TinyUrlService");
    }
  }

  private static final class TinyUrlServiceFileDescriptorSupplier
      extends TinyUrlServiceBaseDescriptorSupplier {
    TinyUrlServiceFileDescriptorSupplier() {}
  }

  private static final class TinyUrlServiceMethodDescriptorSupplier
      extends TinyUrlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TinyUrlServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TinyUrlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TinyUrlServiceFileDescriptorSupplier())
              .addMethod(getGetMiniMethod())
              .addMethod(getGetMaxiMethod())
              .build();
        }
      }
    }
    return result;
  }
}
