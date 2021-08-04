package sparkgen

trait Calculator[T, U] extends Serializable {
  def doMap(t: T): U
}
