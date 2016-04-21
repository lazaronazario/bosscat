package Teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Final {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatetest");
		//EntityManagerFactory factory  = Persistence.createEntityManagerFactory("bossket");
		
		emf.close();

	}

		}

