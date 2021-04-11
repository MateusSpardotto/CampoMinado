import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class HistoricoDAOImpl implements HistoricoDAO {

	@Override
	public void salvar(Historico historico) {
		Hibernate hibernate = new Hibernate();

		Session session = hibernate.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(historico);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Historico> listar() {
		Hibernate hibernate = new Hibernate();

		Session session = hibernate.getSessionFactory().openSession();
		session.beginTransaction();

		ArrayList<Historico> result = (ArrayList<Historico>) session.createQuery("from Historico").list();
		for (Historico dados : (List<Historico>) result) {
			System.out.println("Id:" + dados.getId());
			System.out.println("Data:" + dados.getData());
			System.out.println("Duracao:" + dados.getDuracao());

		}

		session.getTransaction().commit();
		session.close();
		return result;
	}
}
