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
import chiseltest.formal.chaAnno._

class DecoupledGcdProp1(width: Int) extends DecoupledGcd(width: Int){
  //output.ready <> true.B

  val nBusy = !busy
  // failed: use BoundedCheck
  chaAssert(this,"busy |-> ##[1:15] nBusy") 
  // proved: use KInductionCheck 
  // chaAssert(this,"busy |-> ##[1:16] nBusy") 
}

class DecoupledGcdSpec extends AnyFlatSpec with ChiselScalatestTester with Formal {
  // emit a SystetmVerilog file
  // println(new (chisel3.stage.ChiselStage).emitSystemVerilog(new DecoupledGcdProp1(4)))
  behavior of "DecoupledGcd"
  it should "pass" in {
    verify(new DecoupledGcdProp1(4), Seq(BoundedCheck(150), BtormcEngineAnnotation))
    // verify(new DecoupledGcdProp1(4), Seq(KInductionCheck(20), PonoEngineAnnotation))

  }
}
