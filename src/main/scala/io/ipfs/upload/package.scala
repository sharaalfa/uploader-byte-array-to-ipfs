package io.ipfs

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import scalaj.http.{Http, HttpOptions}
import io.ipfs.api.IPFS
import scala.language.postfixOps

import io.ipfs.multihash.Multihash

import java.io.File
import java.nio.file.{Files, Paths}
import java.io.IOException
import java.util.Optional
package object upload {

//  val byteArray: Array[Byte] = Files.readAllBytes(Paths.get("/home/shar/Загрузки/template.xml"))
  sealed trait Arr[A] {
  def op(byteArray: Array[Byte]): A
  def op(byteArray: Array[Byte], cid: String): Unit

  }

  object Arr {
    implicit final val arr: Arr[String] = new Arr[String] {
      override def op(byteArray: Array[Byte]): String = {
        implicit val formats: DefaultFormats.type  = DefaultFormats
//        val byteArray: Array[Byte] = Files.readAllBytes(Paths.get("/home/shar/Загрузки/template.xml"))
//        val bytes = JsonMethods.parse(byteArray.mkString("Array(", ", ", ")")).extract[Array[Byte]]
        val result = Http("https://api.web3.storage/upload").postData(byteArray)
          .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJkaWQ6ZXRocjoweDhjODYwODI0ZTAwMkI0RTlkNGM1NzU1MUFjZDgwQ2NlRDVFZEVlQjciLCJpc3MiOiJ3ZWIzLXN0b3JhZ2UiLCJpYXQiOjE2NDQwNjY1Mzk5MDAsIm5hbWUiOiJhcnR1ciJ9.2qdiBjqeQoJzmtuwBjW8Nfs5mOCBb0sxWyza9rynU0g")
          .option(HttpOptions.readTimeout(10000)).asString
        (JsonMethods.parse(result.body) \ "cid").extract[String]
      }

      override def op(byteArray: Array[Byte], cid: String): Unit =  {
        val ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001")
        ipfs.name.publish(Multihash.fromBase58(cid), Optional.of(byteArray.toString))


      }
    }
  }

  object Syntax{
    object Arr{
      implicit class ArrOps[A](private val byteArray: Array[Byte]){
        def push()(implicit M: Arr[String]): String = M.op(byteArray)
        def change(cid: String)(implicit M: Arr[String]): Unit = M.op(byteArray, cid)
      }
    }
  }
}
