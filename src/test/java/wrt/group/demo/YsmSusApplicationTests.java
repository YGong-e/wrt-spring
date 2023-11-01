package wrt.group.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wrt.group.demo.entity.Cluster;
import wrt.group.demo.entity.Users;

@SpringBootTest
class YsmSusApplicationTests {

	@PersistenceContext
	private EntityManager em;

	@Test
	void contextLoads() {

	}

}
