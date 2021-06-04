import scala.collection.immutable.{Map, Set}
object Solution {
  private val NAME = 0
  private val PARENT_EMAIL = 1
  private val NAME_AND_PARENT = 2
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val emailToName =
      accounts.map(a => a(PARENT_EMAIL) -> a(NAME)).toMap // email -> name

    val emailToParent = accounts.foldLeft(Map[String, String]()) {
      (ps, emails) =>
        emails.drop(NAME_AND_PARENT).foldLeft(ps) { (ps, cEmail) =>
          ps + (find(cEmail, ps) -> find(emails(PARENT_EMAIL), ps))
        }
    }

    val parentToChildren = accounts
      .foldLeft(Map[String, Set[String]]()) { (res, emails) =>
        // we don't want the name here, so we do .tail
        emails.tail.foldLeft(res) { (res, email) =>
          // parent email of this group can be a part of another union group
          val parent = find(emails(PARENT_EMAIL), emailToParent)
          val otherEmailsOfParent = res.getOrElse(parent, Set[String]())
          res + (parent -> (otherEmailsOfParent + email))
        }
      }

    parentToChildren.map(s => emailToName(s._1) +: s._2.toList.sorted).toList
  }

  private def find(m: String, emailToParent: Map[String, String]): String = {
    val parent = emailToParent.getOrElse(m, m) // find parent of this email
    if (parent == m) m // if you are the parent, return yourself
    else find(p, emailToParent) // if you are not the parent, keep looking
  }
}
