package GCD

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should._
import chiseltest.formal._
import chiseltest.formal.chaAnno._

class DecoupledGcdProp1(width: Int) extends DecoupledGcd(width: Int){
  
  val nBusy = !busy

  // testcase 6 
  // chaAssume(this,"F busy")
  // chaAssert(this,"##1 busy") 
  // chaAssert(this,"busy |-> ##[1:15] nBusy") 
  // chaAssert(this,"busy -> ##[1:16] nBusy") 
  // chaAssert(this,"busy U nBusy")

  // testcase 7 
  // passed
  // chaAssert(this,"busy |-> ##[1:16] nBusy") 
  // failed
  // chaAssert(this,"busy |-> ##[1:15] nBusy") 

  // testcase 8 
  // passed
  // chaAssert(this,"busy |-> ##[1:16] nBusy") 
  // chaAssert(this,"busy |-> ##[1:15] nBusy") 
  
  // testcase 12
  // triggered
  // chaCover(this,"busy && (busy |-> busy[*6] ##1 nBusy)") 
  // chaCover(this,"!(G (##1 busy))") 
  // chaCover(this,"!(busy |-> ##[1:15] nBusy)") 
  // not triggered
  // chaCover(this,"!(busy |-> ##[1:16] nBusy)") 
  // chaCover(this,"!(busy U nBusy)")

}

class DecoupledGcdSpec extends AnyFlatSpec with ChiselScalatestTester with Formal {
  // emit a SystetmVerilog file
  // println(new (chisel3.stage.ChiselStage).emitSystemVerilog(new DecoupledGcdProp1(4)))
  behavior of "DecoupledGcd"
  it should "pass" in {
    // testcase 6 
    // verify(new DecoupledGcdProp1(4), Seq(BoundedCheck(150), BtormcEngineAnnotation, GenTsOnly))
    // testcase 7 
    // verify(new DecoupledGcdProp1(4), Seq(BoundedCheck(20), BtormcEngineAnnotation))
    // testcase 8 
    // verify(new DecoupledGcdProp1(4), Seq(KInductionCheck(20), EnSafetyOpti, PonoEngineAnnotation))
    // verify(new DecoupledGcdProp1(4), Seq(BoundedCheck(20), PonoEngineAnnotation))
    // testcase 12
    // verify(new DecoupledGcdProp1(4), Seq(BoundedCheck(100), PonoEngineAnnotation))

  }
}
