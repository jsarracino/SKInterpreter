package SK.syntax

// everything is a tree... we use options to indicate
// that computation is done/undone.

sealed abstract class Tree
type Basic = Option[Tree]

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
case class S(fst: Basic, snd: Basic, arg: Basic) extends Tree


// K combinator takes in two functions, takes the first.
// In tree terms:

//          /\
//         /  \
//        /\   \          =>
//       /  \   \
//      K   tk  rej             tk
//
case class K(tk: Basic, rej: Basic) extends Tree

// I(dentity) combinator takes in one function, returns it.
// In tree terms:


//       /\
//      /  \             =>
//     /    \
//    I     inn                 inn
//
case class I(inn: Basic) extends Tree
