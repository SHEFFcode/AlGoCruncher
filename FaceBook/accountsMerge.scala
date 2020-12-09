import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer
import scala.collection.mutable
object Solution {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val emailToName = HashMap[String, String]()
    val graph = HashMap[String, ListBuffer[String]]()

    for (account <- accounts) {
      val name = account.head
      val emails = account.tail
      val firstEmail = emails.head
      for (email <- emails) {
        graph(email) =
          graph.getOrElse(email, ListBuffer[String]()) += firstEmail
        graph(firstEmail) =
          graph.getOrElse(firstEmail, ListBuffer[String]()) += email
        emailToName(email) = name
      }
    }

    val seen = mutable.Set[String]()
    var ans = List[ListBuffer[String]]()

    for (email <- graph.keySet) {
      if (!seen.contains(email)) {
        seen += email
        var component = ListBuffer[String]()
        populateComponent(email, component, graph, seen)
        component = emailToName(email) +=: component.sorted
        ans = ans :+ component
      }
    }

    ans.map(_.toList)
  }

  def populateComponent(
      node: String,
      component: ListBuffer[String],
      graph: HashMap[String, ListBuffer[String]],
      seen: mutable.Set[String]
  ): Unit = {
    component += node
    for (neighbor <- graph(node)) {
      if (!seen.contains(neighbor)) {
        seen += neighbor
        populateComponent(neighbor, component, graph, seen)
      }
    }
  }
}

/*
G: accounts: List[List[String]]
O: mergedAccounts: List[List[String]]
T: O(N)
S: O(N)

Notes:
  -

Ex:

{
  0 -> ["johnsmith@mail.com", "john00@mail.com", "johnsmith@mail.com", "john_newyork@mail.com"],
  1 -> ["johnnybravo@mail.com"],
  3 -> ["mary@mail.com"]
}


{
  "johnsmith@mail.com" -> "john00@mail.com", "john_newyork@mail.com"
  "john00@mail.com" -> "johnsmith@mail.com"
  "johnnybravo@mail.com" -> ""

}

Input:
accounts = [
  ["John", "johnsmith@mail.com", "john00@mail.com"],
  ["John", "johnnybravo@mail.com"],
  ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
  ["Mary", "mary@mail.com"]
]

Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
 */
