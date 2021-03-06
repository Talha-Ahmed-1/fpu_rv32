import chisel3._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class FALUTest extends FreeSpec with ChiselScalatestTester {

  "FALU Test" in {
    test(new FALU()).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.input1.poke("h3F800000".U)    //4e4
      c.io.input2.poke("hBF800000".U)    //9e4   
      c.io.aluCtl.poke(10.U)             // expected output (47fde800)
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