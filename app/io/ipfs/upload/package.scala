package io.ipfs

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods
import scalaj.http.{Http, HttpOptions}

import java.io.File
import java.nio.file.{Files, Paths}

package object upload {

//  val byteArray: Array[Byte] = Files.readAllBytes(Paths.get("/home/shar/Загрузки/template.xml"))
  sealed trait Arr[A] {
  def op(byteArray: Array[Byte]): A
  def op_(byteArray: Array[Byte]): Unit

  }

  object Arr {
    implicit final val arr: Arr[String] = new Arr[String] {
      override def op(byteArray: Array[Byte]): String = {
        implicit val formats: DefaultFormats.type  = DefaultFormats
       // val byteArray: Array[Byte] = Files.readAllBytes(Paths.get(path))
       // val bytes = JsonMethods.parse(byteArray.mkString("Array(", ", ", ")")).extract[Array[Byte]]
        val result = Http("https://api.web3.storage/upload").postData(byteArray)
          .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJkaWQ6ZXRocjoweDhjODYwODI0ZTAwMkI0RTlkNGM1NzU1MUFjZDgwQ2NlRDVFZEVlQjciLCJpc3MiOiJ3ZWIzLXN0b3JhZ2UiLCJpYXQiOjE2NDQwNjY1Mzk5MDAsIm5hbWUiOiJhcnR1ciJ9.2qdiBjqeQoJzmtuwBjW8Nfs5mOCBb0sxWyza9rynU0g")
          .option(HttpOptions.readTimeout(10000)).asString
        (JsonMethods.parse(result.body) \ "cid").extract[String]
      }

      override def op_(byteArray: Array[Byte]): Unit = ???
    }
  }

//  object Obj {
//    implicit final val obj: Obj[File] = new Obj[File] {
//      override def op(cid: File): File = {
//
//      }
//    }
//  }
  object Syntax{
    object Arr{
      implicit class ArrOps[A](private val byteArray: Array[Byte]){
        def push()(implicit M: Arr[A]): A = M.op(byteArray)
      }
    }
  }
}
