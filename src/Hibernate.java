import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate {
	private SessionFactory sessionFactory = null;

	public SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		return sessionFactory;
	}
}
