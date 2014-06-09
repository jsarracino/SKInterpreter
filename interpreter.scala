package SK.semantics

import SK.syntax._
import SK.errors._

object Interpreter extends scala.App {
  var print = true

  //val init : Result = App(I(), S()) // parse here
  val init : Result = App(App(App(App(App(K(), K()), K()), S()), K()), S())

  // small step eval, invoked on the arguments of an App. transition from
  // Result and Result to Result.
  def eval(func: Result, arg:Result) : Result = func match {
    // if LHS is application, recurse and package
    case App(func1, arg1) ⇒ App(eval(func1, arg1), arg)

    // S rules
    case S() ⇒ S1(arg)
    case S1(prev) ⇒ S2(prev, arg)
    // complicated, see syntax document
    case S2(prev, next) ⇒ App(App(prev, arg), App(next, arg))

    // K rules
    case K() ⇒ K1(arg)
    case K1(arg) ⇒ arg
    // I rule
    case I() ⇒ arg
    //case _ ⇒ throw NoEvaluationRule
  }

  def evaluate(curr: Result) : Symbol = curr match {
    case App(lhs, rhs) ⇒ evaluate(eval(lhs, rhs))
    case res:Symbol ⇒ res
  }

  val result = evaluate(init)

  println(result)
}
