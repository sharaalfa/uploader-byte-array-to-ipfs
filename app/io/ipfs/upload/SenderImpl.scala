package io.ipfs.upload

import io.ipfs.upload.Syntax.Arr.ArrOps


class SenderImpl extends Sender {
  override def send(arr: Array[Byte]): CID = {
    val cid = new CID()
    cid.set(arr.push())
    cid
  }//CID.builder().cid(arr.push).build()
}