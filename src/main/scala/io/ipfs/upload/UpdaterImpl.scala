package io.ipfs.upload

import io.ipfs.upload.Syntax.Arr.ArrOps

class UpdaterImpl extends Updater{
  override def put(arr: Array[Byte], cid: CID): Unit = arr.change(cid.getCid)
}
