object Solution {
  def numUniqueEmails(emails: Array[String]): Int = {
    val uniqueEmails = scala.collection.mutable.Set[String]()
    emails.foreach(email => {
      val emailArr = email.split('@')
      val local = emailArr(0)
      val domain = emailArr(1)

      val noDots = local.filterNot(_ == '.')
      val noPlus = noDots.split('+')(0) // Only want up to 1st +
      val uniqueEmail = noPlus + "@" + domain

      uniqueEmails += uniqueEmail
    })

    uniqueEmails.size
  }
}

/*
2 rules for email simplification:
  1) '.' rule => every instance of '.' between the first character and an @ sign will be stripped out
  2) '+' rule => everything between '+' and @ sign will be stripped out

Both rules can be applied at the same time.

These items can then be placed into a Set and its size can be returned.


Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

[ "test.email+alex@leetcode.com" , "test.e.mail+bob.cathy@leetcode.com" , "testemail+david@lee.tcode.com" ]
 *

result {
  "testemail@leetcode.com",
  "testemail@lee.tcode.com"
}
 */
