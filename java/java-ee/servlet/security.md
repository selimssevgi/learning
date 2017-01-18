# Notes on Servlet Security

- Tree main kinds of bad guys:
  1. Impersonators   : pretend to be someone else
  2. Upgraders       : sneaking in to premium members area
  3. Eavesdropppers  : stealing important data(credit card)

- Big four in servlet security:
  1. Authentication   : you are who you say you are? (against Impersonators)
  2. Authorization    : are you allowed to see it?   (against Upgraders)
  3. Confidentiality  : look at                      (against Eavesdroppers)
  4. Data integrity   : mess with                    (against Eavesdroppers)

- 95% of the security work you will do in servlets will be declarative.(xml)

- A realm is a place where authentication information is stored.

- If the programmer really wants to builder reusable components, hard-coding a
  role name is a Terrible Idea.

## The FOUR authentication types

1. *BASIC:* encoded(not encrypted), provides very weak security.

2. *DIGEST:* containers are not required to support it.

3. *CLIENT-CERT:* required a certificate, used mainly in B2B scenarios.

4. *FORM:* the above all three ways are browser pop-ups. The username and
   password are sent back in the HTTP request, with no encryption.

## tomcat-users.xml
- tomcat-users.xml applies to all applications deployed under web-apps. It's
  commonly known as the memory realm becuase Tomcat reads this file into memory
  at startup time.

- It is for testing not for production.
- Tomcat needs to be restarted in case of change in this file.
