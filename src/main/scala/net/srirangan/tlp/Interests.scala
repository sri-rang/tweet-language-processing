package net.srirangan.tlp

import scala.collection.JavaConversions._
import twitter4j.TwitterFactory

object Interests {

  val twitter = TwitterFactory.getSingleton

  var common_words = scala.io.Source.fromFile("src/main/resources/common_words.csv")
    .mkString.replace(sys.props("line.separator"), "").split(",").toList

  def of_user(id: String) = {
    val tweets = twitter.getUserTimeline(id)
    val words = tweets.foldRight("")((status, acc) => acc + status.getText).toLowerCase.replaceAll("[^a-z ]", "").split(" ")
    words.filter(ignorables).groupBy(w => w).map(t => (t._1, t._2.length)).filter(t => t._2 > 1).toList.sortBy(_._2).reverse
  }

  def ignorables(word: String) = {
    !common_words.contains(word) && word.length > 3 && !word.startsWith("http") && !word.matches("^[a-z]?")
  }

}
