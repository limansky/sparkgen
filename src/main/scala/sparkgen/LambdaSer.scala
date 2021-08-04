package sparkgen

import org.apache.spark.Closurist

import java.io.{ ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream }

object LambdaSer {

  def main(args: Array[String]): Unit = {

    val calc = Generator.createCalculator

    val lambda = (x: Int) => calc.doMap(x)

    Closurist.clean(calc.doMap _)

    val calcSer = serialized(calc)

    println("result = " + calcSer.doMap(25))

  }

  private def serialized[T <: java.io.Serializable](t: T): T = {
    val bos = new ByteArrayOutputStream()
    val os = new ObjectOutputStream(bos)
    os.writeObject(t)
    os.flush()
    val bytes = bos.toByteArray

    val is = new ObjectInputStream(new ByteArrayInputStream(bytes))
    is.readObject().asInstanceOf[T]
  }
}
