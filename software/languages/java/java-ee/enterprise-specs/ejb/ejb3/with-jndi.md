# jndi and ejb

- jndi is essentially the application server's managed resource registry

- all ejbs automatically get bound to jndi as soon as the container discovers them

- containers use session bean annotations to bind the ejbs to the global jndi tree

- you wont have to deal with jndi directly in ejb3
- ejb3 hides the mechanical details of jndi lookups behind metadata-based DI
