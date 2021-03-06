package genifer3

// An Atom is the most basic unit in Genifer logic.
// An Atom represents a basic concept.
// It is simply represented by an index.

// We also allow special Atoms that has no index (ie index = 0)
// to hold data items as Strings.
// Such Atoms are not concepts and they have no "place" in conceptual space.

// If the index is negative, it represents a Variable.  Variables are also not concepts.
// (This feature is now deprecated as variables are eliminated entirely)

class Atom {
  var index: Int = 0
  var str: String = null

  // Creates an ordinary Atom (ie, a concept)
  def this(i: Int) {
    this()
    this.index = i
    this.str = null
  }

  // If string begins with '!', creates an ordinary Atom by looking up the concept name
  // Otherwise creates a data Atom, ie, not a concept
  def this(s: String) {
    this()

    // if string begins with '!', look up the concept
    if (s(0) == '!') {
      this.index = Dictionary.invDictMap(s.substring(1))
      this.str = null
    }
    else {
      this.index = 0
      this.str = s
    }
  }

  // Is x a concept?
  def isConcept: Boolean = {
    this.index > 0
  }

  def ==(a: Atom) : Boolean = {
    if (this.index == 0)
      if (a.index == 0)
        a.str == this.str
      else
        false
    else
      a.index == this.index
  }

  // * Deprecated *
  // Is x a constant?
  def isConst: Boolean = {
    this.index >= 0
  }

  // * Deprecated *
  // Is x a variable?
  def isVariable: Boolean = {
    this.index < 0
  }
}

