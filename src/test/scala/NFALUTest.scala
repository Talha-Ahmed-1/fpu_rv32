import chisel3._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class NFALUTest extends FreeSpec with ChiselScalatestTester {

  "NFALU Test" in {
    test(new NFALU()).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.input1.poke("hC1B00000".U)
      c.io.input2.poke("h41B66666".U)
      c.io.aluCtl.poke(10.U)
      c.clock.step(100)
    }
  }
}













// Working
    //   c.io.instIn.poke("h952E9426".U)
    //   c.io.pcIn.poke(12.U)
    //   c.clock.step(1)
    // //   c.io.pcIn.poke(c.io.pcOut.peek)
    // //   c.clock.step(1)
    //   c.io.pcIn.poke(c.io.pcOut.peek)
    //   c.io.instIn.poke("h00940433".U)
    //   c.clock.step(1)
    //   c.io.pcIn.poke(c.io.pcOut.peek)
    //   c.clock.step(1)
    //   c.io.instIn.poke("h952E9426".U)
    //   c.io.pcIn.poke(c.io.pcOut.peek)
    //   c.clock.step(1)
    //   c.io.pcIn.poke(c.io.pcOut.peek)
    //   c.clock.step(1)
    //   c.io.pcIn.poke(c.io.pcOut.peek)
    //   c.io.instIn.poke("h00940433".U)