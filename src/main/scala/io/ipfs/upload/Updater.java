package io.ipfs.upload;

public interface Updater {
    void put(byte[] arr, CID cid);
}
