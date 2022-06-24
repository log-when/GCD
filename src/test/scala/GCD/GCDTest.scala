/*
 * Dummy tester to start a Chisel project.
 *
 * Author: Martin Schoeberl (martin@jopdesign.com)
 * 
 */

package GCD

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should._
import chiseltest.formal._
import chiseltest.formal.svaSeq._

class DecoupledGcdProp1(width: Int) extends DecoupledGcd(width: Int){
  //output.ready <> true.B
  svaSeqAnno.makeSVAAnno(this.reset, ap(busy) |->  ###(1,15) ap(!busy))
}

class DecoupledGcdSpec extends AnyFlatSpec with ChiselScalatestTester with Formal {
  behavior of "DecoupledGcd"
  it should "pass" in {
    verify(new DecoupledGcdProp1(4), Seq(BoundedCheck(150), BtormcEngineAnnotation))
  }
}
