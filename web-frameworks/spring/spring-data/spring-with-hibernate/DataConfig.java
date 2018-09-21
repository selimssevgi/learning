


@Configuration
@PropertySource("app.properties")
public class DataConfig {

  @Autowired
  private Environment env; // loads all properties from app.properties

  @Bean // from hibernate5
  public LocalSessionFactoryBean sessionFactory() {
     Resource config = new ClassPathResource("hibernate.cfg.xml");
     LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
     sessionFactory.setConfigLocation(config);
     // screate app.properties in resources to externalize instead of hardcoding
     // appname.entity.package = com.selimssevgi.appname.model
     sessionFactory.setPackagesToScan(env.getProperty("appname.entity.package"));
     sessionFactory.setDataSource(dataSource());
     return sessionFactory;
  }

  @Bean // could be private, but it is bean has to be public
  public DataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    // driver class name
    ds.setDriverClassName(env.getProperty("appname.db.driver"));
    //  set url
    ds.setUrl(env.getProperty("appname.db.url"))
    //  set username & password
    ds.setUsername(env.getProperty("appname.db.username"));
    ds.setUsername(env.getProperty("appname.db.password"));

    return ds;
  }

}
