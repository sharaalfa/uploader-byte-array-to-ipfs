package io.ipfs.upload

import io.ipfs.upload.Syntax.Arr.ArrOps


class SenderImpl extends Sender {
  override def send(arr: Array[Byte]): CID = {
    val cid = new CID()
    cid.setCid(arr.push())
    cid
  }
}