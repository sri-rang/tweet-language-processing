This is micro example (less than 25 lines) to fetch a user's interests based on his tweets.

For a user:

1. Get timeline of user (and timeline of everyone he follows but Twitter API rate limit throws a spanner)

2. Fold text of tweets and convert to lowercase

3. Filter out non a-z chars and split into words

4. Filter out commonly used english words and create frequency map

5. Discard non-frequent words and return word-frequency list

*make sure to create `twitter4j.properties` file in src/main/resources*
