package SK.syntax

// model everything as function applications, and symbols. curry via intermediate
// symbols.
sealed abstract class Result
sealed abstract class Symbol extends Result


// S combinator takes in three functions, passes the third
// as argument to the first two.
// In tree terms:

//
//                                        /\
//                                       /  \
//                                      /    \
//              /\                     /      \
//             /  \                   /        \
//            /\   \        =>       /          \
//           /  \   \               /\          /\
//          /\   \   \             /  \        /  \
//         /  \   \   \           /    \      /    \
//        S   fst snd arg       fst   arg    snd   arg
//
case class S0() extends Symbol
case class S1(fst : Symbol) extends Symbol
case class S2(fst : Symbol, snd: Symbol) extends Symbol


// K combinator takes in two functions, takes the first.
// In tree terms:

//          /\
//         /  \
//        /\   \          =>
//       /  \   \
//      K   tk  rej             tk
//
case class K() extends Symbol
case class K0(tk: Symbol) extends Symbol

// I(dentity) combinator takes in one function, returns it.
// In tree terms:


//       /\
//      /  \             =>
//     /    \
//    I     inn                 inn
//
case class I() extends Symbol

// actual applications
case class App(lhs : Result, rhs: Result) extends Result
