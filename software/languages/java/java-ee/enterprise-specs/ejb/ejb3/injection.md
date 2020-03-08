# injection in ejb

- supports field and setter injection

- does not support constructor injection

- cdi support constructor injection

- annotations: @EJB, @Resource

- uses jndi as underlying structure

- jndi lookup(with new InitialContext) should be avoided as much as possible,
  that was the complexity of ejb2
