package org.hibernate.bugs;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.bugs.entity.Computer;
import org.hibernate.bugs.entity.Employee;
import org.hibernate.bugs.entity.Person;
import org.hibernate.bugs.entity.Workplace;

import org.hibernate.bugs.entity.complex.*;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Stanislav Alekminskiy
 */
public class QueryGenerationTestCase extends BaseCoreFunctionalTestCase {

	@Before
	public void setupData() {
		Session session = openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		Workplace workplace = new Workplace( "location one" );
		session.persist( workplace );

		Person person = new Person( "John", "Doe" );
		session.persist( person );

		Employee employee = new Employee( person, workplace );
		session.persist( employee );

		Computer computer = new Computer( "1", workplace );
		session.persist( computer );

		workplace = new Workplace( "location two" );
		session.persist( workplace );

		person = new Person( "Jane", "Doe" );
		session.persist( person );

		employee = new Employee( person, workplace );
		session.persist( employee );

		tx.commit();
		session.close();
	}

	@Test
	public void testSQLGenerationForImplicitJoinInSelectClause() {
		Session session = openSession();

		Query query = session.createQuery(
				"select c.inventoryNumber from Employee e left join Computer c on c.workplace.id = e.workplace.id" );
		List resultList = query.list();
		Assert.assertThat( resultList.size(), is( 2 ) );

		query = session.createQuery(
				"select e.person.firstName, c.inventoryNumber from Employee e left join Computer c on c.workplace.id = e.workplace.id" );
		resultList = query.list();
		Assert.assertThat( resultList.size(), is( 2 ) );

		session.close();
	}

    @Test
    public void testRedundantSqlJoins() {
        Session session = openSession();

        Query query = session.createQuery("select min(pb.metalHeight), min(ba.cr), pd.pot.room.smelter.name from PotDates pd " +
                "left join PotBath pb on pb.potDates = pd left join BathAn ba on ba.potDates = pd " +
                "group by pd.pot.room.smelter.name");

        query.list();

        session.close();
    }

    @Test
    public void testEntityJoinWorkaround() {
        Session session = openSession();

        Query query = session.createQuery("select min(pb.metalHeight), pd.pot.room.smelter.name from PotDates pd " +
                "left join PotBath pb on pb.potDates.pot.room.smelter.smelterId = pd.pot.room.smelter.smelterId " +
                "and pb.potDates.pot.room.roomId = pd.pot.room.roomId and pb.potDates.pot.potId = pd.pot.potId " +
                "and pb.potDates.date = pd.date " +
                "group by pd.pot.room.smelter.name");

        query.list();

        session.close();
    }

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class[] {
				Person.class,
				Employee.class,
				Workplace.class,
				Computer.class,

				Smelter.class,
				Room.class,
				Pot.class,
				PotDates.class,
				PotBath.class,
				BathAn.class
		};
	}
}
