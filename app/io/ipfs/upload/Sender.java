package io.ipfs.upload;

public interface Sender {
    CID send(byte [] arr);
}
