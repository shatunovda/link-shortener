// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: shortener.proto

package org.example.tinurl.backend;

/**
 * Protobuf type {@code org.example.tinurl.backend.GetMiniResponse}
 */
public  final class GetMiniResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.example.tinurl.backend.GetMiniResponse)
    GetMiniResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetMiniResponse.newBuilder() to construct.
  private GetMiniResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetMiniResponse() {
    minifiedUrl_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetMiniResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            minifiedUrl_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.example.tinurl.backend.Shortener.internal_static_org_example_tinurl_backend_GetMiniResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.example.tinurl.backend.Shortener.internal_static_org_example_tinurl_backend_GetMiniResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.example.tinurl.backend.GetMiniResponse.class, org.example.tinurl.backend.GetMiniResponse.Builder.class);
  }

  public static final int MINIFIED_URL_FIELD_NUMBER = 1;
  private volatile java.lang.Object minifiedUrl_;
  /**
   * <code>string minified_url = 1;</code>
   */
  public java.lang.String getMinifiedUrl() {
    java.lang.Object ref = minifiedUrl_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      minifiedUrl_ = s;
      return s;
    }
  }
  /**
   * <code>string minified_url = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMinifiedUrlBytes() {
    java.lang.Object ref = minifiedUrl_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      minifiedUrl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getMinifiedUrlBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, minifiedUrl_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getMinifiedUrlBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, minifiedUrl_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.example.tinurl.backend.GetMiniResponse)) {
      return super.equals(obj);
    }
    org.example.tinurl.backend.GetMiniResponse other = (org.example.tinurl.backend.GetMiniResponse) obj;

    boolean result = true;
    result = result && getMinifiedUrl()
        .equals(other.getMinifiedUrl());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MINIFIED_URL_FIELD_NUMBER;
    hash = (53 * hash) + getMinifiedUrl().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.tinurl.backend.GetMiniResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.example.tinurl.backend.GetMiniResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code org.example.tinurl.backend.GetMiniResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.example.tinurl.backend.GetMiniResponse)
      org.example.tinurl.backend.GetMiniResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.example.tinurl.backend.Shortener.internal_static_org_example_tinurl_backend_GetMiniResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.example.tinurl.backend.Shortener.internal_static_org_example_tinurl_backend_GetMiniResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.example.tinurl.backend.GetMiniResponse.class, org.example.tinurl.backend.GetMiniResponse.Builder.class);
    }

    // Construct using org.example.tinurl.backend.GetMiniResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      minifiedUrl_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.example.tinurl.backend.Shortener.internal_static_org_example_tinurl_backend_GetMiniResponse_descriptor;
    }

    public org.example.tinurl.backend.GetMiniResponse getDefaultInstanceForType() {
      return org.example.tinurl.backend.GetMiniResponse.getDefaultInstance();
    }

    public org.example.tinurl.backend.GetMiniResponse build() {
      org.example.tinurl.backend.GetMiniResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.example.tinurl.backend.GetMiniResponse buildPartial() {
      org.example.tinurl.backend.GetMiniResponse result = new org.example.tinurl.backend.GetMiniResponse(this);
      result.minifiedUrl_ = minifiedUrl_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.example.tinurl.backend.GetMiniResponse) {
        return mergeFrom((org.example.tinurl.backend.GetMiniResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.example.tinurl.backend.GetMiniResponse other) {
      if (other == org.example.tinurl.backend.GetMiniResponse.getDefaultInstance()) return this;
      if (!other.getMinifiedUrl().isEmpty()) {
        minifiedUrl_ = other.minifiedUrl_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.example.tinurl.backend.GetMiniResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.example.tinurl.backend.GetMiniResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object minifiedUrl_ = "";
    /**
     * <code>string minified_url = 1;</code>
     */
    public java.lang.String getMinifiedUrl() {
      java.lang.Object ref = minifiedUrl_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        minifiedUrl_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string minified_url = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMinifiedUrlBytes() {
      java.lang.Object ref = minifiedUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        minifiedUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string minified_url = 1;</code>
     */
    public Builder setMinifiedUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      minifiedUrl_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string minified_url = 1;</code>
     */
    public Builder clearMinifiedUrl() {
      
      minifiedUrl_ = getDefaultInstance().getMinifiedUrl();
      onChanged();
      return this;
    }
    /**
     * <code>string minified_url = 1;</code>
     */
    public Builder setMinifiedUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      minifiedUrl_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:org.example.tinurl.backend.GetMiniResponse)
  }

  // @@protoc_insertion_point(class_scope:org.example.tinurl.backend.GetMiniResponse)
  private static final org.example.tinurl.backend.GetMiniResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.example.tinurl.backend.GetMiniResponse();
  }

  public static org.example.tinurl.backend.GetMiniResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetMiniResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetMiniResponse>() {
    public GetMiniResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetMiniResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetMiniResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetMiniResponse> getParserForType() {
    return PARSER;
  }

  public org.example.tinurl.backend.GetMiniResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
