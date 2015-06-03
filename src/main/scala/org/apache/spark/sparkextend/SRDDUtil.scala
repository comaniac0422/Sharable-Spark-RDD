package org.apache.spark.sparkextend

import org.apache.spark.rdd._
import java.net._

// comaniac: Import extended package
import org.apache.spark.sparkextend._

// comaniac: Import Akka packages
import akka.actor._

object ExitCode extends Enumeration {
  type ExitCode = Value
  val EXIT_SUCCESS = Value
  val EXIT_FAILURE = Value
  val CREATE_SUCCESS = Value
  val CREATE_FAILURE = Value
  val CREATE_IGNORE = Value
}

trait SRDDControl extends Serializable
object SRDDControls {
  
  case class Test(name: String) extends SRDDControl

  case class ObjectFile(
    name: String, 
    path: String, 
    minPartitions: Int
    ) extends SRDDControl

  case class TextFile(
    name: String,
    path: String,
    minPartitions: Int
    ) extends SRDDControl

  case class Count(
    name: String
    ) extends SRDDControl
}

import ExitCode._
class ReturnValue {
  var exitCode: ExitCode = EXIT_SUCCESS
  var returnCount: Long = -1

  def setExitCode(v: ExitCode) { exitCode = v }
  def getExitCode(): ExitCode = { exitCode }

  def setReturnCount(v: Long) { returnCount = v }
  def getReturnCount(): Long = { returnCount; }
}
