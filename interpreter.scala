package SK.semantics

import SK.syntax
import SK.errors

object Interpreter extends App {
  var print = true

  val init : Result = App(I(), S()) // parse here

  // small step eval, invoked on the arguments of an App. transition from
  // Result and Result to Result.
  def eval(func: Result, arg:Result) : Result = func match {
    // if LHS is application, recurse and package
    case App(func1, arg1) ⇒ App(eval(func1, arg1), arg)

    // S rules
    case S0() ⇒ S1(arg)
    case S1(prev) ⇒ S2(prev, arg)
    // complicated, see syntax document
    case S2(prev, next) ⇒ App(App(prev, arg), App(next, arg))

    // K rules
    case K0() ⇒ K1(arg)
    case K1(arg) ⇒ arg
    // I rule
    case I() ⇒ arg
    //case _ ⇒ throw NoEvaluationRule
  }

  // loop until done
  var current : Result = init
  while (current <:< App) {
    current match {
      case // not doable, oops
    }
  }
}
