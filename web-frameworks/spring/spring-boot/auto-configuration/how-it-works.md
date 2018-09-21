# How Auto-Configuration Works

- @EnableAutoConfiguration

- @Import(EnableAutoConfigurationImportSelector.class)

- SpringFactoriesLoader.loadFactoryNames(...)

- /META-INF/spring.factories

- o.s.b.a.EnableAutoConfiguration = o.s.b.a.SomeAutoConfig, ...
