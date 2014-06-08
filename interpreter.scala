package SK.semantics

import SK.syntax
import scala.annotation.tailrec

object Interpreter {
  var print = true


  @tailrec def eval(expr: Tree) : Tree {
    val res = expr match {
      case I(inner) ⇒ inner match {case Some(tre) ⇒ eval(tre); _ ⇒ expr}
      case K(tk, rej) ⇒ tk match {
        case Some(tre) ⇒ if (rej.isEmpty) expr else eval(tre)
        case _ ⇒ expr
      }

      // the actual hard one...
      case S(lhs, rhs, arg) ⇒ {
        val innerRes = for {
          rite <- lhs
          left <- rhs
          app <- arg // here
        }
      }

    }
  }
}
