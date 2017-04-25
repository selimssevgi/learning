# Schema

- In Mongo, different documents can have different schema.

## Relational Model for Blog

```shell
## posts ##
# - post_id
# - author_id
# - title
# - post
# - date

## authors ##
# - author_id
# - user_name
# - password

## comments ##
# - comment_id
# - name
# - name
# - comment
# - email

## post_comments ##
# - post_id
# - comment_id

## tags ##
# - tag_id
# - name

## post_tags ##
# - post_id
# - tag_id
```

## Modeling Blog in Mongo

```shell
# posts
{
  title: "atitle", body: "body", author: "abc", date: "...",
  comments: [ {name: "aname", email: "@g.co", comment: "acomment"} ],
  tags: ["cycling", "education", "startups"]
}

# authors:
  {id: "can-be-unique-username", password: "hashed-pass"}

## do not need authors collection for home page, cus authors name is posts
collection already
```

## Intro Schema Design

- Embed or not embed
- Tags and comments are embedded in posts collections
- It is a design decision:
  - are you gonna need to access tags or comments separately?
  - Or you are gonna need them with the post that they are associated with

- Are you gonna change a tag from cycling to biking? Then it would be a problem
  to change the tag in different documents.
