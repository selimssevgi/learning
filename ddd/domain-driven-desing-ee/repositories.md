# Repositories

- Associations allow us to find an object based on its relationship to another.
  But we must have a starting point for a traversal to an ENTITY or VALUE in the
  middle of its life cycle.

- A Customer object does not represent a new customer just because we stored it
  in a db and retrieved it. (This is the middle of the life cycle of an ENTITY)

- To keep  this distinction in mind, refer to the creation of an instance from
  stored data as "reconstitution"


A client needs a practical means of acquiring references to preexisting domain
objects. If the infrastructure makes it easy to do so, the developers of the
client may add more traversable associations, muddling the model. On the other
hand, they may use queries to pull the exact data they need from the db, o to
pull a few specific objects rather than navigating from AGGREGATE roots. Domain
logic moves into queries and client code, and the ENTITIES and VO become mere
data containers. The sheer technical complexity of applying most db access
infrastructure quickly swampls the client code, which leads developers to dum
down the domain layer, which makes the model irrelevant.

## Repositories with Factories

- A FACTORY handles the beginning of an object's life; a REPOSITORY helps manage
  the middle and the end.

- The reconstitution of a stored object is not the creation of a new conceptual object.

- In DDD, FACTORIES and REPOSITORIES have distinct responsibilities.

- The FACTORY makes new objects; the REPOSITORY finds old objects.
