package ec.edu.upse.facsistel.spring.data;

import ec.edu.upse.facsistel.spring.data.dao.JdbcDaoImpl;
import ec.edu.upse.facsistel.spring.data.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}
